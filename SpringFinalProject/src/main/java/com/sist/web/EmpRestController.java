package com.sist.web;
// vo => mapper => dao => controller => jsp
//				   =================
//						  =================== JSP(Javascsript:Rest)
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class EmpRestController {
	@Autowired
	private EmpDAO dao;
	
	@GetMapping(value="emp/list.do",produces = "text/plain;charset=UTF-8") // emp안에 list가 있다
	public String emp_list()
	{
		List<EmpVO> list=dao.empListData(); // JSON => [] (JSONArray)
		// EmpVO => {} (JSONObject)
		JSONArray arr=new JSONArray();
		for(EmpVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("empno", vo.getEmpno());
			obj.put("ename", vo.getEname());
			obj.put("job", vo.getJob());
			obj.put("hiredate", vo.getDbday());
			obj.put("sal", vo.getSal());
			obj.put("dname", vo.getDvo().getDname());
			obj.put("loc", vo.getDvo().getLoc());
			arr.add(obj);
		}
		return arr.toJSONString();
	}
}
