package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
// Model 클래스 => 반드시 (@Controller, @RestController)
@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	// => _ok.do => POST <form mehtod>
	@GetMapping("emp/list.do")
	public String emp_list(Model model)
	{
		List<String> list=dao.empNameListData();
		model.addAttribute("list",list);
		return "emp/list";
	}
	@PostMapping("emp/info.do")
	public String emp_info(Model model, String[] names)
	{
		Map map=new HashMap();
		map.put("names",names);
		List<EmpVO> list=dao.empInfoData(map);
		model.addAttribute("list",list);
		return "emp/info";
	}
}
