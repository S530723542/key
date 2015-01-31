package com.key.stock.controller.image;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.key.tools.captcha.RandomValidateCode;
import com.key.tools.captcha.pojo.CaptchaVO;

@RequestMapping("/key/web/")
@Controller
public class CaptchaControllerImage
{
	private Logger logger = Logger.getLogger(CaptchaControllerImage.class);

	private static final String CAPTCHA = "Captcha";

	@Autowired
	RandomValidateCode randomValidateCode;

	@RequestMapping(value = "stock/captcha", method = RequestMethod.GET)
	public @ResponseBody void showStock(ModelMap model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request)
	{
		CaptchaVO captchaVO = randomValidateCode.getRandcode();
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		try
		{
			ImageIO.write(captchaVO.getImage(), "JPEG",
					response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
			session.setAttribute(CAPTCHA, captchaVO.getRandomString());
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.error("生成验证码失败", e);
		}
	}

	public static boolean vertifyCaptcha(HttpSession session, String captcha)
	{
		if (captcha == null)
		{
			return false;
		}
		String inCaptcha = (String) session.getAttribute(CAPTCHA);
		if (captcha.equalsIgnoreCase(inCaptcha))
		{
			return true;
		} else
		{
			return false;
		}
	}
}
