package com.sist.web;
// => DI / MVC => AOP 
// => Intercepter => 자동 로그인 / ID저장  ==> naver,facebook  ==> security
// => task => betch 
// => spring data....

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
// <if> <choose> <where> <trim> <foreach> IN 
/*   
 *    WHERE
 *    <if>
 *      OR name LIKE
 *    </if>
 *    <if>
 *      OR subject LIKE
 *    </if>
 *    <if>
 *      OR content LIKE
 *    </if>
 */
@Controller
public class FoodController {
    //DB
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/category.do")
	public String food_category(String no,Model model)
	{
		if(no==null)
			no="1";
		Map map=new HashMap();
		map.put("cno", no);
		List<CategoryVO> list=dao.categoryListData(map);
		model.addAttribute("list", list);
		return "food/category";
	}
	// food/list.do?cno=${vo.cno }
	@GetMapping("food/list.do")
	public String food_list(int cno,Model model)
	{
		List<FoodVO> list=dao.foodListData(cno);
		CategoryVO vo=dao.categoryInfoData(cno);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		return "food/list";
	}
	// food/detail.do?fno=${fvo.fno }
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo", vo);
		return "food/detail";
	}
	
	
	/*@GetMapping("food/find.do")//GET/POST
	public String food_find(String addr,String page,Model model)
	{
		System.out.println("addr="+addr);
		String s="";
		if(addr==null || addr.equals(""))
		{
			s="all";
		}
		else
		{
			s=addr;
		}
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("ss", s);
		List<FoodVO> list=dao.foodFindData(map);
		model.addAttribute("list", list);
		return "food/find";
	}*/
	@RequestMapping("food/find.do")//GET/POST
	public String food_find2(String addr,String page,Model model)
	{
		System.out.println("addr="+addr);
		String s="";
		if(addr==null || addr.equals(""))
		{
			s="all";
		}
		else
		{
			s=addr;
		}
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("ss", s);
		List<FoodVO> list=dao.foodFindData(map);
		model.addAttribute("list", list);
		return "food/find";
	}
	
	
}