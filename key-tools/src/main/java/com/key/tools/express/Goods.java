package com.key.tools.express;

public class Goods<T>
{
	enum Status
	{
		INIT, SUCCESS, FAILED, ING
	};

	private Status status;

	private T id = null;

	public Goods(T id)
	{
		this.status = Status.INIT;
		this.id = id;
	}

	public void setId(T id)
	{
		this.id = id;
	}

	public T getId()
	{
		return this.id;
	}

	public void setInit()
	{
		this.status = Status.INIT;
	}

	public void setIng()
	{
		this.status = Status.ING;
	}

	public void setSuccess()
	{
		this.status = Status.SUCCESS;
	}

	public void setFailed()
	{
		this.status = Status.FAILED;
	}

	public Status getStatus()
	{
		return this.status;
	}
}
