package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;

import com.sist.config.BookConfig;
import com.sist.model.*;
@Component
public class MainClass {
   @Autowired
   private Model model;
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      AnnotationConfigApplicationContext app=
            new AnnotationConfigApplicationContext(BookConfig.class);
      MainClass mc=(MainClass)app.getBean("mainClass");
      System.out.println("============= 카테고리 ===================");
      mc.model.bookCategory();
      System.out.println("=======================================");
      Scanner scan=new Scanner(System.in);
      System.out.print("카테고리 선택:");
      int no=scan.nextInt();
      String[] cate= {
            "",
            "순수과학",
            "역사",
            "언어",
            "총류",
            "기술과학",
            "종교",
            "문학",
            "예술",
            "철학",
            "사회과학"
      };
      System.out.println("================== 실행 결과 =====================");
      mc.model.bookListData(cate[no]);
      
   }

}