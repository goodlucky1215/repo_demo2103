package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zipcode/*")
public class ZipCodeController {
	Logger logger = LogManager.getLogger(ZipCodeController.class);
	@Autowired(required=true)
	private ZipCodeLogic zipCodeLogic = null;
	@RequestMapping("getZipCodeList")
	public String getZipCodeList(HttpServletRequest req) {
		logger.info("getZipCodeList호출 성공");
		List<Map<String,Object>> zipList = null;
		zipList = zipCodeLogic.getZipCodeList();
		req.setAttribute("zipList",zipList);
		// /WEB-INF/jsp/zipcode/getZipCodeList.jsp
		// /WEB-INF/jsp/ => 접두어 || zipcode/getZipCodeList => 접미어 || .jsp는 불러오니깐 작성하지 않는다.
		//  왜 그러냐? application.properties에 설정을 그렇게 해뒀으니까  =>  spring.mvc.view.prefix=/WEB-INF/jsp/
		//                                                      =>  spring.mvc.view.suffix=.jsp
		return "zipcode/getZipCodeList";
	}
	@RequestMapping("getZipCodeList2")
	public ModelAndView getZipCodeList2(HttpServletRequest req) {
		logger.info("getZipCodeList2호출 성공");
		List<Map<String,Object>> zipList = null;
		zipList = zipCodeLogic.getZipCodeList();
		// /WEB-INF/jsp/zipcode/getZipCodeList.jsp
		// /WEB-INF/jsp/ => 접두어 || zipcode/getZipCodeList => 접미어 || .jsp는 불러오니깐 작성하지 않는다.
		//  왜 그러냐? application.properties에 설정을 그렇게 해뒀으니까  =>  spring.mvc.view.prefix=/WEB-INF/jsp/
		//                                                      =>  spring.mvc.view.suffix=.jsp
		ModelAndView mav = new ModelAndView();
		mav.setViewName("zipcode/getZipCodeList");
		mav.addObject("zipList",zipList);
		return mav;
	}
}
