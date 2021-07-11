/**
 * 
 */

$(document).ready(function () {
	$.getJSON("DisplayAll", function (object, status){
  		var a = 0;
		for(x in object){
			
		
			
			var x = "<tr> <form action=\"RemoveBookAdmin\" method=\"post\" id=\"a"+ a +"\"></form>" +
		    "<form action=\"ModifyBookAdmin\" method=\"post\" id=\"b"+ a +"\"></form>" +
		    "<td>" + object[x].titolo + " <input type=\"hidden\" form=\"a"+ a +"\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>" +
		    "<input type=\"hidden\" form=\"b" + a + "\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>" +
		    "<td>" + object[x].prezzo + " &euro;" + " <input type=\"hidden\" form=\"a"+ a +"\" name=\"prezzo\" value=\"" + object[x].prezzo + "\"/> </td>" +
		    "<td>" + object[x].editore + " <input type=\"hidden\" form=\"a"+ a +"\" name=\"piattaforma\" value=\"" + object[x].editore + "\"/> </td>" +
		    "<td>" + object[x].genere + " <input type=\"hidden\" form=\"a"+ a +"\" name=\"genere\" value=\"" + object[x].genere + "\"/> </td>" +

		    "<td>" + object[x].quantita + " <input type=\"hidden\" form=\"a"+ a +"\" value=\""+ object[x].quantita+ "\"/> </td>" +
		    "<td><input type=\"image\" form=\"a"+ a +"\" src=\"Css/img_css/x.png\" alt=\"x\" class=\"x\">" +
		    "<input type=\"image\" form=\"b"+ a +"\" src=\"Css/img_css/gear.png\" alt=\"gear\" class=\"gear\"> </td></tr>";
				
			$(".tbodyAdmin").append(x);
			a++;
				}	
			})

})