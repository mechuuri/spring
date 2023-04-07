package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import javassist.SerialVersionUID;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeService service;
	
	@GetMapping(value="recipe/recipe_list_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) // 현재페이지까지 있음 
	{
		Map map=new HashMap();
		map.put("start", (page*20)-19);
		map.put("end", page*20);
		List<RecipeVO> list=service.recipeListData(map); // jsonarray(여러개 동시에) 사용해야됨
		int totalpage=service.recipeTotalPage();
		String count=service.recipeRowCount();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		int i=0;
		JSONArray arr=new JSONArray();
		for(RecipeVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			obj.put("chef", vo.getChef());
			
			if(i==0)
			{
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
				obj.put("count", count);
				
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	@GetMapping(value="recipe/chef_list_vue.do",produces = "text/plain;charset=UTF-8")
	public String chef_list_vue(int page)
	{
		Map map=new HashMap();
		map.put("start", (page*50)-49);
		map.put("end", page*50);
		List<ChefVO> list=service.chefListData(map);
		int totalpage=service.chefTotalPage();
		
		int i=0;
		JSONArray arr=new JSONArray();
		for(ChefVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("chef", vo.getChef());
			obj.put("poster", vo.getPoster());
			obj.put("mc1", vo.getMem_cont1());
			obj.put("mc2", vo.getMem_cont2());
			obj.put("mc3", vo.getMem_cont3());
			obj.put("mc7", vo.getMem_cont7());
			
			if(i==0)
			{
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
				
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	// 페이지 안나누고 20개만 출력
	@GetMapping(value="recipe/chef_make_vue.do",produces = "text/plain;charset=UTF-8")
	public String chef_make_vue(String chef)  
	{
		List<RecipeVO> list=service.chefMakeRecipeData(chef);
		JSONArray arr=new JSONArray();
		for(RecipeVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			obj.put("chef", vo.getChef());
		
			arr.add(obj);

		}
		return arr.toJSONString();
	}
	

}
