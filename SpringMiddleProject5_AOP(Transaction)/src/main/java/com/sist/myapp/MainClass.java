package com.sist.myapp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component
public class MainClass {
	@Autowired
	private StudentDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<StudentVO> list=mc.dao.studentListData();
		for(StudentVO vo:list)
		{
			System.out.println(vo.getHakbun()+" "
					+vo.getName()+" "
					+vo.getKor()+" "
					+vo.getEng()+" "
					+vo.getMath());
				
		}
		
		StudentVO vo1=new StudentVO();
		vo1.setHakbun(6);
		vo1.setName("강감찬");
		vo1.setKor(55);
		vo1.setEng(86);
		vo1.setMath(15);
		
		StudentVO vo2=new StudentVO();
		vo2.setHakbun(6);
		vo2.setName("을지문덕");
		vo2.setKor(78);
		vo2.setEng(89);
		vo2.setMath(85);
		
		mc.dao.studentInsert(vo1, vo2);
	}

}
