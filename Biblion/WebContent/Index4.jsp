<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblion</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/Abbonamento.css" type="text/css">
</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">

<!--Header Menu-->
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
						<div class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/login.png" alt="img_login"></a></div>
						
		<%} %>
  	</div>
  	
</header>

<div class="navbar">
</div>


<br><br>


<div class = "box">

 <div class="box1">

  <p class="title">
     Alexandria
  </p>
 

 
 <form action="" name="form">
 
 <p class = "text"> Il servizio Alexandria consente di leggere
 i classici della letteratura in formato digitale </p>
 
 <%Boolean logged1 = (Boolean) session.getAttribute("isLogAbbonato"); 
			if(logged1 != null){
				if(logged1.booleanValue()) {%>
						
   						 <input type="submit" class="button" value="Accedi" formaction="./libriAbbonamento.jsp"/>
						
					<%} %>
		<%} else if(logged1 == null || logged1.booleanValue() == false) {%>
				
    			<input type="submit" class = "button" value="Accedi" formaction="./loginAbbonamento.jsp" />
				
		<%} %>
 


 
    <input type="submit" class = "button" value="Iscriviti ora!" formaction="./registrazioneAbbonamento.jsp"/>

 </form>

</div>


 

<div class="box1">

  <p class="title">
    E-Biblion
  </p>
 

 
 <form action="" name="form">
 
 <p class = "text"> Il servizio E-Biblion consente di usufruire
 di moltissimi libri universitari e scolastici in formato digitale </p>
 
 <%Boolean logged2 = (Boolean) session.getAttribute("isLogAbbonato1"); 
			if(logged2 != null){
				if(logged2.booleanValue()) {%>
						
   						 <input type="submit" class = "button" value="Accedi" formaction="./libriAbbonamento1.jsp"/>
						
					<%} %>
		<%} else if(logged2 == null || logged2.booleanValue() == false) {%>
				
    			<input type="submit" class = "button" value="Accedi" formaction="./loginAbbonamento1.jsp" />
				
		<%} %>
 


 
    <input type="submit" class = "button" value="Iscriviti ora!" formaction="./registrazioneAbbonamento1.jsp"/>

 </form>

</div>


</div>



 <div class=foto>
 <div class ="alexandria">
 <img src = "Css/img_css/Alexandria.jpg" class="alexandriafoto">
</div>


<div class ="ebiblion">
 <img src = "Css/img_css/E-biblion.jpg" class="ebiblionfoto">
</div>
</div>


</body>
</html>