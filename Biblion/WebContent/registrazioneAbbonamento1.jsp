<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione Abbonamento</title>

<link rel="stylesheet" type="text/css" href="Css/Registration.css">
	
<script>

function validateForm() {
	
	  var cf=document.forms["regForm"]["cf"].value;
	  var regex = /[A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1}/;
	
	  if(!cf.match(regex) || cf.length != 16)
	  {  
		  document.getElementById("cfmsg").innerHTML="Codice fiscale non valido"
		   return false;
	  }  
	  
	  else{
		  document.getElementById("cfmsg").innerHTML="" 
	  }
	  
	  var username=document.forms["regForm"]["username"].value;
	  var regex4 =  /^[0-9a-zA-Z]+$/; 
		
	  if (!username.match(regex4) || username.length==0)
	  {
		 
		 document.getElementById("usernamemsg").innerHTML="Username non valido"
		 return false;
	  }
	  
	  else{
		  document.getElementById("usernamemsg").innerHTML=""
		  
	  }
		
	  
	  var password=document.forms["regForm"]["passAbb"].value;
	
	  if (password.length < 8)
	  {
		  document.getElementById("passwordmsg").innerHTML="Password non valida"
	      return false;
	  }
	  
	  else{
		  document.getElementById("passwordmsg").innerHTML=""
		 
	  }
		  
	
	  return true;
	  
}
	
</script>
	
</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">


<div class="regibox">

		<h1 style="font-style:italic;">Registrazione</h1>
		<form name="regForm" onsubmit="return validateForm()" action="Registrazione2" method="post">
		    
			<input type="text" name ="cf" placeholder="Codice fiscale" class="normal"><br>
			<div id="cfmsg" style="color:Red;"></div>
			
			<input type="text" name="username" placeholder="Username" class="special"> <br>
		      <a class="mini">Sono ammessi sia lettere sia numeri </a>
		     <div id="usernamemsg" style="color:Red;"></div>
			
			
			<input type="password" name="passAbb" placeholder="Password" class="special"> <br>
			<a class="mini">lunghezza minima 8 caratteri</a> 
		    <div id="passwordmsg" style="color:Red;"></div>
			 
			 <br> 
			<label  class="container1">Mensile - Prezzo: 3.50
  			<input type="radio" checked="checked" name="durata" value = "mensile">
  			<span class="checkmark"></span>
			</label>
			
			<label  class="container1">Annuale - Prezzo: 12.50
  			<input type="radio" name="durata" value = "annuale">
  			<span class="checkmark"></span>
			</label>
		 
		    
		    <input type="submit" value="Iscriviti">	  
		    
		    
		   
		</form>

	</div>  
</body>
</html>