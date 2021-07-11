/**
 * 
 */

$(document).ready(function () {
	$.getJSON("PrintOrderView", function (object, status){
		
		var dataConsegna="";
		var idordine=0;
  		var rowstyle="none";
		var rowvalue=0;

		for(x in object){
			
			if (idordine !== object[x].idordine){
				
  				
				idordine=object[x].idordine;
				rowstyle="";
				
				for(y in object){
					
					if (idordine === object[y].idordine) {
						rowvalue++;
					}
					
				}
				
		    }
  			
  			else{
  				rowvalue=0;
  				rowstyle="none";
  				
  			}
			
			if(object[x].tipo==="Ebook" || object[x].tipo==="Audiolibro"){
  				dataConsegna="Scaricabile";
  			}
  	
  			else{
  				dataConsegna = object[x].dataConsegna;
  			}
			
  			var x = "<tr><td>" + object[x].idordine + " </td><td>" + object[x].titolo + " </td><td>" + object[x].quantita + "</td><td>"+ object[x].tipo + "</td><td>" + object[x].prezzo * object[x].quantita + " &euro;" + " </td><td>" + object[x].data + "</td><td>"+ dataConsegna + "</td><td>" + object[x].cf +  "  </td><td rowspan="+rowvalue+" style=display:"+rowstyle+">" + object[x].prezzoTotale + " &euro;" + "</td></tr>"
 
				
			$(".tbodyOrder").append(x);
  			
			if(rowvalue===1){
				rowvalue=0;
				rowstyle="none";
			}
		}	
	})

})