<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     background-color: #D8BFD8;
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

		<div id="box" align="center">
		<h1 id="head">Add Cars Details</h1>
		<form action="add_car" method="post">
		<table>
		       <tr>
		       		<td class="label">Name</td>
		       		<td><input class="input" type="text" name="name" required="required" autofocus="autofocus"></td>
		       </tr>
		        <tr>
		       		<td class="label">Brand</td>
		       		<td><input class="input" type="text" name="brand" required="required"></td>
		       </tr>
		        <tr>
		       		<td class="label">Price</td>
		       		<td><input class="input" type="text" name="price" required="required"></td>
		       </tr>
		</table><br/>
		<input id="button" type="submit" value="Add">
		</form>
		<h3>
			Do you want to go to <a href="home">Home Page</a> ?
		</h3>
		</div>
		
		<div>
		<%
		String message=(String)request.getAttribute("message");
		if(message!=null){
			%>
			<div align="center"><h1><%=message %></h1></div>
			<% 
		}
		%>
		</div>

</body>
</html>