package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZipCodeDao { //얘는 MVC패턴에 영향을 주지 않는다.
	Logger logger = LogManager.getLogger(ZipCodeDao.class);
	private static final String NAMESPACE = "com.example.demo.";
	@Autowired(required=false)
	private SqlSession sqlSession = null;
	public List<Map<String,Object>> getZipCodeList() {
		logger.info("getZipCodeList호출 성공");
		List<Map<String,Object>> zipList = null;
		//여기 사이에 호출할 거임. mybatis를! xml파일 필요
		//myBatis.jar는 자바랑 비비기 위해서
		//myBatis_spring.jar는 스프링과 비비기 위해서
		zipList = sqlSession.selectList(NAMESPACE+"refreshData");
		return zipList;
	}
	
}
