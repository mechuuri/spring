package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
   @Select("SELECT cno,title,poster,subject FROM project_category ")
   public List<CategoryVO> categoryListData();
   
   @Select("SELECT fno,cno,name,tel,address,type,poster,score "
         +"FROM project_food "
         +"WHERE cno=#{cno}")
   public List<FoodVO> foodListData(int cno);
   
   @Select("SELECT title,subject FROM project_category "
         +"WHERE cno=#{cno} ")
   public CategoryVO categoryInfoData(int cno);
   
   @Select("SELECT * FROM project_food "
         +"WHERE fno=#{fno} ")
   public FoodVO foodDetailData(int fno);
   
   @Select("SELECT fno,name,poster,num "
         +"FROM (SELECT fno,name,poster,rownum as num "
         +"FROM (SELECT fno,name,poster "
         +"FROM food_location WHERE address LIKE '%'||#{addr}||'%' ORDER BY fno ASC)) "
         +"WHERE num BETWEEN #{start} AND #{end} ")
   public List<FoodVO> foodSearchData(Map map);
   
   @Select("SELECT CEIL(count(*)/20.0) "
         +"FROM food_location "
         +"WHERE address LIKE '%'||#{addr}||'%' ")
   public int foodSearchTotalPage(Map map);
   
   @Select("SELECT * FROM food_location "
         +"WHERE fno=#{fno} ")
   public FoodVO foodLocationDetailData(int fno);
   
   @Select({
            "<script>"
            +"SELECT cno,title,poster "
            +"FROM project_category "
            +"WHERE "
            +"<if test='no==1'>"
            +"cno BETWEEN 1 AND 12 "
            +"</if>"
            +"<if test='no==2'>"
            +"cno BETWEEN 13 AND 18 "
            +"</if>"
            +"<if test='no==3'>"
            +"cno BETWEEN 19 AND 30 "
            +"</if>"
            +"</script>"
         })
   public List<CategoryVO> categoryVueData(Map map);
}