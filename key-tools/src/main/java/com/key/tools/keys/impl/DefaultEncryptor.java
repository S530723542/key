package com.key.tools.keys.impl;

import com.key.tools.keys.Encryptor;

public class DefaultEncryptor implements Encryptor
{

	@Override
	public String encrypt(String data)
	{
		return data;
	}

	@Override
	public String decrypt(String data)
	{
		return data;
	}

	@Override
	public String encrypt(String data, String charset)
	{
		return data;
	}

	@Override
	public String decrypt(String data, String charset)
	{
		return data;
	}

}
