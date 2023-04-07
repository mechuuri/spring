package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository // 구분 위해서 DAO임..> Spring한테 알려줌 >> 메모리 할당이 됨 
public class EmpDAO {
	// Mapper = interface => 구현된 클래스를 받는다 
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
}
