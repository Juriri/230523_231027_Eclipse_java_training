<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list1 = new ArrayList<>(0);
List<String> list2 = new ArrayList<>(0);

list2.add("aaa");
list2.add("bbb");
list2.add("ccc");
int x = 10;
int y = 20;

pageContext.setAttribute("list1", list1);
pageContext.setAttribute("list2", list2);
pageContext.setAttribute("x", x);
pageContext.setAttribute("y", y);
%>
list1은 비었는가? ${empty list1}
<br> list2는 비었는가 ${empty list2}
<br> list2 데이터: ${list2[0] } / ${list2[1] } / ${list2[2] }
<br> x=${x } /y=${y }
<br>
</body>
</html>