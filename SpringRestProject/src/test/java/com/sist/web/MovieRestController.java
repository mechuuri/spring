package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
import com.sist.manager.MovieManager;

public class MovieRestController {
	@Autowired
	private MovieManager mm;
	
	@RequestMapping(value="movie/lsit_json.do",produces = "text/plain;charset=UTF-8")
	public String movie_list_json(int no)
	{
		String json=mm.movieSite(no);
		return json;
	}
	
