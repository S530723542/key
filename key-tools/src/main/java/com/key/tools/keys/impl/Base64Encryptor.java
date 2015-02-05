package com.key.tools.keys.impl;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import com.key.tools.keys.Encryptor;

public class Base64Encryptor implements Encryptor
{
	private final String CHARSET = "UTF-8";

	@Override
	public String encrypt(String data) throws UnsupportedEncodingException
	{
		byte[] bytes = data.getBytes(CHARSET);
		String encryptData = Base64.encodeBase64String(bytes);
		return encryptData;
	}

	@Override
	public String decrypt(String data) throws UnsupportedEncodingException
	{
		byte[] bytes = Base64.decodeBase64(data);
		String decryptData = new String(bytes, CHARSET);
		return decryptData;
	}

	@Override
	public String encrypt(String data, String charset)
			throws UnsupportedEncodingException
	{
		byte[] bytes = data.getBytes(charset);
		String encryptData = Base64.encodeBase64String(bytes);
		return encryptData;
	}

	@Override
	public String decrypt(String data, String charset)
			throws UnsupportedEncodingException
	{
		byte[] bytes = Base64.decodeBase64(data);
		String decryptData = new String(bytes, charset);
		return decryptData;
	}

}
