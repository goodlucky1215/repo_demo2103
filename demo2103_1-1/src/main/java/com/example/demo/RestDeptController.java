package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

//의존 막기위해서 FW를 사용하게 됨. 더 이상 req, res 의존x-> 상속 ㄴㄴ -> 그래서 responsePage(여기 안에 req, res)없는 거임, 자동으로 입력값이 담겨서 들어감
@RestController
public class RestDeptController {
	Logger logger = LogManager.getLogger(RestDeptController.class);
	@Autowired
	DeptLogic deptLogic = null;
	@RequestMapping("dept/responsePage")
	public String responsePage() {
		logger.info("responsePage 호출 성공");
		return "한글 페이지";
	}
	@RequestMapping("dept/jsonDeptList")
	public String jsonDeptList() {
		logger.info("responsePage 호출 성공");
		List<Map<String,Object>> deptList = null;
		deptList = deptLogic.jsonDeptList();
		Gson g = new Gson();
		String imsi = g.toJson(deptList);
		return imsi;
	}
}
