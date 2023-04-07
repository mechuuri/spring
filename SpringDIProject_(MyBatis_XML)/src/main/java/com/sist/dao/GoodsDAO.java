package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class GoodsDAO extends SqlSessionDaoSupport{
	public List<GoodsVO> goodsListData()
	{
	return getSqlSession().selectList("goodsListData");
	
	}
}
