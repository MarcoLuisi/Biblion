<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLogAbbonato1");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("loginAbbonamento1.jsp");
	}%>    
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Biblion</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/e-biblion.js"type="text/javascript"></script>		

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/ebiblion.css" type="text/css">
</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">

<header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
   
   <div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
   
   
   
    <div class="header_menu">
   
   <div class="header_menu_item_login"><a href="Logout">   <img src="Css/img_css/logout.png" alt="img_login" height=107 width=107></a></div>
   
   </div>
</header>

<div class="navbar">
</div>


<br><br>


<br>
				<h1 align = "center">E-Biblion: Libri disponibili </h1>

<hr class="line">
<br>

<div class="products"></div>  
    
    
</body>
</html>