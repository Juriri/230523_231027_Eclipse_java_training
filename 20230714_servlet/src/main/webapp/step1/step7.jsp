<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.memberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
memberVO vo = new memberVO("java", "1234", "������", "�Ǳ�");

%>

<% if(vo.getId().equals("java")  && vo.getPassword().equals("1234")) {%>
ȸ�����̵�: <%=vo.getId() %>
ȸ����й�ȣ: <%=vo.getPassword() %>
ȸ�� �̸�: <%=vo.getName() %>
ȸ�� �ּ� : <%=vo.getAddress() %>

<% } %>


</body>
</html>