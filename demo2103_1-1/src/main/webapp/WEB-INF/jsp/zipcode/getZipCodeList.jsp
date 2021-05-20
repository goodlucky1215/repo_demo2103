<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String, Object>> zipList =
		(List) request.getAttribute("zipList");
	int size = 0;
	if(zipList != null){
		size = zipList.size();
	}
	out.print("백엔드에서 넘어온 값의 크기 "+size);
	out.print("<br/>");
	out.print("백엔드에서 넘어온 정보 "+zipList);
	out.print("<br/>");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 우편번호 검색기 페이지 이건 WEB-INF안에 있다오!
</body>
</html>