<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="it.unisa.Biblion.DAO.*, it.unisa.Biblion.Model.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblion</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/event_home.js"type="text/javascript"></script>	
<script>

$(document).ready(function (){
	$(".card_image").hover(function() {
	  	$(this).css("transform", "scale(1.1)");
	},  
    	function(){
    		$(this).css("transform", "scale(1.0)");
	});
});

</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/Libro.css" type="text/css">
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


<br><br><br>

<h1 style="text-align:center;">Dettagli libro</h1>

<hr class="line">

<%LibroDAO l = new LibroDAO();  %>
    
 
	
<%String tit = request.getParameter("titolo");%>
	
<% Libro lib = l.searchTitle(tit); %> 
	
	<% if (lib == null){ %>
		<div class = "errorRicerca"> <p class ="errorRicerca1" style="text-align:center; font-weight:bold; font-size:35px;"> Nessun elemento trovato </p> </div>
	 <%}
	
	 else{ %>
	 
	 	<% boolean x = lib.isAudiolibro(); %>
	 	<% boolean y = lib.isEbook(); %>
	 	<% String z = lib.getTipo(); %>
	 	
	 	<div class = "box">

 		<div class="box1">
	 	
	 	<img class="card_image" src=<%=lib.getPath()%>>  
                    <form action="AddToCart" method="post" id="genereForm_" ></form> 
                    <input type="hidden" form="genereForm" name="isbn" value=<%=lib.getIsbn() %>>
                 
                  
                   
		</div> 
		
		
		
		<div class="box1">
			<div class="box2">
			
			<form action="AddToCart" method="post" id="genereForm_"></form>
                        <input type="hidden" form="genereForm_" name="isbn" value="<%=lib.getIsbn()%>" >
			<h3><%=lib.getTitolo() %> </h3> 
					<p> <span class ="inf">Prezzo: </span><%=lib.getPrezzo()%>  &euro;</p>
					<p> <span class = "inf">Genere: </span><%=lib.getGenere() %> </p>
					<p> <span class = "inf">Disponibili: </span> <%=lib.getQuantita() %> </p>
					<p> <span class = "inf">Editore: </span>  <%=lib.getEditore() %>  </p>
					<p> <span class = "inf">Anno Edizione: </span><%=lib.getAnnoEdizione() %>  </p>
					<p> <span class = "inf">Pagine: </span><%=lib.getPagine() %>  </p>
					<p> <span class = "inf">Autore: </span><%=lib.getAutore() %>  </p>
					
					<% if (x){
						%>
						<p> <span class = "inf">Tipo: </span>Audiolibro </p>
					<%}
				
					%>
					
					<% if (y){ %>
							<p> <span class = "inf">Tipo: </span>Ebook </p>
							<%}
					%>
					
					<% if (z != null){ %>
					 		<p> <span class = "inf">Tipo: </span><%=lib.getTipo() %> </p>
					<% }
					%>
					
					<input class="button_car" form="genereForm_" type="submit" value="Aggiungi al carrello">
					</div>
			</div>
					
		

	 	
	 	</div>
	 	
	<%}  %>

</body>
</html>