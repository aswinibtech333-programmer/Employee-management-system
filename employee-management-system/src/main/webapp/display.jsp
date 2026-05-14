
<%@ page import="com.org.employee_management_system.entity.Employee" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Employee> e = (List<Employee>) request.getAttribute("employee");
	%>
	
	<table border="1">
	<tr>
	<th>EmpId</th>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
    <th>role</th>
    <th>address</th>
    <th>Phone</th>
    <th colspan="2">Action</th>
    </tr>
    
    
    
    <%
    
    if(e != null){
    	for(Employee emp:e){ %>
    	
    	
    
    <tr>
    <td><%=emp.getEmpid() %></td>
    <td><%=emp.getName() %></td>
    <td><%=emp.getEmail() %></td>
    <td><%=emp.getPassword() %></td>
    <td><%=emp.getAge() %></td>
    <td><%=emp.getGender() %></td>
    <td><%=emp.getSalary() %></td>
    <td><%=emp.getRole() %></td>
    <td><%=emp.getAddress() %></td>
    <td><%=emp.getPhone() %></td>
    <td>
    
    <a href="Update-form.jsp?id=<%=emp.getEmpid() %>">Update</a>
    
    </td>
    <td>
    
    <a href="delete?Empid=<%= emp.getEmpid()%>">Delete</a>
    
    
    </td>
    
    </tr>
	
	<%} %>
	<%} %>
	
	</table>
	
	<a href="Registration-form.html">Add Employee</a>
	<a href="home.jsp">Back to Home</a>
	
</body>
</html>