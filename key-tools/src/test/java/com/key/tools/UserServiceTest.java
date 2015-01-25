package com.key.tools;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.tools.member.db.dao.UserMapper;
import com.key.tools.member.db.model.User;
import com.key.tools.member.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest
{

	@Autowired
	UserService userService;
	
	@Test
	public void testAdd()
	{
		long id=userService.addUser();
		Assert.assertTrue(id>0);
	}
	
	@Test
	public void testDeleteUser()
	{
		userService.deleteUser(3L);
		User user=userService.getUserById(3L);
		Assert.assertNull(user);
	}
	
	public void test()
	{
		
	}
}
