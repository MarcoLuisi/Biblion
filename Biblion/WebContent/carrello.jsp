<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
<jsp:useBean id="session_cart" class="it.unisa.Biblion.Model.Libro" ></jsp:useBean>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/cart.js"type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/carrello.css" type="text/css">

</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">


 
 
 <header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
   	 
   	   <div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
   	 
   	 <div class="header_menu">
  		
  		<%Boolean logged1 = (Boolean) session.getAttribute("isLog"); 
			if(logged != null){
				if(logged1.booleanValue()) {%>
						<% Boolean admin = (Boolean) session.getAttribute("isAdmin");
						if(admin.booleanValue()) {%>
							<div class="header_menu_item_login"><a href="admin.jsp">  <img src="Css/img_css/admin.png" alt="img_login"></a></div>
						<%} else { %>
							<div class="header_menu_item_login"><a href="utente.jsp"> <img src="Css/img_css/login.png" alt="img_login"></a></div>
						<%} %>
					<%} %>
		<%} else if(logged1 == null || logged1.booleanValue() == false) {%>
						<div class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/login.png" alt="img_login"></a></div>
						
		<%} %>
  	
   </div>
   
 </header>
  <div class="navbar">
</div>
<br><br>
<div class="box">
	<div class="box_table">
		<h2 style = "font-style:italic;">Carrello:</h2>
		<table class="table">
			<thead class="thead">
				<tr><th>Titolo</th><th>Quantità</th><th>Tipo</th><th>Prezzo</th></tr>
			</thead>
			<tbody class="tbodyCart">

			</tbody>
		</table>
	</div>
	<div class="box_text">
		<h3 class="h3"></h3>
		<input id="invia" class="button" type="submit" value="Procedi All'acquisto">
	</div>
</div>
 
<script>
$("#invia").click(function() {
	$.getJSON("Ordine", function (object, status){
		var string = JSON.stringify(object);
		alert(string);
		location.reload();
	})
})
</script>



</body>
</html>