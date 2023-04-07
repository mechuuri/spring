package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class FoodDAO extends SqlSessionDaoSupport{
	public List<FoodVO> foodListData()
	{
		return getSqlSession().selectList("foodListData");
		
	}
	
public FoodVO foodDetailData(int fno)
{
	return getSqlSession().selectOne("foodDetailData", fno);
}
}
