package com.sist.myapp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO dao=new StudentDAO();
		StudentVO vo=new StudentVO();
		vo.setHakbun(6);
		vo.setName("이순신");
		vo.setKor(100);
		vo.setEng(89);
		vo.setMath(59);
		
		StudentVO vo1=new StudentVO();
		vo1.setHakbun(6);
		vo1.setName("춘향이");
		vo1.setKor(90);
		vo1.setEng(90);
		vo1.setMath(78);
		
		dao.studentInsert(vo, vo1);
	}

}
