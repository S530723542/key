package com.key.stock.controller.rest;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.key.stock.pojo.UserBaseMsgVO;
import com.key.tools.common.ErrCode;
import com.key.tools.common.RestResult;
import com.key.tools.member.db.model.User;
import com.key.tools.member.service.UserService;

public class UserControllerRest
{
	private Logger logger = Logger.getLogger(UserControllerRest.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "stock/login", method = RequestMethod.GET)
	public @ResponseBody RestResult<UserBaseMsgVO> login(ModelMap model,
			HttpSession session,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password)
	{
		RestResult<UserBaseMsgVO> restResult = new RestResult<UserBaseMsgVO>();
		try
		{
			long id = userService.verifyPasswordByName(username, password);
			if (id == ErrCode.SUCCESS)
			{
				restResult.setErrCode(ErrCode.SUCCESS);
				User user = userService.getUserById(id);
				UserBaseMsgVO userBaseMsgVO = new UserBaseMsgVO();
				userBaseMsgVO.setUsername(user.getUserName());
				restResult.setData(userBaseMsgVO);
			} else
			{
				restResult.setErrCode((int) id);
			}

		} catch (Exception e)
		{
			logger.error("login failed!", e);
			restResult.setErrCode(ErrCode.SYSTEM_ERROR);
			restResult.setErrMsg(e.getMessage());
		}
		return restResult;
	}

	@RequestMapping(value = "stock/modifyPassword", method = RequestMethod.GET)
	public @ResponseBody RestResult<Boolean> modifyPassword(
			ModelMap model,
			HttpSession session,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "newPassword", required = true) String newPassword)
	{
		RestResult<Boolean> restResult = new RestResult<Boolean>();
		try
		{
			Long userId = (Long) session.getAttribute("userId");
			userId = 1L;
			if (userId == null)
			{
				restResult.setErrCode(ErrCode.NOT_EXIST);
				restResult.setErrMsg("用户不存在，请先登录！");
				restResult.setData(false);
			}
			int errCode = userService.motifyPassword(userId, password,
					newPassword);
			if (errCode == ErrCode.SUCCESS)
			{
				restResult.setErrCode(ErrCode.SUCCESS);
				restResult.setData(true);
			} else
			{
				restResult.setErrCode(errCode);
				restResult.setData(false);
			}

		} catch (Exception e)
		{
			logger.error("modify password failed!", e);
			restResult.setErrCode(ErrCode.SYSTEM_ERROR);
			restResult.setErrMsg(e.getMessage());
			restResult.setData(false);
		}
		return restResult;
	}

	@RequestMapping(value = "stock/register", method = RequestMethod.GET)
	public @ResponseBody RestResult<UserBaseMsgVO> register(ModelMap model,
			HttpSession session,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password)
	{
		RestResult<UserBaseMsgVO> restResult = new RestResult<UserBaseMsgVO>();
		try
		{
			long id = userService.addLocalLogin(username, null, null, password);
			if (id == ErrCode.SUCCESS)
			{
				restResult.setErrCode(ErrCode.SUCCESS);
				User user = userService.getUserById(id);
				UserBaseMsgVO userBaseMsgVO = new UserBaseMsgVO();
				userBaseMsgVO.setUsername(user.getUserName());
				restResult.setData(userBaseMsgVO);
			} else
			{
				restResult.setErrCode((int) id);
			}

		} catch (Exception e)
		{
			logger.error("register failed!", e);
			restResult.setErrCode(ErrCode.SYSTEM_ERROR);
			restResult.setErrMsg(e.getMessage());
		}
		return restResult;
	}
}
