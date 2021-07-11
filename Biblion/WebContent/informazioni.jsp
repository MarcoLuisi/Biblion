<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informazioni</title>
<link rel="stylesheet" href="Css/informazioni.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
						<div class="header_menu_item_login"><a href="login.jsp"><img src="Css/img_css/login.png" alt="img_login"></a></div>
						
		<%} %>
  	</div>
  	
</header>

<div class="about-section">
  <h1>Chi siamo?</h1>
  <p>Il sito è stato realizzato da Marco Luisi, Rocco Daniel Di Filippo, e Roberto Iannarella, studenti iscritti alla facoltà di informatica dell'Università degli studi di Salerno. </p>
  <p>Abbiamo deciso di chiamare il sito web "Biblíon", questa parola in greco classico significa "libro" o "opera". Con il passare del tempo il termine biblion si è conservato nella parola biblioteca appunto "Scrigno di libri" come la nostra libreria online.</p>
</div>

<h2 style="text-align:center">Sezione Contatti</h2>
<div class="row">
  <div class="column">
    <div class="card">
      
      <div class="container">
        <h2>Servizio clienti</h2>
        
        <p>Chiamaci al +39 02 92435290 </p>
			<p>Lunedì - Venerdì 8:30 - 22:00 </p>
			<p>Sabato 8:30 - 18:00</p>
        
       
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
    
      <div class="container">
        <h2>Email</h2>
       
        <p>Per ricevere assistenza via e-mail </p>
       <p> Scrivici a</p>
        <p>BiblionUnisa@gmail.com</p>
        
       
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      
      <div class="container">
        <h2>Social</h2>
       
        <p>Per ricevere assistenza via social, usa i seguenti link:</p>
        <ul>
        	<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
        	<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
        	<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
        	<li><a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>
        </ul>
       
      </div>
    </div>
  </div> 
</div>

</body>
</html>