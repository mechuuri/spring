package com.sist.vo;
/*
TITLE      VARCHAR2(300)  
URL        VARCHAR2(500)  
POSTER     VARCHAR2(300)  
CONTENT    VARCHAR2(500)  
PRICE      VARCHAR2(50)   
PRICE2     NUMBER(38)     
IMAGE      VARCHAR2(4000) 
INFO       VARCHAR2(4000) 
NO         NUMBER         
ADDR       VARCHAR2(200)  
TYPE       VARCHAR2(200)  
HIT        NUMBER
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JejuLocationVO {
	private int no,hit,price2;
	private String title,url,poster,content,price,image,info,addr,type;
	
}
