package com.key.tools.member.db.model;

public class QQLoginExt extends QQLogin
{
	private Byte isDelete;
	
	public void setIsDelete(Byte isDelete)
	{
		this.isDelete=isDelete;
	}
	public Byte getIsDelete()
	{
		return this.isDelete;
	}
}
