package com.sist.dao;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   
   /*@Select("{CALL seoulLocationListData(#{pStart,mode=IN,javaType=java.lang.Integer},"
         + "#{pEnd,mode=IN,javaType=java.lang.Integer},"
         + "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
   @Options(statementType = StatementType.CALLABLE)*/
   public List<SeoulVO> seoulLocationListData(Map map)
   {
      mapper.seoulLocationListData(map);
      return (List<SeoulVO>)map.get("pResult");
   }
   
   /*@Select("{CALL seoulLocationDetailData(#{pNo,mode=IN,javaType=java.lang.Integer},"
         + "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
   @Options(statementType = StatementType.CALLABLE)*/
   public SeoulVO seoulLocationDetailData(Map map)
   {
      mapper.seoulLocationDetailData(map);
      return (SeoulVO)map.get("pResult");
   }
   
   /*@Select("{CALL seoulLocationDetailData(#{pTotal,mode=OUT,javaType=java.lang.Integer})}")
   @Options(statementType = StatementType.CALLABLE)*/
   public Integer seoulLocationTotalPage(Map map)
   {
      return mapper.seoulLocationTotalPage(map);
   }
}