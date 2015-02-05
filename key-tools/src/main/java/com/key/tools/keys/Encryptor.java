package com.key.tools.keys;

import java.io.UnsupportedEncodingException;

public interface Encryptor
{
	public String encrypt(String data, String charset) throws UnsupportedEncodingException;

	/**
	 * 默认编码UTF-8
	 * @param data
	 * @return
	 */
	public String encrypt(String data) throws UnsupportedEncodingException;

	/**
	 * 默认编码UTF-8
	 * @param data
	 * @return
	 */
	public String decrypt(String data) throws UnsupportedEncodingException;

	public String decrypt(String data, String charset) throws UnsupportedEncodingException;
}
