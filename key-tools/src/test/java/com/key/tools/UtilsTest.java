package com.key.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.tools.common.CycleQueue;
import com.key.tools.stock.service.KLineAnaService;

@RunWith(SpringJUnit4ClassRunner.class)
//使用junit4进行测试
@ContextConfiguration("classpath:com/key/tools/applicationContext.xml")
public class UtilsTest
{
	@Autowired
	KLineAnaService kLineAnaService;
	@Test
	public void cycqueueTest()
	{
		CycleQueue<Integer> cycleQueue = new CycleQueue<Integer>(3);
		cycleQueue.addCyc(1);

		
		cycleQueue.addCyc(2);

		
		cycleQueue.addCyc(3);


		for (int i = 0; i < cycleQueue.size(); i++)
		{
			System.out.println(cycleQueue.get(i));
		}
		System.out.println("********************************");
		
		cycleQueue.addCyc(4);cycleQueue.addCyc(5);
		

		for (int i = 0; i < cycleQueue.size(); i++)
		{
			System.out.println(cycleQueue.get(i));
		}
	}

}
