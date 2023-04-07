package com.sist.myapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.model.*;
@Component // 클래스명이 자동 id
public class MainClass {
	@Autowired
	private Model model; // new Model()
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext app =
		            new ClassPathXmlApplicationContext("app.xml");
		      MainClass mc = (MainClass)app.getBean("mainClass");
		      System.out.println("====== Menu ======");
		      System.out.println("1. 레시피");
		      System.out.println("2. 맛집");
		      System.out.println("3. 상품");
		      System.out.println("==================");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("메뉴 선택 : ");
		      int no = sc.nextInt();
		      if(no == 1) {
		         mc.model.recipeListData();
		      }
		      else if(no == 2) {
		         mc.model.foodListData();
		      }
		      else if(no == 3) {
		         mc.model.foodListData();
		      }
		   }
	}
