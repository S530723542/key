package com.key.tools.common.utils;

public class DBUtils
{
	public static int transToOffset(Integer pageNum, Integer pageSize)
	{

		if (pageNum==null||pageSize==null||pageNum <= 0)
		{
			return 0;
		}
		int offset = (pageNum - 1) * pageSize;
		return offset;
	}
}
