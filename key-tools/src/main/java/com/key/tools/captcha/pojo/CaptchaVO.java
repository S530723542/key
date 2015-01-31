package com.key.tools.captcha.pojo;

import java.awt.image.BufferedImage;

public class CaptchaVO
{
	private BufferedImage image;
	private String randomString;

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
	}

	public String getRandomString()
	{
		return randomString;
	}

	public void setRandomString(String randomString)
	{
		this.randomString = randomString;
	}

}
