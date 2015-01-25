package com.key.stock.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.key.stock.pojo.StockVO;
import com.key.tools.common.RestResult;


@RequestMapping("/key/web/")
@Controller
public class TestRest
{
	 
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public @ResponseBody RestResult<StockVO> createUserResource(
			ModelMap model,
			HttpSession session,
			@RequestParam(value = "test", required = true) String test
	)
	{
		
		StockVO stockVO=new StockVO();
		stockVO.setName(test);
		RestResult<StockVO> restResult=new RestResult<StockVO>();
		restResult.setData(stockVO);
		return restResult;
	}
}
