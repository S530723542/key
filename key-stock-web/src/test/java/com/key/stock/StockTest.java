package com.key.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.tools.http.HttpAgent;
import com.key.tools.stock.service.StockHistoryService;


@RunWith(SpringJUnit4ClassRunner.class)
//使用junit4进行测试
@ContextConfiguration("classpath:com/key/stock/applicationContext.xml")
public class StockTest
{
	@Autowired
	@Qualifier(value = "httpAgent")
	HttpAgent httpAgent;
	
	@Autowired
	StockHistoryService stockHistoryService;
	
	@Test
	public void getHistoryTest()
	{
		stockHistoryService.addHistoryRecord(null, null, null, null);
	}
}
