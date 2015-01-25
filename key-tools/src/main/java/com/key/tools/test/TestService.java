package com.key.tools.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.key.tools.member.db.dao.UserMapper;
import com.key.tools.member.db.model.User;

@Service
public class TestService
{
//	@Autowired
//	UserMapper userMapper;

//	@Transactional
//	public void testForUpdate(int i) throws InterruptedException
//	{
//		System.out.println(i + "  进入update");
//		User user = userMapper.selectByPrimaryKey(1L);
//		System.out.println(i + "  原有的password：" + user.getPassword());
//		user.setPassword(user.getPassword() + "update!");
//		userMapper.updateByPrimaryKey(user);
//		System.out.println(i + "  更新password：" + user.getPassword());
//		user.setId(null);
//		userMapper.insertSelective(user);
//		for (int j = 0; j < 10; j++)
//		{
//			Thread.sleep(1000);
//			System.out.println(i + "  等待" + j + "秒！");
//		}
//		throw new RuntimeException("异常！");

//		System.out.println(i + "  结束！");

//	}
}
