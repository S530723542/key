package com.key.stock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.key.stock.pojo.YahooData;
import com.key.tools.common.CycleQueue;
import com.key.tools.stock.db.model.StockHistory;
import com.key.tools.stock.pojo.KLine;
import com.key.tools.stock.service.KLineAnaService;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration("classpath:com/key/stock/applicationContext.xml")
public class AnaTest
{
	@Autowired
	KLineAnaService kLineAnaService;

	@Test
	public void isDarkCloudCoverTest() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File(
				"D:\\github\\key\\key-tools\\doc\\stock_history\\218-000617.sz.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String s = null;
		List<KLine> kLines = new ArrayList<KLine>();
		br.readLine();
		int offset = 6250-3130;
		int k = 0;
		while ((s = br.readLine()) != null)
		{
			k++;
			if (k > offset)
			{
				break;
			}
			YahooData yahooData = new YahooData();
			yahooData.parse(s);
			StockHistory stockHistory = new StockHistory();
			stockHistory.setDate(yahooData.getDate());
			stockHistory.setOpen(yahooData.getOpen());
			stockHistory.setClose(yahooData.getClose());
			stockHistory.setHigh(yahooData.getHigh());
			stockHistory.setLow(yahooData.getLow());
			stockHistory.setVolume(yahooData.getVolume());
			KLine kLine = new KLine();
			List<StockHistory> list = new ArrayList<StockHistory>();
			list.add(stockHistory);
			kLine.init(list, 0, 1, stockHistory.getDate());
			kLines.add(kLine);
		}
		br.close();
		CycleQueue<KLine> cycleQueue = new CycleQueue<KLine>(2);
		File out = new File("D:/github/key/key-tools\\doc\\ana\\test.csv");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(out)));
		int anaIsDarkCloudCover;
		int anaIsIslet;
		int anaIsMainstay;
		for (int i = kLines.size() - 1; i >= 0; i--)
		{
			s = sdf.format(kLines.get(i).getDate()) + ","
					+ kLines.get(i).getOpen() + "," + kLines.get(i).getClose();
			cycleQueue.addCyc(kLines.get(i));
			boolean isDarkCloudCover = kLineAnaService
					.isDarkCloudCover(cycleQueue);

			if (isDarkCloudCover)
			{
				anaIsDarkCloudCover = -10;
			} else
			{
				anaIsDarkCloudCover = 0;
			}
			s = s + "," + anaIsDarkCloudCover;
			boolean isIslet = kLineAnaService.isIslet(cycleQueue);
			if (isIslet)
			{
				anaIsIslet = -20;
			} else
			{
				anaIsIslet = 0;
			}
			s = s + "," + anaIsIslet;
			boolean isMainstay = kLineAnaService.isMainstay(cycleQueue);
			if (isMainstay)
			{
				anaIsMainstay = 20;
			} else
			{
				anaIsMainstay = 0;
			}
			s = s + "," + anaIsMainstay;
			/////////////////////////			
			int cover= kLineAnaService.cover(cycleQueue);
			cover=cover*30;
			s = s + "," + cover;
			/////////////////////////
			int gestate= kLineAnaService.gestate(cycleQueue);
			gestate=gestate*30;
			s = s + "," + gestate;
			/////////////////////////
			boolean isDawnstar = kLineAnaService.isDawnstar(cycleQueue);
			int anaIsDawnstar;
			if (isDawnstar)
			{
				anaIsDawnstar = 40;
			} else
			{
				anaIsDawnstar = 0;
			}
			s = s + "," + anaIsDawnstar;
			/////////////////////////
			boolean isHesper = kLineAnaService.isHesper(cycleQueue);
			int anaIsHesper;
			if (isHesper)
			{
				anaIsHesper = -40;
			} else
			{
				anaIsHesper = 0;
			}
			s = s + "," + anaIsHesper;
			bw.write(s);
			bw.newLine();
			System.out.println(s);
		}
		bw.flush();
		bw.close();
		System.out.println("OVER!");
	}
}