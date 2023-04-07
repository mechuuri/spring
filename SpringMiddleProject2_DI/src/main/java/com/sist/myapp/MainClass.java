package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private SeoulDAO dao;
	
	
	public void setDao(SeoulDAO dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table= {"","seoul_location","seoul_nature","seoul_shop"};
		Scanner scan=new Scanner(System.in);
		System.out.print("테이블 선택:");
		int no=scan.nextInt();
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");// 스프링에서 생성된 객체를 읽어서 사용(셋팅이 완료된 상태)
		// 싱글턴 메모리 1개 사용, 모든 클래스에서 재사용이 가능, 다른 클래스에 영향력이 없다 (스프링 => 독립적인 클래스)
		// 결합성이 낮은 프로그램 (유지보수가 편리하게, 분업일 경우에..), 형식이 동일 (구조) 
		// 객체지햐으이 객체에 대해 설명 
		// 인스턴스 변수 VS 정적 변수 
		Map map=new HashMap();
		map.put("seoul_tbl", table[no]);
		List<SeoulVO> list=mc.dao.seoulListData(map);
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}

}
