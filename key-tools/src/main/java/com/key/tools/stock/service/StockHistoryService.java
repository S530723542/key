package com.key.tools.stock.service;

import java.util.Date;

public interface StockHistoryService
{
	public void addHistoryRecord(String exchange, String code, Date beginDate,
			Date endDate);
}
