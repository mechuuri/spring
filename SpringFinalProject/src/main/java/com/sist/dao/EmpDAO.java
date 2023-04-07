package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class EmpDAO {
	@Autowired // 스프링에서 주소값을 넣어줌: 
	private EmpMapper mapper; // 스프링에서만 구현 
	
	/*@Results({
		@Result(property = "dvo.dname",column = "dname"), // emp가 갖고 있는 변수 : property
		//								 db에 있는 값 이름
		@Result(property = "dvo.loc",column = "loc")
	
	})
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
	+"FROM emp,dept "
	+"WHERE emp.deptno=dept.deptno "
	+"ORDER BY sal DESC")*/
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
}
