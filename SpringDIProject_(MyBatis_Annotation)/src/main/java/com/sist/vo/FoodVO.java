package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * 	분업 : 개인마다 (어노테이션) => 사용자 정의 클래스 (1.VO, 2.DAO, 3.Model, 4.JSP)
 */

@Getter
@Setter
public class FoodVO {
	private int fno;
	private String name,type;
	
	
}
