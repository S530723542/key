package com.key.tools.stock.pojo;

public class BaiduRetData
{
	BaiduStockInfo	stockinfo;

	BaiduKLineGraph	klinegraph;

	BaiduMarket		market;

	public BaiduStockInfo getStockinfo()
	{
		return stockinfo;
	}

	public void setStockinfo(BaiduStockInfo stockinfo)
	{
		this.stockinfo = stockinfo;
	}

	public BaiduKLineGraph getKlinegraph()
	{
		return klinegraph;
	}

	public void setKlinegraph(BaiduKLineGraph klinegraph)
	{
		this.klinegraph = klinegraph;
	}

	public BaiduMarket getMarket()
	{
		return market;
	}

	public void setMarket(BaiduMarket market)
	{
		this.market = market;
	}
}
