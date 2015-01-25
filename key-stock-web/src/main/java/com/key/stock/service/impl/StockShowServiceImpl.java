package com.key.stock.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.key.stock.common.Constant;
import com.key.stock.common.SinaUtil;
import com.key.stock.common.SourceType;
import com.key.stock.common.TransUtil;
import com.key.stock.db.dao.StockCollectMapper;
import com.key.stock.db.model.StockCollect;
import com.key.stock.pojo.StockVO;
import com.key.stock.service.StockShowService;
import com.key.tools.common.DBConstant;
import com.key.tools.common.ErrCode;
import com.key.tools.common.ListRecord;
import com.key.tools.common.utils.DBUtils;
import com.key.tools.stock.db.model.Stock;
import com.key.tools.stock.service.StockService;

@Service
public class StockShowServiceImpl implements StockShowService
{

	@Autowired
	StockCollectMapper	stockCollectMapper;

	@Autowired
	StockService		stockService;

	@Transactional
	public int collectStock(long userId, long stockId)
	{
		Date now = new Date();
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setStockId(stockId);
		StockCollect stockCollect = stockCollectMapper
				.selectByUniqueKeyForUpdate(record);
		if (stockCollect != null)
		{
			if (DBConstant.IS_AVAILABLE.equals(stockCollect.getIsDelete()))
			{
				return ErrCode.STOCK_COLLECTING_EXIST;
			} else
			{
				int highest = stockCollectMapper
						.getFirstPriorityByUserId(userId);
				stockCollect.setCreateTime(now);
				stockCollect.setMotifyTime(now);
				stockCollect.setIsDelete(DBConstant.IS_AVAILABLE);
				stockCollect.setPriority(highest + 1);
				stockCollectMapper.updateByPrimaryKeySelective(stockCollect);
			}

		} else
		{
			Integer highest = stockCollectMapper
					.getFirstPriorityByUserId(userId);
			if (highest == null)
			{
				highest = 0;
			}
			record.setCreateTime(now);
			record.setMotifyTime(now);
			record.setIsDelete(DBConstant.IS_AVAILABLE);
			record.setPriority(highest + 1);
			stockCollectMapper.insertSelective(record);
		}
		return ErrCode.SUCCESS;
	}

	@Transactional
	public int deleteStockCollect(long userId, long stockId)
	{
		Date now = new Date();
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setStockId(stockId);
		StockCollect stockCollect = stockCollectMapper
				.selectByUniqueKeyForUpdate(record);
		if (stockCollect == null
				|| DBConstant.IS_DELETE.equals(stockCollect.getIsDelete()))
		{
			return ErrCode.STOCK_COLLECTING_NOT_EXIST;
		} else
		{
			stockCollect.setMotifyTime(now);
			stockCollect.setIsDelete(DBConstant.IS_DELETE);
			stockCollectMapper.priorityAutoReduce(stockCollect);
			stockCollectMapper.updateByPrimaryKeySelective(stockCollect);
		}
		return ErrCode.SUCCESS;
	}

	public List<StockVO> getStockCollectsByUserId(long userId, String source,
			String type, Integer pageNum, Integer pageSize)
	{
		List<StockVO> result = new ArrayList<StockVO>();
		ListRecord<StockCollect> listRecord = new ListRecord<StockCollect>();
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		pageNum = DBUtils.transToOffset(pageNum, pageSize);
		listRecord.setData(record);
		listRecord.setPageNum(pageNum);
		listRecord.setPageSize(pageSize);
		List<StockCollect> list = stockCollectMapper
				.selectBySelectiveLimit(listRecord);
		for (int i = 0; i < list.size(); i++)
		{
			StockCollect stockCollect = list.get(i);
			Stock stock = stockService.getStockById(stockCollect.getStockId());
			StockVO stockVO = TransUtil.transToStockVO(stock, stockCollect);
			stockVO.setIsCollected(true);
			addImage(source, type, stockVO);
			result.add(stockVO);
		}
		return result;
	}

	@Transactional
	public int upStockCollect(long id)
	{

		Date now = new Date();
		StockCollect stockCollect1 = stockCollectMapper
				.selectByPrimaryKeyForUpdate(id);
		if (stockCollect1 == null
				|| DBConstant.IS_DELETE.equals(stockCollect1.getIsDelete()))
		{
			return ErrCode.STOCK_COLLECTING_NOT_EXIST;
		}
		int first = stockCollectMapper.getFirstPriorityByUserId(stockCollect1
				.getUserId());
		if (stockCollect1.getPriority() == first)
		{
			return ErrCode.STOCK_COLLECTING_IS_FIRST;
		}
		int tmpPriority = stockCollect1.getPriority() + 1;
		ListRecord<StockCollect> listRecord = new ListRecord<StockCollect>();
		StockCollect record = new StockCollect();
		record.setUserId(stockCollect1.getUserId());
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setPriority(tmpPriority);
		listRecord.setData(record);
		listRecord.setPageSize(1);
		listRecord.setPageNum(0);
		List<StockCollect> list = stockCollectMapper
				.selectBySelectiveLimit(listRecord);
		StockCollect stockCollect2 = list.get(0);
		stockCollect2.setPriority(tmpPriority - 1);
		stockCollect2.setMotifyTime(now);
		stockCollectMapper.updateByPrimaryKey(stockCollect2);
		stockCollect1.setPriority(tmpPriority);
		stockCollect1.setMotifyTime(now);
		stockCollectMapper.updateByPrimaryKey(stockCollect1);

		return ErrCode.SUCCESS;
	}

	public int downStockCollect(long id)
	{
		Date now = new Date();
		StockCollect stockCollect1 = stockCollectMapper
				.selectByPrimaryKeyForUpdate(id);
		if (stockCollect1 == null
				|| DBConstant.IS_DELETE.equals(stockCollect1.getIsDelete()))
		{
			return ErrCode.STOCK_COLLECTING_NOT_EXIST;
		}
		if (stockCollect1.getPriority() == 1)
		{
			return ErrCode.STOCK_COLLECTING_IS_LAST;
		}
		int tmpPriority = stockCollect1.getPriority() - 1;
		ListRecord<StockCollect> listRecord = new ListRecord<StockCollect>();
		StockCollect record = new StockCollect();
		record.setUserId(stockCollect1.getUserId());
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setPriority(tmpPriority);
		listRecord.setData(record);
		listRecord.setPageSize(1);
		listRecord.setPageNum(0);
		List<StockCollect> list = stockCollectMapper
				.selectBySelectiveLimit(listRecord);
		StockCollect stockCollect2 = list.get(0);
		stockCollect2.setPriority(tmpPriority + 1);
		stockCollect2.setMotifyTime(now);
		stockCollectMapper.updateByPrimaryKey(stockCollect2);
		stockCollect1.setPriority(tmpPriority);
		stockCollect1.setMotifyTime(now);
		stockCollectMapper.updateByPrimaryKey(stockCollect1);
		return ErrCode.SUCCESS;
	}

	@Override
	public int countStockCollectsByUserId(long userId)
	{
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		int count = stockCollectMapper.countBySelective(record);
		return count;
	}

	private void addImage(String source, String type, StockVO stockVO)
	{
		if (stockVO == null)
		{
			return;
		}
		switch (source)
		{
		case SourceType.SINA:
			stockVO.setUrl(SinaUtil.generateSinaUrl(stockVO.getExChange(),
					stockVO.getCode(), type));
			break;

		case SourceType.LOCAL:
			break;

		default:

		}
	}

	@Override
	public StockVO getStockVOByExCode(String exchange, String code,
			String source, String type)
	{
		Stock stock = stockService.getStockByExCode(exchange, code);
		StockVO stockVO = TransUtil.transToStockVO(stock, null);

		addImage(source, type, stockVO);

		return stockVO;
	}

	@Override
	public boolean isExistStockCollect(long userId, long stockId)
	{
		StockCollect record = new StockCollect();
		record.setIsDelete(DBConstant.IS_AVAILABLE);
		record.setUserId(userId);
		record.setStockId(stockId);
		StockCollect stockCollect = stockCollectMapper
				.selectByUniqueKey(record);
		if (stockCollect != null)
		{
			return true;
		}
		return false;
	}

}
