package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Component
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	public List<RecipeVO> recipeListData()
	{
		return mapper.recipeListData();
	}
	
}
