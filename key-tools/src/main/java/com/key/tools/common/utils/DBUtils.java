package com.key.tools.common.utils;

public class DBUtils
{
	public static int transToOffset(int pageNum, int pageSize)
	{
		if (pageNum <= 0)
		{
			return 0;
		}
		int offset = (pageNum - 1) * pageSize;
		return offset;
	}
}
