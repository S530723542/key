package com.key.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.tools.stock.service.StockService;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration("classpath:applicationContext.xml")
public class StockServiceTest
{
	@Autowired
	StockService stockService;

	@Test
	public void insert() throws Exception
	{
		String s = null;
		String[] ss = null;
		String value = null;
		String name;
		String code = null;
		String exChange = null;
		
		File sz = new File("D:/gitlab/my/tools/doc/stock/sz.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(sz),"gbk"));
		exChange = "sz";
		while ((s = br.readLine()) != null)
		{
			if (s.trim().length()==0)
			{
				continue;
			}

			ss = s.split("<|>");
			value = ss[4];
			ss = value.split("\\(|\\)");
			name = ss[0];
			code = ss[1];
			System.out.println("****************************");
			System.out.println(name);
			System.out.println(code);
			System.out.println("****************************");
			try
			{
				stockService.addStock(exChange, code, name);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		br.close();
		
		
		///////////////////////////////////////////////////////////////
		
		
		File sh = new File("D:/gitlab/my/tools/doc/stock/sh.txt");
		br = new BufferedReader(new InputStreamReader(
				new FileInputStream(sh),"gbk"));
		exChange = "sh";
		while ((s = br.readLine()) != null)
		{
			if (s.trim().length()==0)
			{
				continue;
			}

			ss = s.split("<|>");
			value = ss[4];
			ss = value.split("\\(|\\)");
			name = ss[0];
			code = ss[1];
			System.out.println("****************************");
			System.out.println(name);
			System.out.println(code);
			System.out.println("****************************");
			try
			{
				stockService.addStock(exChange, code, name);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		br.close();
	}
}
