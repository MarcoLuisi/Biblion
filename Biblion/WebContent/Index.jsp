<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblion</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="script/home.js"type="text/javascript"></script>
<script src="script/event_home.js"type="text/javascript"></script>		

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/Home.css" type="text/css">
</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">


<header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
   
   	<div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
    
    <div class="header_menu">
    
    	
    
    	<%Boolean logged = (Boolean) session.getAttribute("isLog"); 
			if(logged != null){
				if(logged.booleanValue()) {%>
						<% Boolean admin = (Boolean) session.getAttribute("isAdmin");
						if(admin.booleanValue()) {%>
							<div class="header_menu_item_login"><a href="admin.jsp"><img src="Css/img_css/admin.png" alt="img_login"></a></div>
						<%} else { %>
							<div class="header_menu_item_login"><a href="utente.jsp"><img src="Css/img_css/login.png" alt="img_login"></a></div>
						<%} %>
					<%} %>
		<%} else if(logged == null || logged.booleanValue() == false) {%>
						<div class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/login.png" alt="img_login" ></a></div>
						
		<%} %>
  	</div>
  	
</header>

<div class="navbar">
  <div class="subnav">
    <button class="subnavbtn">LIBRI <i class="subnav1"></i></button>
    <div class="subnav-content">
      <a href= "#fantascienza" onclick="MyFunction('Fantascienza');"> FANTASCIENZA </a>
		 <a href="#gialli" onclick="MyFunction('Giallo');">GIALLI</a>
		 <a href="#horror" onclick="MyFunction('Horror');" > HORROR </a>
		 <a href="#fantasy" onclick="MyFunction('Fantasy');">FANTASY</a>
		 <a href="#nuovi" onclick="MyFunction1('Nuovo');"> NUOVI</a>
		 <a href="#usati" onclick="MyFunction1('Usato');"> USATI</a>
		<a href="#tutti" onclick="MyFunction2();">TUTTI I LIBRI</a>
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">EBOOK <i class="subnav1"></i></button>
    <div class="subnav-content">
    <a href= "#fantascienza" onclick="MyFunction3('Fantascienza');"> FANTASCIENZA </a>
		 <a href="#gialli" onclick="MyFunction3('Giallo');">GIALLI</a>
		 <a href="#horror" onclick="MyFunction3('Horror');" > HORROR </a>
		 <a href="#fantasy" onclick="MyFunction3('Fantasy');">FANTASY</a>
		 <a href="#tutti" onclick="MyFunction4();"> TUTTI GLI EBOOK</a>
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">AUDIOLIBRI <i class="subnav1"></i></button>
    <div class="subnav-content">
    <a href= "#fantascienza" onclick="MyFunction5('Fantascienza');"> FANTASCIENZA </a>
		 <a href="#gialli" onclick="MyFunction5('Giallo');">GIALLI</a>
		 <a href="#horror" onclick="MyFunction5('Horror');" > HORROR </a>
		 <a href="#fantasy" onclick="MyFunction5('Fantasy');">FANTASY</a>
		 <a href="#tutti" onclick="MyFunction6();"> TUTTI GLI AUDIOLIBRI</a>
    </div>
  </div>
  
  <a href="Index4.jsp">ABBONAMENTI</a>
  <a href="informazioni.jsp">INFORMAZIONI</a>
  
</div> 
  

<br> <br> <br> <br>

<div class="products1"></div>
<hr class="line">
<div class="products">


</div>  



</body>
</html>