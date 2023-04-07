package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.io.*;
import java.net.*;
@RestController
public class MovieController {
   String[] urls={"","searchMainDailyBoxOffice.do","searchMainRealTicket.do","searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
   @GetMapping(value="movie/movie_list_vue.do",produces = "text/plain;charset=utf-8")
   public String movie_list(int no)
   {
	   String strUrl="https://www.kobis.or.kr/kobis/business/main/"+urls[no];
	   String json="";
	   try
	   {
		   URL url=new URL(strUrl);
		   HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		   if(conn!=null)
		   {
			   BufferedReader in=
					   new BufferedReader(new InputStreamReader(conn.getInputStream()));
			   while(true)
			   {
				   String s=in.readLine();
				   if(s==null) break;
				   json+=s;
			   }
		   }
		   //System.out.println(json);
	   }catch(Exception ex){}
	   return json.trim();
   }
   
}