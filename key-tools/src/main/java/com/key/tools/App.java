package com.key.tools;

import java.util.Date;

import com.key.tools.stock.pojo.ExCode;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args)
	{
		String s = "<li><a target=\"_blank\" href=\"http://quote.eastmoney.com/sz000001.html\">平安银行(000001)</a></li>";
		String[] ss = s.split("<|>");

		System.out.println(ss[4]);
		String value = ss[4];
		ss = value.split("\\(|\\)");
		String name = ss[0];
		System.out.println(name);
		String code = ss[1];
		
		System.out.println(code);
		System.out.println("Hello World!");
	}
}
