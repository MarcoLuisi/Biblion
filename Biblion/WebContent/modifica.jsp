<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//check if the user is registered
	Boolean logged = (Boolean) session.getAttribute("isLog");
	if((logged == null) || !logged.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>
	
	 <%@ page import="it.unisa.Biblion.DAO.*, it.unisa.Biblion.Model.*" %>
<jsp:useBean id="session_product" class="it.unisa.Biblion.Model.Libro" ></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modifica</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script src="script/event_home.js"type="text/javascript"></script>
	<script src="script/storicoordini.js"type="text/javascript"></script>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
	<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="Css/modifica.css" type="text/css">
	<script>
	
	function validateRadio (radios)
	{
	    for (i = 0; i < radios.length; ++ i)
	    {
	        if (radios[i].checked) return true;
	    }
	    return false;
	}
	
	
	
	function validateForm() {
		

		  var  titolo = document.forms["regForm"]["titolo"].value;
		  var regex =  /^[0-9a-zA-Z\s]+$/; 
			
		  if (!titolo.match(regex) || titolo.length==0)
		  {
			  document.getElementById("titolomsg").innerHTML="Titolo non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("titolomsg").innerHTML=""
				  
		  }
		  
		  var quantita = document.forms["regForm"]["quantita"].value;
		  var q = Math.floor(Number(quantita));
		  
		  if (q == Infinity || q<=0  || String(q) !== quantita){
			  document.getElementById("quantitamsg").innerHTML="Quantità non valida"
			  return false;
		  }
		  
		  else{
			  document.getElementById("quantitamsg").innerHTML=""
			  
		  }
		  
		  var editore=document.forms["regForm"]["editore"].value;
		  var regex1 = /^[A-Za-z\s]+$/;
			
		  if (!editore.match(regex1) || editore.length==0)
		  {
			  document.getElementById("editoremsg").innerHTML="Editore non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("editoremsg").innerHTML=""
				  
		  }
		  
		  var annoEdizione=document.forms["regForm"]["annoEdizione"].value;
		  var anno = Math.floor(Number(annoEdizione));
		  
		  if (anno == Infinity || anno<=1499 ||  String(anno) !== annoEdizione){
			  document.getElementById("annoedizionemsg").innerHTML="Anno Edizione non valido"
			  return false;
		  } 
		  
		  else{
			  document.getElementById("annoedizionemsg").innerHTML=""
		  }
		  
		  var genere=document.forms["regForm"]["genere"].value;
		  var regex2 = /^[A-Za-z\s]+$/;
			
		  if (!genere.match(regex2) || genere.length==0)
		  {
			  document.getElementById("generemsg").innerHTML="Genere non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("generemsg").innerHTML=""
				 
		  }
		  
		  var prezzo=document.forms["regForm"]["prezzo"].value;
		  var regex3 = /^-?\d*(\.\d+)?$/;
			
		  if (prezzo == "" || !prezzo.match(regex3))
		  {
			  document.getElementById("prezzomsg").innerHTML="Prezzo non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("prezzomsg").innerHTML=""
		  }
		  
		  
		  var pagine=document.forms["regForm"]["pagine"].value;
		  var p = Math.floor(Number(pagine));
		  
		  if (pagine == Infinity || pagine<=0 || String(p) !== pagine){
			  document.getElementById("paginemsg").innerHTML="Numero di pagine non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("paginemsg").innerHTML=""
		  }
		  
		  var autore=document.forms["regForm"]["autore"].value;
		  var regex4 = /^[a-zA-Z\s]*$/;
			
		  if (autore.length == 0 || !autore.match(regex4))
		  {
			  document.getElementById("autoremsg").innerHTML="Autore non valido"
			  return false;
		  }
		  
		  else{
			  document.getElementById("autoremsg").innerHTML=""
				  
		  }
		  
		  if(!validateRadio (document.forms["regForm"]["tipologia"]))
		  {
			  document.getElementById("tipomsg").innerHTML="Nessun tipo selezionato"
			  return false;
		  }
		  
		  else{
			  
			  document.getElementById("tipomsg").innerHTML=""
		  }
		  
		 alert("Prodotto modificato con successo");    
		 return true;
		  
		

	}
	
		
	  
	</script>
</head>

<body style="background: url(Css/img_css/LRbackgroung1.jpg);">

<%LibroDAO l = new LibroDAO();  %>
<%String tit = request.getParameter("titolo");%>
<% Libro lib = l.searchTitle(tit); %> 
<% boolean x = lib.isAudiolibro(); %>
<% boolean y = lib.isEbook(); %>
<% String z = lib.getTipo(); %>




<!--Header Menu-->
<header>

    <a href="Index.jsp" class="header_logo"><img src="Css/img_css/logo.jpg" height=107 width=107 alt="Logo" class="header_logo_img"></a>
 
 	  <div class ="header_menu_search"><form name = barra_di_ricerca action = "./Libro.jsp"><input type = "text" class="barra" name = "titolo" placeholder = "Digita..">
   														   <input type ="submit" class="ricercabutton" value="Cerca"/>
   																	
   	</form> </div>
 
 
  </header>
  
   <div class="navbar">
</div>

<br><br>

<div class="box">
	<div class="box_conf">
		<h2>Modifica Libro: </h2>
		<form name = "regForm" action="UpdateBookAdmin" onsubmit="return validateForm()" method="post" >	
			
			<span class="TestoModifica">Titolo:</span><input class="text_titolo" type="text" name="titolo" placeholder="Titolo" 
			value="${product.titolo}">
			<div id="titolomsg" style="color:Red;"></div>
			
			<input class="text_isbn" type="hidden" name="isbn"  value="${product.isbn}">
			
			<br>
			<span class="TestoModifica">Quantità:</span> <input class="text_quantita" type="text" name="quantita" placeholder="Quantita" 
			value="${product.quantita}">
			<div id="quantitamsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Editore: </span> <input class="text_editore" type="text" name="editore" placeholder="Editore"
			value = "${product.editore}">
			<div id="editoremsg" style="color:Red;"></div>
			
			<br>
			<span class ="TestoModifica">Anno Edizione:</span> <input class="text_annoEdizione" type="text" name="annoEdizione" placeholder="Anno Edizione"
			value = "${product.annoEdizione}">
			<div id="annoedizionemsg" style="color:Red;"></div>
			
			<br>
			<span class ="TestoModifica">Genere: </span> <input class="text_gen" type="text" name="genere" placeholder="Genere"
			value = "${product.genere}">
		    <div id="generemsg" style="color:Red;"></div>
		
			<br>
			<span class ="TestoModifica">Prezzo:</span> <input class="text_prezzo" type="text" name="prezzo" placeholder="Prezzo"
			value = "${product.prezzo}">
			<div id="prezzomsg" style="color:Red;"></div>
			
			<br>
			<span class ="TestoModifica">Autore:</span> <input class="text_autore" type="text" name="autore" placeholder="Autore"
			value = "${product.autore}">
			<div id="autoremsg" style="color:Red;"></div>
			
			<br>
			<span class ="TestoModifica">Pagine:</span> <input class="text_pagine" type="text" name="pagine" placeholder="Pagine"
			value = "${product.pagine}">
			<div id="paginemsg" style="color:Red;"></div>
			
					<br> <span class ="TestoModifica"> Tipo: </span> 
					<div id="tipomsg" style="color:Red;"></div>
						
					<% if (x){%>
						
						<input type="radio" id="Ebook" name="tipologia" value="ebook">
  						<label for="ebook">Ebook</label><br>
 						 <input type="radio" id="Audiolibro" name="tipologia" value="audiolibro" checked>
  						<label for="audiolibro">Audiolibro</label><br>
 						 <input type="radio" id="Nuovo" name="tipologia" value="nuovo">
  						<label for="nuovo" >Nuovo</label> <br>
						 <input type="radio" id="Usato" name="tipologia" value="usato">
  						<label for="nuovo" >Usato</label> <br>
					<%}
				
					%>
					
					<% if (y){ %>
							 
					    <input type="radio" id="Ebook" name="tipologia" value="ebook" checked>
  						<label for="ebook">Ebook</label><br>
 						 <input type="radio" id="Audiolibro" name="tipologia" value="audiolibro">
  						<label for="audiolibro">Audiolibro</label><br>
 						 <input type="radio" id="Nuovo" name="tipologia" value="nuovo">
  						<label for="nuovo" >Nuovo</label> <br>
						 <input type="radio" id="Usato" name="tipologia" value="usato">
  						<label for="nuovo" >Usato</label> <br>
							
							
							<%}
					%>
					
					<% if (z!=null && z.equals("Nuovo")){ %>
					 	<input type="radio" id="Ebook" name="tipologia" value="ebook" >
  						<label for="ebook">Ebook</label><br>
 						 <input type="radio" id="Audiolibro" name="tipologia" value="audiolibro">
  						<label for="audiolibro">Audiolibro</label><br>
 						 <input type="radio" id="Nuovo" name="tipologia" value="nuovo" checked>
  						<label for="nuovo" >Nuovo</label> <br>
						 <input type="radio" id="Usato" name="tipologia" value="usato">
  						<label for="nuovo" >Usato</label> <br>
					<% }
					%>
					
					<% if (z!=null && z.equals("Usato")){ %>
					 	<input type="radio" id="Ebook" name="tipologia" value="ebook" >
  						<label for="ebook">Ebook</label><br>
 						 <input type="radio" id="Audiolibro" name="tipologia" value="audiolibro">
  						<label for="audiolibro">Audiolibro</label><br>
 						 <input type="radio" id="Nuovo" name="tipologia" value="nuovo" >
  						<label for="nuovo" >Nuovo</label> <br>
						 <input type="radio" id="Usato" name="tipologia" value="usato" checked>
  						<label for="nuovo" >Usato</label> <br>
					<% }
					%>

				
			<input class="button" type="submit" value="invia">
		</form>	
	</div>
</div>

</body>
</html>