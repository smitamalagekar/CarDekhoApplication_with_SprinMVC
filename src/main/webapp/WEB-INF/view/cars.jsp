<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc1.dto.CarDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
     <style type="text/css">
          #message{
          	font-size: 40px;
           }
           #table{
             
          	 background-color: gray;
	         margin-top: 100px;
	         background-color: #D8BFD8;
	border: 3px solid;
           }
           .head{
             width:120px;
             font-size: 25px;
             padding:20px;
             text-align: center;
             font-weight: bold;
             border: 1px solid;
           }
           .data{
             font-size: 20px;
             text-align: center;
             border: 1px solid;
             width: 120px;
             padding: 15px;
           }
           a{
               text-decoration: none;
               
           }
          #box{
          background-color:#D8BFD8; 
          font-size:20px;
          height: 80px;
          font-weight: bold;
          border: 2px solid;
          }
          input{
         
			height: 28px;
			width: 200px;
			background-color: gray;
	        border: 1px solid;
	      }
	      form{
	      margin-left: 780px;
	      margin-top: 20px;
	      }
	      #button {
	         height: 35px;
	         width: 100px;
	         border: 1px solid;
	         border-radius: 5px;
	         background-color: black;
	         text-decoration:none;
	         color: gray;
	         font-size: 15px;
	         }
	
          
     </style>
</head>
<body>

			
			<div id="box">
			 <form action="search" method="Post">
			    <label>Low Price</label>
			    <input type="text" name="low" required="required">
			    <label>High Price</label>
			    <input type="text" name="high" required="required">
			    <input id="button" type="submit"  value="SEARCH">
			</form>
			
			</div>
			
 <%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h3 id="meassage"><%=message%></h3>
	</div>
	<%
	}

 
 List<CarDTO> cars=(List<CarDTO>) request.getAttribute("cars");
 if(cars!=null){
	 %>
	 <div align="center">
	       
	            
	            <table id="table" border="1px solid">
	            		<tr>
	            		  <th class="head">Id</th>
	            		  <th class="head">Name</th>
	            		  <th class="head">Brand</th>
	            		  <th class="head">Price</th>
	            		</tr>
	            		<% for(CarDTO car:cars){ %>
	            		  <tr> 
	            		   <td class="data"><%=car.getId()%></td>
	            		   <td class="data"><%=car.getName()%></td>
	            		   <td class="data"><%=car.getBrand()%></td>
	            		   <td class="data"><%=car.getPrice()%></td>
	            		  </tr>
	            		<% 
		            	   } 
		            	%>
	            </table>
	              <h3>
	                 Do you want to?<a href="home">Home Page</a>
		</h3>
	        
	    
	     
	 </div>
	
  <%
 
 }
 %>
 

</body>
</html>