package com.key.stock.common;

public class SinaUtil
{
	public static String generateSinaUrl(String exChange, String code,
			String type)
	{
		String url = null;
		url = Constant.SINA_IMAGE_URL_STRING + type + "/n/" + exChange + code
				+ ImageType.SUFFIX;
		return url;
	}
}
