/**
 * 
 */


$(document).ready(function (){
	
	
		$.getJSON("DisplayLibriAbbonamento1", function (object, status){
			
			var tipo="";
			
			$(".card").remove();
			var num = 0;
			for(x in object){

				var libro = object[x];
				
				if (libro.ebook){
					tipo="Ebook";
				}
				
				else{
					tipo="Audiolibro";
				}
				
				var card = $(
						"<div class=\"card\">" +
                        "<img class=\"card_image\" src=" + libro.path +">" +
                        "<form action=\"AddToCart\" method=\"post\" id=\"genereForm_"+ num +"\"></form>" +
                        "<input type=\"hidden\" form=\"genereForm_"+ num +"\" name=\"isbn\" value=\"" + libro.isbn + "\">" +
                        
                        "<div>" +
						"<h3>" + libro.titolo + "</h3>" +
						"<p> <span> Genere: </span>" + libro.genere + "</p>" +
						"<p> <span> Editore:</span> "+ libro.editore + "</p>" +
						"<p> <span> Anno Edizione:</span> "+ libro.annoEdizione + "</p>" +
						"<p> <span> Pagine:</span> "+ libro.pagine + "</p>" +
						"<p> <span> Autore:</span> "+ libro.autore + "</p>" +
						"<p> <span> Tipo:</span> "+ tipo + "</p>" +
						"</div>" +
						"</div>" 
						);

				$(".products").append(card);	
				num++;
			}
			
			  $(".card_image").hide();
				$(".card_image").fadeIn(4000);
			
		})
	})
	