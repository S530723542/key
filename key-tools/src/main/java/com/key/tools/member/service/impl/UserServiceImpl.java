package com.key.tools.member.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.key.tools.common.DBConstant;
import com.key.tools.common.ErrCode;
import com.key.tools.member.db.dao.UserMapper;
import com.key.tools.member.db.model.User;
import com.key.tools.member.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	Logger		logger	= Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper	userMapper;

	@Override
	@Transactional
	public long addLocalLogin(String name, Integer phone, String email,
			String password)
	{
		User user = new User();
		// userName检查
		if (name != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setUserName(name);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setUserName(name);

			} else
			{
				logger.warn("[addUser] : [name:" + name
						+ "] name is already exist!");
				if (list.size() > 1)
				{
					logger.error("[addUser] : [name:" + name + "] [size:"
							+ list.size()
							+ "] name is already exist! and more than one!");
				}
				return ErrCode.NAME_EXIST;
			}
		}

		// phone检查
		if (phone != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setPhone(phone);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setPhone(phone);

			} else
			{
				logger.warn("[addUser] : [phone:" + phone
						+ "] phone is already exist!");
				if (list.size() > 1)
				{
					logger.error("[addUser] : [phone:" + phone + "] [size:"
							+ list.size()
							+ "] phone is already exist! and more than one!");
				}
				return ErrCode.PHONE_EXIST;
			}
		}

		// email检查
		if (email != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setEmail(email);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setEmail(email);

			} else
			{
				logger.warn("[addUser] : [email:" + email
						+ "] email is already exist!");
				if (list.size() > 1)
				{
					logger.error("[addUser] : [email:" + email + "] [size:"
							+ list.size()
							+ "] email is already exist! and more than one!");
				}
				return ErrCode.EMAIL_EXIST;
			}
		}

		user.setIsDelete(DBConstant.IS_AVAILABLE);
		user.setPassword(password);
		Date now = new Date(System.currentTimeMillis());
		user.setCreateTime(now);
		user.setMotifyTime(now);
		userMapper.insertAndReturnId(user);
		logger.info("[addLocalLogin] : [name:" + name + "], [phone:" + phone
				+ "], [email:" + email + "], [password:" + password + "] SUCCESS!");
		return user.getId();
	}

	@Override
	public User getUserByName(String name)
	{
		User record = new User();
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setUserName(name);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return null;
		} else if (list.size() == 1)
		{
			return list.get(0);
		} else
		{
			logger.error("[getUserByName] : [name:" + name + "] [size:"
					+ list.size() + "] name is exist and more than one!");
			return null;
		}

	}

	@Override
	public User getUserByPhone(Integer phone)
	{
		User record = new User();
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setPhone(phone);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return null;
		} else if (list.size() == 1)
		{
			return list.get(0);
		} else
		{
			logger.error("[getUserByPhone] : [phone:" + phone + "] [size:"
					+ list.size() + "] phone is exist and more than one!");
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email)
	{
		User record = new User();
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setEmail(email);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return null;
		} else if (list.size() == 1)
		{
			return list.get(0);
		} else
		{
			logger.error("[getUserByEmail] : [email:" + email + "] [size:"
					+ list.size() + "] email is exist and more than one!");
			return null;
		}
	}

	@Override
	public int deleteUser(Long id)
	{

		User user = userMapper.selectByPrimaryKey(id);
		if (user == null || DBConstant.IS_DELETE.equals(user.getIsDelete()))
		{
			return ErrCode.NOT_EXIST;
		}
		User record = new User();
		record.setId(id);
		record.setIsDelete(DBConstant.IS_DELETE);
		Date now = new Date(System.currentTimeMillis());
		record.setMotifyTime(now);
		userMapper.updateByPrimaryKeySelective(record);
		return ErrCode.SUCCESS;
	}

	@Override
	@Transactional
	public int updateLocalLoginMsg(Long id, String name, Integer phone,
			String email)
	{
		User user = new User();
		// userName检查
		if (name != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setUserName(name);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setUserName(name);

			} else
			{
				logger.warn("[updateUserMsg] : [name:" + name
						+ "] name is already exist!");
				if (list.size() > 1)
				{
					logger.error("[updateUserMsg] : [name:" + name + "] [size:"
							+ list.size()
							+ "] name is already exist! and more than one!");
				}
				return ErrCode.NAME_EXIST;
			}
		}

		// phone检查
		if (phone != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setPhone(phone);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setPhone(phone);

			} else
			{
				logger.warn("[updateUserMsg] : [phone:" + phone
						+ "] phone is already exist!");
				if (list.size() > 1)
				{
					logger.error("[addUser] : [phone:" + phone + "] [size:"
							+ list.size()
							+ "] phone is already exist! and more than one!");
				}
				return ErrCode.PHONE_EXIST;
			}
		}

		// email检查
		if (email != null)
		{
			User record = new User();
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setEmail(email);
			List<User> list = userMapper.selectBySelectiveForUpdate(record);
			if (list.size() == 0)
			{
				user.setEmail(email);

			} else
			{
				logger.warn("[updateUserMsg] : [email:" + email
						+ "] email is already exist!");
				if (list.size() > 1)
				{
					logger.error("[updateUserMsg] : [email:" + email
							+ "] [size:" + list.size()
							+ "] email is already exist! and more than one!");
				}
				return ErrCode.EMAIL_EXIST;
			}
		}
		user.setId(id);
		Date now = new Date(System.currentTimeMillis());
		user.setMotifyTime(now);
		userMapper.updateByPrimaryKeySelective(user);
		return ErrCode.SUCCESS;
	}

	@Override
	@Transactional
	public int motifyPassword(Long id, String password, String newPassword)
	{
		User user = userMapper.selectByPrimaryKeyForUpdate(id);
		if (user == null || DBConstant.IS_DELETE.equals(user.getIsDelete()))
		{
			return ErrCode.NOT_EXIST;
		}
		if (!user.getPassword().equals(password))
		{
			return ErrCode.NOT_MATCH;
		}
		User record = new User();
		record.setId(id);
		Date now = new Date(System.currentTimeMillis());
		record.setMotifyTime(now);
		record.setPassword(newPassword);
		userMapper.updateByPrimaryKeySelective(record);
		logger.info("[motifyPassword] : [id:"+id+"] SUCCESS!");
		return ErrCode.SUCCESS;
	}

	@Override
	public long verifyPasswordByName(String name, String password)
	{
		User record = new User();
		record.setUserName(name);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return ErrCode.NOT_EXIST;
		} else if (list.size() > 1)
		{
			logger.error("[getUserByName] : [name:" + name + "] [size:"
					+ list.size() + "] name is exist and more than one!");
			return ErrCode.MORE_THAN_ONE;
		}
		User user = list.get(0);
		if (!user.getPassword().equals(password))
		{
			return ErrCode.NOT_MATCH;
		} else
		{
			return user.getId();
		}

	}

	@Override
	public long verifyPasswordByPhone(Integer phone, String password)
	{
		User record = new User();
		record.setPhone(phone);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return ErrCode.NOT_EXIST;
		} else if (list.size() > 1)
		{
			logger.error("[getUserByName] : [phone:" + phone + "] [size:"
					+ list.size() + "] name is exist and more than one!");
			return ErrCode.MORE_THAN_ONE;
		}
		User user = list.get(0);
		if (!user.getPassword().equals(password))
		{
			return ErrCode.NOT_MATCH;
		} else
		{
			return user.getId();
		}
	}

	@Override
	public long verifyPasswordByEmail(String email, String password)
	{
		User record = new User();
		record.setEmail(email);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		List<User> list = userMapper.selectBySelective(record);

		if (list.size() == 0)
		{
			return ErrCode.NOT_EXIST;
		} else if (list.size() > 1)
		{
			logger.error("[getUserByName] : [email:" + email + "] [size:"
					+ list.size() + "] name is exist and more than one!");
			return ErrCode.MORE_THAN_ONE;
		}
		User user = list.get(0);
		if (!user.getPassword().equals(password))
		{
			return ErrCode.NOT_MATCH;
		} else
		{
			return user.getId();
		}
	}

	@Override
	public long addUser()
	{
		User user = new User();
		user.setIsDelete(DBConstant.IS_AVAILABLE);
		Date now = new Date(System.currentTimeMillis());
		user.setCreateTime(now);
		user.setMotifyTime(now);
		 userMapper.insertAndReturnId(user);
		logger.info("[addUser] : [id:"+user.getId()+"] SUCCESS!");
		return user.getId();
	}

	@Override
	public User getUserById(Long id)
	{
		User user=userMapper.selectByPrimaryKey(id);
		if (user==null||DBConstant.IS_DELETE.equals(user.getIsDelete()))
		{
			return null;
		}
		return user;
	}

	@Override
	@Transactional
	public int setPassword(Long id, String password)
	{
		User record=new User();
		record.setId(id);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		List<User> list=userMapper.selectBySelectiveForUpdate(record);
		if (list.size() == 0)
		{
			return ErrCode.NOT_EXIST;
		} else if (list.size() > 1)
		{
			logger.error("[setPassword] : [id:" + id + "] [size:"
					+ list.size() + "] name is exist and more than one!");
			return ErrCode.MORE_THAN_ONE;
		}
		User user = list.get(0);
		if (user.getPassword()!=null)
		{
			return ErrCode.NOT_MATCH;
		}
		user=new User();
		user.setId(id);
		user.setPassword(password);
		userMapper.updateByPrimaryKeySelective(user);
		return ErrCode.SUCCESS;
	}

}
