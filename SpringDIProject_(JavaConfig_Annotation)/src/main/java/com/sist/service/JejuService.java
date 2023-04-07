package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.mapper.FoodMapper;
import com.sist.mapper.LocationMapper;
import com.sist.vo.JejuFoodVO;

public class JejuService {
	@Autowired
	private FoodMapper fmapper;
	@Autowired
	private LocationMapper lmapper;
	
	
	public List<JejuFoodVO> foodListData()
	{
		return fmapper.jejuFoodListData()
	}
	
}
