package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.mapper.SeoulMapper;
public class MainClass {
	private SeoulMapper dao;


	public void setDao(SeoulMapper dao) {
		this.dao = dao;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table= {"","seoul_location","seoul_nature","seoul_shop"};
		Scanner scan=new Scanner(System.in);
		System.out.print("데이터베이스 선택:");
		int no=scan.nextInt();
		Map map=new HashMap();
		map.put("seoul_tbl", table[no]);
		// Map => 키, VO => getXxx()
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulLocationVO> list=mc.dao.seoulListData(map);
		for(SeoulLocationVO vo:list)
		{
			
			System.out.println("제목:"+vo.getTitle());
			System.out.println("주소:"+vo.getAddress());
			System.out.println("설명:"+vo.getMsg());
		}
		System.out.println("===================");
		System.out.print("상세볼 번호 입력:");
		int i=scan.nextInt();
		map.put("seoul_tbl", table[no]);
		map.put("no",i);
		SeoulLocationVO vo=mc.dao.seoulDetailData(map);
		System.out.println("번호:"+vo.getNo());
		System.out.println("제목:"+vo.getTitle());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("상세:"+vo.getMsg());
	}

}
