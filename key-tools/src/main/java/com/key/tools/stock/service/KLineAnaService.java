package com.key.tools.stock.service;

import com.key.tools.common.CycleQueue;
import com.key.tools.stock.pojo.KLine;

public interface KLineAnaService
{
	public boolean isDarkCloudCover(CycleQueue<KLine> cycleQueue);
	
	public boolean isIslet(CycleQueue<KLine> cycleQueue);
	
	public boolean isMainstay(CycleQueue<KLine> cycleQueue);
	
	public int cover(CycleQueue<KLine> cycleQueue);
	
	public int gestate(CycleQueue<KLine> cycleQueue);
	
	public boolean isDawnstar(CycleQueue<KLine> cycleQueue);
	
	public boolean isHesper(CycleQueue<KLine> cycleQueue);
	
}
