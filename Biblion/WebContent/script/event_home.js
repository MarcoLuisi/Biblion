
function MyFunction(genere){
	
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            
            document.getElementsByClassName('products1')[0].innerHTML= 
        		"<h1 id = \"offerte\" style=\"text-align: center;\"> Genere: "+genere+" </h1>";
         
          
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" + "</p>" +
						/*
						"<p> Tipo: " + libro.tipo + "</p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
            
                
        }
    }
 
  
    
    var url="./LibriSpecifici?val="+genere+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
    
   
}




function MyFunction1(Tipologia){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            
            document.getElementsByClassName('products1')[0].innerHTML= 
        	"<h1 id = \"offerte\" style=\"text-align: center;\"> Tipologia: "+Tipologia+" </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" + "</p>" +
						/*
						"<p> Tipo: " + libro.tipo + "</p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./LibriSpecifici1?val="+Tipologia+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
    
   
}






function MyFunction2(){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            

            document.getElementsByClassName('products1')[0].innerHTML= 
        	"<h1 id = \"offerte\" style=\"text-align: center;\"> Tutti i libri </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div class = \"card_content\">" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" + "</p>" +
						/*
						"<p> Tipo: " + libro.tipo + "</p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./Tutti";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
    
   
}




function MyFunction3(genere){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            
            document.getElementsByClassName('products1')[0].innerHTML= 
            "<h1 id = \"offerte\" style=\"text-align: center;\"> Genere: "+genere+" </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" + "</p>" +
						/*
						"<p> Tipo: Ebook </p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./EbookSpecifici?val="+genere+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
}



function MyFunction4(){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            
            document.getElementsByClassName('products1')[0].innerHTML= 
            	"<h1 id = \"offerte\" style=\"text-align: center;\"> Tutti gli ebook </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" + "</p>" +
						/*
						"<p> Tipo: Ebook </p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                        
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./TuttiEbook";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
    
   
}


function MyFunction5(genere){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
          
            document.getElementsByClassName('products1')[0].innerHTML= 
            	"<h1 id = \"offerte\" style=\"text-align: center;\"> Genere: "+genere+" </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" +"</p>" +
						/*
						"<p> Tipo: Audiolibro </p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./AudiolibriSpecifici?val="+genere+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
}




function MyFunction6(){
	
	var data;
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {
           
        	
        	data = xhr.responseText;
            var object=JSON.parse(data);
            
            document.getElementsByClassName('products1')[0].innerHTML= 
            	"<h1 id = \"offerte\" style=\"text-align: center;\"> Tutti gli audiolibri </h1>";
            
            $(".card").remove();
			var num = 0;
            for(x in object){
            	var libro = object[x];
            	
            	
            	
            	
            	
            	var card = $(
						"<div class=\"card\">" +
						"<a href = \"./Libro.jsp?titolo="+libro.titolo+"\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "</a>"+
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Prezzo: </span>" + libro.prezzo + " &euro;" +"</p>" +
						/*
						"<p> Tipo: Audiolibro </p>" +
						"<p> Genere: " + libro.genere + "</p>" +
						"<p> Disponibili: "+ libro.quantita +"</p>"+
						"<p> Editore: "+ libro.editore + "</p>" +
						"<p> Anno Edizione: "+ libro.annoEdizione + "</p>" +
						"<p> Pagine: "+ libro.pagine + "</p>" +
						*/
						"</div>" +
						"<input class=\"button_car\" form=\"genereForm_"+ num +"\" type=\"submit\" value=\"Aggiungi al carrello\">"+
                       
						"</div>" 
					);
            	
            	$(".products").append(card);
            	num++;
            	}
            $(".card_image").hide();
			$(".card_image").fadeIn(4000);
			
			 $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
        }
    }
 
  
    
    var url="./TuttiAudioLibri";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);
	
    
   
}









