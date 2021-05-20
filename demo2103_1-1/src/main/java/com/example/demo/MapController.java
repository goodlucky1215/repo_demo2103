package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/di/*")
//http://localhost:8005/di/mapTest이거할때
public class MapController {
	private Map<String, String> mapBean = null;

	// myBaits의 경우 java가 아니고 자바코드는 jar의 형태로 주입되므로
	// constructor 주입법으로 처리한다.
	// DB Connection pool도 자바 표준에서 제공하는 것은 아니어서
	// 생성자 객체 주입법(xml에서 처리하는 것을 의미)으로 처리해야 할 것이다.
	// setter 객체 주입법: java
	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean; //여기에 값을 넣어주면 돌아가겠지!
	}

	@RequestMapping("mapTest")
	public String maptTest() {
		System.out.println(mapBean.get("prop1")); //이게 지금 null이라서 에러나는 거임, 이거 주석처리하면 잘 돌아감
		return "redirect:mapTest.jsp";
	}
}