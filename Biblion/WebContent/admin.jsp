<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%//check if the user is registered
	Boolean admin = (Boolean) session.getAttribute("isAdmin");
	if((admin == null) || !admin.booleanValue()){
		response.sendRedirect("login.jsp");
	}%>


<jsp:useBean id="session_product" class="it.unisa.Biblion.Model.Libro" ></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Amministratore</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="script/event_home.js"type="text/javascript"></script>
<script type="text/javascript">


function validateRadio (radios)
{
    for (i = 0; i < radios.length; ++ i)
    {
        if (radios[i].checked) return true;
    }
    return false;
}


 function validateUser(){
			
	  var nomeutente=document.forms["regForm1"]["nome_utente"].value;
	  var regex5 =  /^[0-9a-zA-Z]+$/; 
		
	  if (!nomeutente.match(regex5) || nomeutente.length==0)
	  {
		document.getElementById("nomeutentemsg").innerHTML="Nome utente non valido"
	    return false;
	  }
	  document.getElementById("nomeutentemsg").innerHTML=""
	  return true;
 }
		
function validateForm() {
	
	  var  isbn = document.forms["regForm"]["isbn"].value;
	  var regex6 =  /^[0-9]{13}$/;
		
	  if (!isbn.match(regex6) || isbn.length==0 )
	  {
		  document.getElementById("isbnmsg").innerHTML="Isbn non valido"
		  return false;
	  }
	  
	  else{
		  document.getElementById("isbnmsg").innerHTML=""
	  }
	
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
	  
	 alert("Prodotto inserito con successo");    
	 return true;
	  
	
	
	
}	

</script>

<link rel="icon" type="image/png" href="Css/img_css/favicon.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.css">
<link href=' http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="Css/admin.css" type="text/css">
<script src="script/admin.js"type="text/javascript"></script>
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


<div class="box">
	<img class="admin" src="Css/img_css/admin.png" alt="ad">
	<div class="box_text">
		<h2>Nome Utente: ${user.nomeutente} </h2>
		<p style="display:none" id="cf"> ${user.cf} </p>
		<p><span class= "TestoModifica">Nome:</span> ${user.nome}</p>
		<p><span class= "TestoModifica">Cognome:</span> ${user.cognome}</p>
		<p><span class= "TestoModifica">Indirizzo:</span> ${user.indirizzo}</p>
		<p><span class = "TestoModifica">Email:</span> ${user.email}</p>
	</div>
	<div class="box_add">
		<h2>Aggiungi libro: </h2>
		<form action="AddBookAdmin" onsubmit="return validateForm()" method="post" name="regForm">
			<span class="TestoModifica">Isbn:</span> <input class="text_isbn" type="text" name="isbn" placeholder="Isbn" >
			<div id="isbnmsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Titolo:</span> <input class="text_titolo" type="text" name="titolo" placeholder="Titolo">
			<div id="titolomsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Quantità:</span> <input class="text_quantita" type="text" name="quantita" placeholder="Quantita">
			<div id="quantitamsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Editore:</span> <input class="text_editore" type="text" name="editore" placeholder="Editore">
			<div id="editoremsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Anno Edizione:</span> <input class="text_annoEdizione" type="text" name="annoEdizione" placeholder="Anno">
		    <div id="annoedizionemsg" style="color:Red;"></div>
		    
			<br>
			<span class="TestoModifica">Genere:</span> <input class="text_genere" type="text" name="genere" placeholder="Genere">
			<div id="generemsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Prezzo:</span> <input class="text_prezzo" type="text" name="prezzo" placeholder="Prezzo">
			<div id="prezzomsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Pagine:</span> <input class="text_pagine" type="text" name="pagine" placeholder="Pagine">
			<div id="paginemsg" style="color:Red;"></div>
			
			<br>
			<span class="TestoModifica">Autore:</span> <input class="text_autore" type="text" name="autore" placeholder="Autore">
			<div id="autoremsg" style="color:Red;"></div>
			
						<br><span class="TestoModifica">Tipo:</span>
						<div id="tipomsg" style="color:Red;"></div>
						
						<input type="radio" id="Ebook" name="tipologia" value="ebook">
  						<label for="ebook">Ebook</label><br>
 						 <input type="radio" id="Audiolibro" name="tipologia" value="audiolibro">
  						<label for="audiolibro">Audiolibro</label><br>
 						 <input type="radio" id="Nuovo" name="tipologia" value="nuovo">
  						<label for="nuovo" >Nuovo</label> <br>
						 <input type="radio" id="Usato" name="tipologia" value="usato">
  						<label for="nuovo" >Usato</label> <br>
		
		
		
			<input class="button" type="submit" value="invia">
	
		</form>	
	</div>
	<div class="box_query">
		<h2>Visualizza gli ordini: </h2>
		<form onsubmit="return validateUser()" action="ViewOrder" method="post" id="CIAO" name = "regForm1" >	 
			<input class="text_nomeutente" type="text" name="nome_utente" placeholder="Nome utente" >
			<div id="nomeutentenmsg" style="color:Red;"></div>
			<br>
			<input class="text_date" type="date" name="datastart" >
			<br><br>
			<input class="text_date" type="date" name="dataend" >
			<br><br>
			<input class="button" type="submit" value="invia" >
			<div class="error" id="usernameErr"></div>
		</form>	
	</div>
	
	
	
	<div class="box_table" style="overflow-x:auto;">
		<h2>Catalogo libri:</h2>
		<table class="table"  >
			<thead class="thead">
				<tr><th>Titolo</th><th>Prezzo</th><th>Editore</th><th>Genere</th><th>Disponibili</th><th>Gestisci</th></tr>
			</thead>
			<tbody class="tbodyAdmin"></tbody>
		</table>
	</div>
	
</div>





</body>
</html>
