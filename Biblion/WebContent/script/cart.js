/**
 * 
 */
$(document).ready(function (){
	$.getJSON("DisplayCart", function (object, status){
		
		var a = 0;
		var totale = 0;
		
		
		for(x in object){
			
		
				
			var cart =
				"<tr> <form action=\"Add_one\" method=\"post\" id=\"a"+ a +"\"></form>" +
	        	"<form action=\"Remove_one\" method=\"post\" id=\"b"+ a +"\"></form>" +
	        	"<td>" + object[x].titolo + " <input type=\"hidden\" form=\"a"+ a +"\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> <input type=\"hidden\" form=\"b"+ a +"\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>" +
	        	"<td class=\"quantita\"> <input type=\"image\" form=\"a"+ a +"\" src=\"Css/img_css/+.png\" alt=\"+\" class=\"piu\">" + 
	            	object[x].quantita +
	            "<input type=\"image\" form=\"b"+ a +"\" src=\"Css/img_css/-.png\" alt=\"-\" class=\"meno\"> </td>" +
	            "<td>" + object[x].tipo + "</td>" +
	        	"<td>" + object[x].prezzo + " &euro;" + " </td></tr>";
	        	
			$(".tbodyCart").append(cart);
			
			totale = totale + (object[x].prezzo * object[x].quantita);
			
			
			a++;

		}
		$(".h3").text("Totale: " + totale + " Euro" );
	})
})
