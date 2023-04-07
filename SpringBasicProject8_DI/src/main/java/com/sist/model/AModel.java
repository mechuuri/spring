package com.sist.model;

import org.springframework.stereotype.Component;

@Component("am") // 아이디 명청임 
public class AModel {
	public void board()
	{
		System.out.println("게시판의 모든 기능이 있다");
	}
}
