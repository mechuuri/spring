package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {
	@Results({
		/*
		 * 	SELECT empno,ename,job,dname,loc
		 * 	FROM emp,dept
		 * 	WHERE emp.deptno=dept.deptno
		 * 
		 * 	=> ResultSet rs=ps.executeQuery()
		 * 	while(rs.next())
		 * 	{
		 * 		EmpVO vo=new EmpVO();
		 * 		vo.setEmpno(rs.getInt("empno"))
		 * 		..
		 * 		..
		 * 		vo.setDname(rs.getString("dname")) => X
		 * 		vo.getDvo().setDname(rs.getString("dname")) => O
		 * 	}
		 */
		@Result(property = "dvo.dname",column = "dname"), // emp가 갖고 있는 변수 : property
		//								 db에 있는 값 이름
		@Result(property = "dvo.loc",column = "loc")
	
	})
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
	+"FROM emp,dept "
	+"WHERE emp.deptno=dept.deptno "
	+"ORDER BY sal DESC")
	public List<EmpVO> empListData();
}
