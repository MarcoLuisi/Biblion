/**
 * 
 */

$(document).ready(function (){
	
	  document.getElementsByClassName('products1')[0].innerHTML= 
		"<h1 id = \"offerte\" style=\"text-align: center; \"> Offerte del mese </h1>";
   
	

		$.getJSON("DisplayOfferte", function (object, status){
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
			  
			  $(".card_image").hover(function() {
				  $(this).css("transform", "scale(1.1)");
			  },  
			      function(){
			      $(this).css("transform", "scale(1.0)");
		      });
		      
			
		
			
		})
		
	})