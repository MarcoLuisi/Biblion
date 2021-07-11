<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="Css/Login.css">
<title>login</title>
</head>
<body style="background: url(Css/img_css/LRbackgroung1.jpg);">


		<div class="loginbox">
			<h1 style="font-style:italic;">Login</h1>
			
			<%Boolean logged = (Boolean) session.getAttribute("isWrong"); 
			if(logged != null){
				if(logged.booleanValue()) {%>
					<script>
						alert("Username o password errata");
					</script>
				<%}%>
			<%}%>
			
			<form action="Login" method="post">
				<input type="text" placeholder="Username" name="username" required><br>
				
				<input type="password" placeholder="Password" name="password" required><br>
				
				<input type="submit" value="Login"><br>
				
				<a href="registrazione.html"> Non hai un account ? Registrati ora...</a>
			</form>
		</div>
	

</body>
</html>