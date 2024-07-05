<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body{
       			marging:0px;
       			padding:0px;
       			box-sizing: border-box;  
       			padding-right: 0.5% ;
     		}
			#box{
			    height:120px;
			    width:100%;
			     background-image: linear-gradient(black, #919190 ,black);
			    padding-top:20px;
				
			}
			nav {
			    height: 100%;
			    
                display:flex;
			    justify-content:flex-end;
			    align-items:center;	  
			    margin-right:2% ;
			 }
			a{
			  height:30px;
			  width:50px; 
			  border-radius:5px;
			  background-color:black;
			  color:white;
			  padding:10px 20px ;
			  box-shadow:6px 6px 6px gray;
			  
			  text-decoration:none;
			  text-align:center;
			  border-radius:10px;
			
			  }
			 a:hover {
               background-color: ;
}
			  #li1{
			  margin-right:40px;
			  
			  }
			
		
</style>
</head>
<body>
			 <div  id="box1">
			 <div id="box" align="center">
          <nav>
               
             <ul type="none">
               <li id="li1"type="none">
               <a href="add_page">ADD</a>
               <a href="cars">ALL CARS</a>
               <a href="my_cars">MY CARS</a>
               <a href="sign_out">SIGN OUT</a>
               </li>
             </ul>
             
          </nav>
             
             
       </div>
			
		</div>
		
</body>
</html>