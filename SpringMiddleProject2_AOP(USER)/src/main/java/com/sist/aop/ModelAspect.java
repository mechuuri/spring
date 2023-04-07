package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 	AOP의 적용 부분
 * 	@Transactional() >> 
 * 	public List<MovieVO> movieListData()
 *	{
 *		List<MovieVO> list=new ArrayList<MovieVO>();
 *		try
 *		{
 *			getConnection()
 *			======================
 *				around => setAutoCommit(false)
 *				오라클 처리
 *				around => commit()
 *			======================
 *		}catch(Exception ex)
 *		{
 *			오류 처리 => rollbackup()
 *			ex.printStackTrace() ===> AfterThrowing
 *		}
 *		finally
 *		{
 *			오라클 닫기 
 *			disConnection(0 ==> After
 *		}
 *
 *	}
 */
import com.sist.model.*;
import java.util.*;
import com.sist.model.*;
import lombok.Setter;
@Setter
public class ModelAspect {
	private EmpDAO dao;
	
	
	public void before() 
	{
		System.out.println("before Call...");
		dao.getConnection();
	}
	/*	before 위치 
	 * 	try
	 * 	{
	 * 		============= around 시작
	 * 		소스 코딩 
	 * 		============= around 끝 
	 * 	}catch(Exception ex) {
	 * 	 	afterThrowing
	 *  }
	 *  finally
	 *  {
	 *  	after
	 * 	}
	 * 
	 * 	return afterReturning : 정상 수행시 처리 
	 * 
	 * 	뉴스 읽기 ===> before
	 * 	뉴스를 List ==> 핵심
	 */
	public void after()
	{
		System.out.println("after Call... : finally");
		dao.disConnection();
	}
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("around Call... : try 위 ~ try 종료 전");
		Object obj=null;
		// 수행 시간 계산
		long start=0;
		long end=0;
		try
		{
			start=System.currentTimeMillis();
			System.out.println("Client 요청 메소드:"+jp.getSignature().getName());
			obj=jp.proceed(); // 메소드 호출
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			end=System.currentTimeMillis();
			System.out.println("수행 시간:"+(end-start));
		}
		return obj;
	}
	public void afterReturning(Object obj) throws Throwable
	{
		
		// 결과값을 받아서 출력 ==> web에서 return 값을 먼저 처리 => 자동 로그인, ID저장 ...
		System.out.println("afterReturning Call...");
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
	}
	public void afterThrowing(Throwable ex) throws Throwable
	{
		System.out.println("afterThorws Call...");
		// catch절 수행 
		System.out.println(ex.getMessage());// web => alert 
	}
}
