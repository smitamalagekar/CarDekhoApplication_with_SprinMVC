<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import ="com.jspiders.springmvc1.dto.CarDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
   
    #button{
    border:1px solid;
   
    width:65px;
    background-color:black;
    color:gray;
    text-align:center;
    font-size:15px;
    border-radius: 5px;
    padding:10px;
    margin-left:260px;
    margin-top: 10px;
   }
   #head{
     color:black;
     font-size: 30px;
   }
   #box{
     height: 365px;
	 width: 440px;
     background-color: gray;
     border-radius:10px;
     border:3px solid;
     margin:50% auto;
    margin-top:140px;
    margin-left: 525px;
    
   }
   .input{
     color: black;
     font-size: 15px;
     background-color: gray;
     border:1px solid;
     padding: 10px;
     width:250px;
     margin-top: 10px;
    
     
   }
   
   .label{
      font-size: 20px;
	padding-top: 10px;

   }
   a{
     text-decoration: none;
   }
   message{
      font-size: 30px;
   }
   </style>
</head>
<body>

        <%
          CarDTO car=(CarDTO)request.getAttribute("car");
        
        %>
		
		<div id="box" align="center">
		<h1 id="head">Edit cars Details</h1>
		  		<form action="update_car" method="post">
		  		    <table>
		  		         <tr>
		  		             <td class="label">id</td>
		  		             <td class="input"><input type="text" name="id" value="<%=car.getId() %>" readonly="readonly"></td>
		  		         </tr>
		  		         <tr>
		  		             <td class="label">name</td>
		  		             <td class="input"><input type="text" name="name" value="<%=car.getName() %>" required="required"></td>
		  		         </tr>
		  		         <tr>
		  		             <td class="label">brand</td>
		  		             <td class="input"><input type="text" name="brand" value="<%=car.getBrand() %>" required="required" ></td>
		  		         </tr>
		  		         <tr>
		  		             <td class="label">price</td>
		  		             <td class="input"><input type="text" name="price" value="<%=car.getPrice() %>" required="required" ></td>
		  		         </tr>
		  		    </table>
		  		    <button id="button" value="submit">edit</button>
		  		</form>
		  		<h3>
			Do you want to go to <a href="home">Home Page</a> ?
		</h3>
		</div>
		
		<%
		  String message=(String)request.getAttribute("cars");
		  if(message!=null){
			  %>
			  <div align="center"><%=message %></div>
			  <%
		  }
		%>
</body>
</html>