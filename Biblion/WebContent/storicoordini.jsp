<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
<jsp:useBean id="session_view_order" class="it.unisa.Biblion.Model.Ordine" ></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico Ordini</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/event_home.js"type="text/javascript"></script>
<script src="script/storicoordini.js"type="text/javascript"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/storicoordini.css" type="text/css">
</head>

<body style="background: url(Css/img_css/LRbackgroung1.jpg);">

<!--Header Menu-->
<header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
 	
 	    <div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
 
  </header>
  
  <div class="navbar">
</div>


<br><br><br>

<div class="box">
	<div class="box_table">
		<h2 style="font-style:italic;">Ordini:</h2>
		<table class="table">
			<thead class="thead">
				<tr><th>n° Ordine</th><th>Titolo</th><th>Quantità</th><th>Tipo</th><th>Prezzo</th><th>DataEffettuazione</th><th>DataConsegna</th><th>Acquirente</th><th>Costo Totale</th></tr>
			</thead>
			<tbody class="tbodyOrder">
			
			</tbody>
		</table>
	</div>
	<div class="box_text">
		<form action="admin.jsp">
			<input class="button" type="submit" value="Indietro">
		</form>
	</div>
</div>


</body>
</html>
