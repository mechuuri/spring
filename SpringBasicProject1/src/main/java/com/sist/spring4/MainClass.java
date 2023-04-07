package com.sist.spring4;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\springDev\\springStudy\\";
		ApplicationContext app=new ClassPathXMLApplicationContext(path);
		AModel a=(AModel)app.getBean("a");
		a.display();
	}

}
