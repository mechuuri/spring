package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired(required = false)
	private FoodMapper mapper;
	
	//@Select("SELECT cno,title,poster,subject FROM project_category")
	public List<CategoryVO> categoryListData()
	{
		return mapper.categoryListData();
	}
	
	/*@Select("SELECT fno,cno,name,tel,address,type,poster "
			+"FROM project_food "
			+"WHERE cno=#{cno}")*/
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
	
	/*@Select("SELECT title,subject FROM project_category "
			+"WHERE cno=#{cno}")*/
	public CategoryVO categoryInfoData(int cno)
	{
		return mapper.categoryInfoData(cno);
	}
	 
	/*@Select("SELECT * FROM project_food "
			+"WHERE fno=#{fno}")*/
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
	/*@Select("SELECT fno,name,poster,num "
			   +"FROM (SELECT fno,name,poster,rownum as num "
			   +"FROM (SELECT fno,name,poster "
			   +"FROM food_location WHERE address LIKE '%' ||#{addr}||'%' ORDER BY fno ASC)) "
			   + "WHERE num BEWEEN #{start} AND #{end}")*/
	   public List<FoodVO> foodSearchData(Map map)
	   {
		   return mapper.foodSearchData(map);
	   }
	   
	   /*@Select("SELECT CEIL(COUNT(*)/20.0)  "
		   		+ "FROM food_location "
				   +"WHERE address LIKE '%'||#{adddr}||'%'")*/
		   		public int foodSearchTotalPage(Map map)
		   		{
		   			return mapper.foodSearchTotalPage(map);
		   		}
		   		
		public FoodVO foodLocationDetailData(int fno)
		{
			return mapper.foodLocationDetailData(fno);
		
		}
		/*@Select({
	   		"<script>"
	   		+"SELECT cno,title,poster "
	   	    +"FROM project_category "
	   		+"WHERE "
	   	    +"<if test='no==1'>"
	   		+"cno BETWEEN 1 AND 12"
	   	    +"</if>"
	   	    +"<if test='no==2'>"
	   		+"cno BETWEEN 13 AND 18"
	   	    +"</if>"
	   	    +"<if test='no==1'>"
	   		+"cno BETWEEN 19 AND 30"
	   	    +"</if>"
	   		+"</script>"
   })*/
   public List<CategoryVO> categoryVueData(Map map)
   {
	   return mapper.categoryVueData(map);
   }
}
