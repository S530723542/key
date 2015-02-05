package com.key.tools.keys;

import com.key.tools.keys.impl.Base64Encryptor;
import com.key.tools.keys.impl.DefaultEncryptor;

public class KeyFactory
{
	public enum KeyType
	{
		DEFAULT, BASE64
	};

	public static Encryptor generateEncryptor(KeyType type)
	{
		Encryptor encryptor = null;
		if (type==null)
		{
			return new DefaultEncryptor();
		}
		switch (type)
		{
		case DEFAULT:
			encryptor = new DefaultEncryptor();
			break;
		case BASE64:
			encryptor = new Base64Encryptor();
			break;

		default:
			encryptor = new DefaultEncryptor();
			break;
		}
		return encryptor;
	}
}
