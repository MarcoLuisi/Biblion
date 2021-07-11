<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	 <%@ page import="it.unisa.Biblion.DAO.*, it.unisa.Biblion.Model.*" %>

<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>    
   
 
<jsp:useBean id="session_user" class="it.unisa.Biblion.Model.Utente" ></jsp:useBean>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area personale</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/event_home.js"type="text/javascript"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/utente.css" type="text/css">
<script src="script/utente.js"type="text/javascript"></script>




</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">


<header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
   	
   	  <div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
   	
   	 <div class="header_menu">
  	<div class="header_menu_item_login"><a href="Logout">   <img src="Css/img_css/logout.png" alt="img_login" height=107 width=107></a></div>
  	<div class="header_menu_item_login2"><a href="carrello.jsp">    <img src="Css/img_css/carrello.png" alt="img_Carrello" height=107 width=107></a></div>
   </div>
   
 </header>
 
 <div class="navbar">
</div>
 
 <br> <br>

<div class="box">
	
	<div class="box_text">
		<h2>Nome Utente: ${user.nomeutente}</h2>
		<p style="display:none" id="idutente"> ${user.cf} </p>
		<p><span class= "TestoModifica">Nome:</span> ${user.nome}</p>
		<p><span class= "TestoModifica">Cognome:</span> ${user.cognome}</p>
		<p><span class= "TestoModifica">Indirizzo:</span> ${user.indirizzo}</p>
		<p><span class = "TestoModifica">Email:</span> ${user.email}</p>
		
	</div>
	
	
	<div class="box_table_ord">
		<h2>I miei ordini/Acquisti digitali:</h2>
		<table class="table">
			<thead class="thead">
				<tr><th>Id Ordine</th><th>Titolo</th><th>Quantita</th><th>Tipo</th><th>DataEffettuazione</th><th>DataConsegna</th><th>Prezzo</th><th>Totale</th></tr>
			</thead>
			<tbody class="tbody_order">

			</tbody>
		</table>
	</div>
</div>



 

</body>
</html>