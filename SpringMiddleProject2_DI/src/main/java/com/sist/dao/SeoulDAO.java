package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.mapper.*;


public class SeoulDAO {
	
	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}

	private SeoulMapper mapper;
	
	
	//@Select("SELECT no,title,msg,address FROM ${seoul-tbl}")
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	
	//@Select("SELECT no,title,msg,address FROM ${seoul_tbl} "
			//+"WHERE no=#{no}")
	public SeoulVO seoulDetailData(Map map)
	{
		return mapper.seoulDetailData(map);
	}
}
