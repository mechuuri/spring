package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BookMapper {
	@Select("SELECT no,price,publisher,author,title,type,rownum "
			+"FROM (no,price,publisher,author,title,type FROM book ORDER BY no ASC) "
			+"WHERE type=#{type}")
	public List<BookVO> bookCategoryListData(String type);
	
	@Select("SELECT DISTINCT type FROM Book")
	public List<String> bookCategory();
}
