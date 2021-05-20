package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ZipCodeLogic {
	Logger logger = LogManager.getLogger(ZipCodeLogic.class);
	@Autowired(required=true)
	private ZipCodeDao zipCodeDao = null;
	@RequestMapping("getZipCodeList")
	public List<Map<String,Object>> getZipCodeList() {
		logger.info("getZipCodeList호출 성공");
		List<Map<String,Object>> zipList = null;
		zipList = zipCodeDao.getZipCodeList();
		return zipList;
	}
}
