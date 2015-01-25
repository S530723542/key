package com.key.tools;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.tools.member.service.QQLoginService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration("classpath:applicationContext.xml")
public class QQLoginServiceTest
{

	@Autowired
	QQLoginService qqLoginService;
	
	@Test
	public void loginByQQTest()
	{
		long id1=qqLoginService.loginByQQ(2321, "test11");
		long id2=qqLoginService.loginByQQ(2321, "test11");
		Assert.assertTrue(id1>0);
		Assert.assertEquals(id1, id2);
	}
	
	@Test
	public void updateQQTest()
	{
		qqLoginService.updateQQ(6L, 530);
		qqLoginService.updateQQ(6L, 531);
		long id=qqLoginService.getUserIdByQQ(531);
		Assert.assertTrue(id==6L);
	}
	
}
