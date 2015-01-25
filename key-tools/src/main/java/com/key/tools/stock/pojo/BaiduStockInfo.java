package com.key.tools.stock.pojo;

public class BaiduStockInfo
{
	private String name;//股票名称
	private String code;//股票代码，SZ指在深圳交易的股票
	private String date;//当前显示股票信息的日期
	private String time;  //具体时间
	private Double OpenningPrice; //今日开盘价
	private Double closingPrice;  //昨日收盘价
	private Double currentPrice;  //当前价格
	private Double  hPrice;        //今日最高价
	private Double lPrice;// 27.34,       //今日最低价
	private Double  competitivePrice;// 27.30, //买一报价
	private Double   auctionPrice;// 27.34,   //卖一报价
	private Long totalNumber;// 47800,    //成交的股票数
    private Double   turnover;// 1306852.00,  //成交额，以元为单位
    private Long  buyOne;// 6100,      //买一 
    private Double   buyOnePrice;// 27.30, //买一价格
    private Long  buyTwo;// 7500,  //买二
    private Double  buyTwoPrice;// 27.29, //买二价格
    private Long   buyThree;// 2000,   //买三
    private Double  buyThreePrice;// 27.27,  //买三价格
    private Long  buyFour;// 100,    //买四
    private Double  buyFourPrice;// 27.25, //买四价格
    private Long  buyFive;// 5700,     //买五
    private Double  buyFivePrice;// 27.22,  //买五价格
    private Long sellOne;// 10150,       //卖一
    private Double  sellOnePrice;// 27.34,  //卖一价格
    private Long  sellTwo;// 15200,      //卖二
    private Double  sellTwoPrice;// 27.35,  //卖二价格
    private Long sellThree;// 5914,     //卖三
    private Double  sellThreePrice;// 27.36, //卖三价格
    private Long sellFour;// 400,        //卖四
    private Double  sellFourPrice;// 27.37,  //卖四价格
    private Long sellFive;// 3000,       //卖五
    private Double   sellFivePrice;// 27.38   //卖五价格
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public Double getOpenningPrice()
	{
		return OpenningPrice;
	}
	public void setOpenningPrice(Double openningPrice)
	{
		OpenningPrice = openningPrice;
	}
	public Double getClosingPrice()
	{
		return closingPrice;
	}
	public void setClosingPrice(Double closingPrice)
	{
		this.closingPrice = closingPrice;
	}
	public Double getCurrentPrice()
	{
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice)
	{
		this.currentPrice = currentPrice;
	}
	public Double gethPrice()
	{
		return hPrice;
	}
	public void sethPrice(Double hPrice)
	{
		this.hPrice = hPrice;
	}
	public Double getlPrice()
	{
		return lPrice;
	}
	public void setlPrice(Double lPrice)
	{
		this.lPrice = lPrice;
	}
	public Double getCompetitivePrice()
	{
		return competitivePrice;
	}
	public void setCompetitivePrice(Double competitivePrice)
	{
		this.competitivePrice = competitivePrice;
	}
	public Double getAuctionPrice()
	{
		return auctionPrice;
	}
	public void setAuctionPrice(Double auctionPrice)
	{
		this.auctionPrice = auctionPrice;
	}
	public Long getTotalNumber()
	{
		return totalNumber;
	}
	public void setTotalNumber(Long totalNumber)
	{
		this.totalNumber = totalNumber;
	}
	public Double getTurnover()
	{
		return turnover;
	}
	public void setTurnover(Double turnover)
	{
		this.turnover = turnover;
	}
	public Long getBuyOne()
	{
		return buyOne;
	}
	public void setBuyOne(Long buyOne)
	{
		this.buyOne = buyOne;
	}
	public Double getBuyOnePrice()
	{
		return buyOnePrice;
	}
	public void setBuyOnePrice(Double buyOnePrice)
	{
		this.buyOnePrice = buyOnePrice;
	}
	public Long getBuyTwo()
	{
		return buyTwo;
	}
	public void setBuyTwo(Long buyTwo)
	{
		this.buyTwo = buyTwo;
	}
	public Double getBuyTwoPrice()
	{
		return buyTwoPrice;
	}
	public void setBuyTwoPrice(Double buyTwoPrice)
	{
		this.buyTwoPrice = buyTwoPrice;
	}
	public Long getBuyThree()
	{
		return buyThree;
	}
	public void setBuyThree(Long buyThree)
	{
		this.buyThree = buyThree;
	}
	public Double getBuyThreePrice()
	{
		return buyThreePrice;
	}
	public void setBuyThreePrice(Double buyThreePrice)
	{
		this.buyThreePrice = buyThreePrice;
	}
	public Long getBuyFour()
	{
		return buyFour;
	}
	public void setBuyFour(Long buyFour)
	{
		this.buyFour = buyFour;
	}
	public Double getBuyFourPrice()
	{
		return buyFourPrice;
	}
	public void setBuyFourPrice(Double buyFourPrice)
	{
		this.buyFourPrice = buyFourPrice;
	}
	public Long getBuyFive()
	{
		return buyFive;
	}
	public void setBuyFive(Long buyFive)
	{
		this.buyFive = buyFive;
	}
	public Double getBuyFivePrice()
	{
		return buyFivePrice;
	}
	public void setBuyFivePrice(Double buyFivePrice)
	{
		this.buyFivePrice = buyFivePrice;
	}
	public Long getSellOne()
	{
		return sellOne;
	}
	public void setSellOne(Long sellOne)
	{
		this.sellOne = sellOne;
	}
	public Double getSellOnePrice()
	{
		return sellOnePrice;
	}
	public void setSellOnePrice(Double sellOnePrice)
	{
		this.sellOnePrice = sellOnePrice;
	}
	public Long getSellTwo()
	{
		return sellTwo;
	}
	public void setSellTwo(Long sellTwo)
	{
		this.sellTwo = sellTwo;
	}
	public Double getSellTwoPrice()
	{
		return sellTwoPrice;
	}
	public void setSellTwoPrice(Double sellTwoPrice)
	{
		this.sellTwoPrice = sellTwoPrice;
	}
	public Long getSellThree()
	{
		return sellThree;
	}
	public void setSellThree(Long sellThree)
	{
		this.sellThree = sellThree;
	}
	public Double getSellThreePrice()
	{
		return sellThreePrice;
	}
	public void setSellThreePrice(Double sellThreePrice)
	{
		this.sellThreePrice = sellThreePrice;
	}
	public Long getSellFour()
	{
		return sellFour;
	}
	public void setSellFour(Long sellFour)
	{
		this.sellFour = sellFour;
	}
	public Double getSellFourPrice()
	{
		return sellFourPrice;
	}
	public void setSellFourPrice(Double sellFourPrice)
	{
		this.sellFourPrice = sellFourPrice;
	}
	public Long getSellFive()
	{
		return sellFive;
	}
	public void setSellFive(Long sellFive)
	{
		this.sellFive = sellFive;
	}
	public Double getSellFivePrice()
	{
		return sellFivePrice;
	}
	public void setSellFivePrice(Double sellFivePrice)
	{
		this.sellFivePrice = sellFivePrice;
	}
    
    
}
