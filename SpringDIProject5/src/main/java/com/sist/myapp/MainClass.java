package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import com.sist.manager.*;
@Component
public class MainClass {
	@Autowired
	private MovieManager mm; // 생성된 주소값을 스프링으로부터 받아 온다
	// 지역변수를 제어할 수 없다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		/*MainClass mc=(MainClass)app.getBean("mainClass");
		while(true)
		{
			
		Scanner scan=new Scanner(System.in);
		System.out.println("===========메뉴=========");
		System.out.println("1. 일일 박스오피스");
		System.out.println("2. 실시간 예매율");
		System.out.println("3. 좌석 점유율순위");
		System.out.println("4. 온라인 상영관 일일");
		System.out.println("=======================");
		System.out.println("메뉴 선택");
		int no=scan.nextInt();
		if(no==5) break;
		List<MovieVO> list=mc.mm.movieListData(no);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getRank()+" "+vo.getTitle()+vo.getGenre()+" "+vo.getDirector());
		}
	}*/
	NewsManager n=(NewsManager)app.getBean("newsManager");
	Scanner scan=new Scanner(System.in);
	System.out.println("검색어 입력:");
	String fd=scan.next();
	List<NewsVO> list=n.newsListData(fd);
	for(NewsVO vo:list)
	{
		System.out.println(vo.getTitle());
		System.out.println(vo.getDescription());
		System.out.println(vo.getPubDate());
		System.out.println("========================");
	}
		
	}

}
