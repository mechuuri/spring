package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private StudentDAO dao;
	
	
	public StudentDAO getDao() {
		return dao;
	}


	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("applictaion-context.xml","application-datasource.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		
		/*StudentVO vo=new StudentVO();
		vo.setName("홍길동");
		vo.setKor(90);
		vo.setEng(80);
		vo.setMath(78);
		mc.dao.studentInsert(vo);
		System.out.println("저장 완료");*/
		
		// 목록 받기
		List<StudentVO> list=mc.dao.studentListData();
		for(StudentVO vo:list)
		{
			System.out.println(vo.getHakbun()+" "
					+vo.getName()+" "
					+vo.getKor()+" "
					+vo.getEng()+" "
					+vo.getMath()+" "
					+vo.getTotal()+" "
					+vo.getAvg());
		}
		
		// 디테일 정보 
		StudentVO vo=mc.dao.studentDetailData(1);
		System.out.println(vo.getHakbun()+" "
				+vo.getName()+" "
				+vo.getKor()+" "
				+vo.getEng()+" "
				+vo.getMath()+" "
				+vo.getTotal()+" "
				+vo.getAvg());
	}

}
