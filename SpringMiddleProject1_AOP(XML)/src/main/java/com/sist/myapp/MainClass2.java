package com.sist.myapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass2 {
	private MovieDAO2 dao;
	
	
	public void setDao(MovieDAO2 dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		
		MovieDAO2 dao=(MovieDAO2)app.getBean("dao");
		// 호출
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
	}

}
