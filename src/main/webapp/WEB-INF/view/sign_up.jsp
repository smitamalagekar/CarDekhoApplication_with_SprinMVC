<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		 body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }
    
    #box {
        width: 300px;
        margin: 100px auto;
        background-color: #ADD8E6; /* Yellow background color for the box */
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.9);
    }
    
    #box h1 {
        font-size: 24px;
        margin-bottom: 20px;
        text-align: center;
        color: #333;
    }
    
    #form {
        text-align: center;
    }
    
    .input-field {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px; /* Added gap between input fields */
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box; /* Include padding and border in width */
    }
    
    #button {
        width: 100px; /* Small width for the button */
        padding: 10px;
        background-color: black; /* Green color for the button */
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s; /* Smooth hover effect */
    }
    
    #button:hover {
        background-color: #45a049; /* Darker green on hover */
    }
    
    #signup-link {
        font-size: 14px;
        margin-top: 10px;
        text-align: center;
    }
  </style>
</head>
<body>
	
     <div id="box" align="center">
      <form id="form" action="add_user" method="POST">
      		<table id="tbl" border=1px solid>
      				<tr>
      					<td class="label">Email</td>
      					<td class="input"><input type="text" name="email"></td>
      				</tr>
      			    <tr>
      					<td class="label">Password</td>
      					<td class="input"><input type="text" name="password"></td>
      				</tr>
      		</table>
      		<input id="button"type="submit" value="Sign_Up">
      </form>
      <h3 >
			Do you want to <a href="sign_in">Sign in</a> ?
		</h3>
     </div>
    
</body>
</html>