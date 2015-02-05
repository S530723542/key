package com.key.tools;

import com.key.tools.keys.Encryptor;
import com.key.tools.keys.KeyFactory;
import com.key.tools.keys.KeyFactory.KeyType;

/**
 * Hello world!
 *
 */
public class App
{

	public static void main(String[] args) throws Exception
	{
		String data = "test";
		String data1 = null;
		String data2 = null;
		Encryptor encryptor = KeyFactory.generateEncryptor(KeyType.DEFAULT);
		data1 = encryptor.encrypt(data);
		data2 = encryptor.decrypt(data1);
		System.out.println(data);
		System.out.println(data1);
		System.out.println(data2);
		System.out.println("Hello World!");
	}

}
