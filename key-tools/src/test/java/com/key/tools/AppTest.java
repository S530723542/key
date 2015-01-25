package com.key.tools;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Target;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.key.tools.common.RestResult;
import com.key.tools.http.HttpAgent;
import com.key.tools.member.service.QQLoginService;
import com.key.tools.stock.pojo.BaiduRetData;
import com.key.tools.stock.pojo.BaiduStockJson;
import com.key.tools.stock.pojo.SinaData;
import com.key.tools.stock.pojo.SinaStock;
import com.key.tools.test.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest
{

	@Autowired
	TestService testService;

	@Autowired
	@Qualifier(value = "httpAgent")
	HttpAgent httpAgent;

//	@Test
//	public void test() throws UnsupportedEncodingException
//	{
//
//		String url = "http://apistore.baidu.com/microservice/stock";
//
//		String code = "sz002230";
//
//		HashMap<String, Object> params = new HashMap<String, Object>();
//
//		params.put("stockid", code);
//		try
//		{
//			RestResult<String> result = httpAgent.getAndRetry(url, params);
//
//			if (result.getErrCode() < 0)
//			{
//				System.out
//						.println("******************************************");
//				System.out.println(result.getErrCode());
//				System.out.println(result.getErrMsg());
//				System.out
//						.println("******************************************");
//			}
//			Gson gson = new Gson();
//			BaiduStockJson stockJson = gson.fromJson(result.getData(),
//					BaiduStockJson.class);
//			System.out.println("******************************************");
//			System.out.println(stockJson.getErrNum());
//			System.out.println(stockJson.getErrMsg());
//			System.out.println(stockJson.getRetData().getKlinegraph()
//					.getDayurl());
//			System.out.println(stockJson.getRetData().getMarket().getShanghai()
//					.getName());
//			System.out.println(stockJson.getRetData().getStockinfo().getName());
//			System.out.println(stockJson.getRetData().getStockinfo().getTime());
//			System.out.println("******************************************");
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void sinaStockTest()
//	{
//		String url = "http://hq.sinajs.cn/list=";
//
//		String code = "sz002230";
//		
//		url=url+code;
//
//		HashMap<String, Object> params = new HashMap<String, Object>();
//
//		try
//		{
//			RestResult<String> result = httpAgent.getAndRetry(url, params);
//
//			if (result.getErrCode() < 0)
//			{
//				System.out
//						.println("******************************************");
//				System.out.println(result.getErrCode());
//				System.out.println(result.getErrMsg());
//				System.out
//						.println("******************************************");
//			}
//			SinaStock sinaStock = new SinaStock();
//			SinaData sinaData = new SinaData();
//			sinaData.parse(result.getData());
//			System.out.println("******************************************");
//
//			System.out.println(sinaData.getData());
//			System.out.println("******************************************");
//			sinaStock.parseSinaStockString(sinaData.getData());
//
//			System.out.println("******************************************");
//
//			System.out.println(sinaStock);
//			System.out.println("******************************************");
//
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//	}
	
	@Test
	public void downloadTest()
	{
		String url = "http://ichart.yahoo.com/table.csv";

		String code = "002230.sz";
		


		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("s", code);

		try
		{
			RestResult<String> result = httpAgent.getAndRetry(url, params);
			
			System.out.println("******************************************");

			System.out.println(result.getData());
			System.out.println("******************************************");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
