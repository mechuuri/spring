package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	/*
	 * 	Model ==> jsp로 값을 전송 (Model을 전송 객체) ==> 화면에 출력할 데이터 전송 (forward => return "경로명/파일명")
	 * 	RedirectAttributes => ?대신 사용
	 * 		return "redirect:detail.do?no=1"
	 * 	HttpServletRequest : Cookie 읽기
	 * 	HttpServletResponse : Cookie 전송, File Download
	 * 	HttpSession : 회원가입...
	 * 
	 * 	일반데이터 : page,no...,검색어 ===> String, 해당 데이터형으로 받을 수 있다
	 *	커맨드 객체 : ~VO
	 *	checkbox => String[]
	 *	List => name=a[0] name=a[1]...
	 */
	// 페이지
	@GetMapping("food/list.do")
	public String food_list(String page,Model model)//
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page); // 현재페이지
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<FoodVO> list=dao.foodListData(map);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "food/list";
	}
	
	@PostMapping("food/find.do")
	public String food_find(String[] types,String ss,Model model)
	{
		Map map=new HashMap();
		map.put("typeArr", types);
		map.put("ss", ss);
		
		List<FoodVO> list=dao.foodFindData(map);
		int count=dao.foodFindCount(map);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "food/find";
	}
}
