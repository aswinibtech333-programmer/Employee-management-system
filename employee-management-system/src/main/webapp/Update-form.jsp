<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ page import="com.org.employee_management_system.entity.Employee" %>
    <%@ page import="com.org.employee_management_system.dao.DaoLayer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id=request.getParameter("id");
DaoLayer dao=new DaoLayer();
Employee emp=dao.getEmployeeById(Integer.parseInt(id));


%>

<h1>Employee-Updated-Form</h1>
<form action="update-form" method="post">
   EmpId:<input type="text" name="empId" value="<%=emp.getEmpid() %>"  readonly/>
   Name:<input type="text" name="empName" value="<%=emp.getName() %>"/>
   Email:<input type="email" name="empEmail" value="<%=emp.getEmail() %>"/>
   Password:<input type="password" name="empPwd" value="<%=emp.getPassword() %>"/>
   Age:<input type="text" name="empAge" value="<%=emp.getAge() %>"/>
   <label>Gender:</label>
   <input type="radio"  name="empGender">Female
   <input type="radio"  name="empGender"/>male
   
   Salary:<input type="text" name="empSalary" value="<%=emp.getSalary() %>"/>
   Role:<input type="text" name="empRole" value="<%=emp.getRole() %>"/>   
   Address:<input type="text" name="empAddress" value="<%=emp.getAddress() %>"/>
   Phone:<input type="text" name="empPhone" value="<%=emp.getPhone() %>"/>

<input type="submit" value="Updated"/>


</form>
</body>
</html>