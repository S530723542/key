package com.key.stock.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.stock.common.Constant;
import com.key.stock.pojo.YahooData;
import com.key.tools.common.ListRecord;
import com.key.tools.common.RestResult;
import com.key.tools.http.HttpAgent;
import com.key.tools.stock.db.dao.StockHistoryMapper;
import com.key.tools.stock.db.dao.StockMapper;
import com.key.tools.stock.db.model.Stock;
import com.key.tools.stock.db.model.StockHistory;
import com.key.tools.stock.service.StockHistoryService;

@Service
public class StockHistoryServiceImpl implements StockHistoryService
{

	@Autowired
	StockMapper			stockMapper;

	@Autowired
	StockHistoryMapper	stockHistoryMapper;

	@Autowired
	HttpAgent			httpAgent;

	@Override
	public void addHistoryRecord(String exchange, String code, Date beginDate,
			Date endDate)
	{
		// TODO Auto-generated method stub
		Stock record = new Stock();
		record.setStockCode(code);
		record.setStockExchange(exchange);
		long all = stockMapper.countBySelective(record);
		Integer offset = 0;
		ListRecord<Stock> listRecord = new ListRecord<Stock>();
		listRecord.setPageNum(offset);
		listRecord.setData(record);
		while (offset < all)
		{
			List<Stock> list = stockMapper.selectBySelectiveLimit(listRecord);
			for (int i = 0; i < list.size(); i++)
			{
				try
				{
					Stock stock = list.get(i);
					String codeString = stock.getStockCode() + "."
							+ stock.getStockExchange();
					// //////////////////////////////////////////

					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(
									new File(
											"H:/github\\key\\key-tools\\doc/stock_history/"
													+ stock.getId() + "-"
													+ codeString + ".txt"))));

					// //////////////////////////
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("s", codeString);

					RestResult<String> result = httpAgent.getAndRetry(
							Constant.YAHOO_RECORD_URL_STRING, params);

					String s = result.getData();

					String[] ss = s.split("\n");
					// System.out.println(ss[0]);
					for (int j = 0; j < ss.length; j++)
					{
						// YahooData yahooData = new YahooData();
						// yahooData.parse(ss[j]);
						// StockHistory stockHistory=new StockHistory();
						// stockHistory.setStockExchange(stock.getStockExchange());
						// stockHistory.setStockCode(stock.getStockCode());
						//
						//
						// stockHistory.setDate(yahooData.getDate());
						// stockHistory.setOpen(yahooData.getOpen());
						// stockHistory.setClose(yahooData.getClose());
						// stockHistory.setHigh(yahooData.getHigh());
						// stockHistory.setLow(yahooData.getLow());
						// stockHistory.setVolume(yahooData.getVolume());
						//
						// stockHistoryMapper.insertSelective(stockHistory);
						// System.out.println(ss[j]);
						bw.write(ss[j]);
						bw.newLine();
					}
					bw.flush();
					bw.close();
					System.out.println(stock.getId() + " OVER!");
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			offset = offset + listRecord.getPageSize();
			listRecord.setPageNum(offset);

		}
	}

}
