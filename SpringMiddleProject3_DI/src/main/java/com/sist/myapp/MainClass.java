package com.sist.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;
// 메모리할당
@Component("mc")
public class MainClass {
	@Autowired
	private SeoulDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulVO> list=mc.dao.seoulListData();
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}

}
