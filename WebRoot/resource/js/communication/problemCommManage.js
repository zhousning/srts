function change(id)
	{
	  if(id=="question"){
		  if(document.getElementById(id).style.display=='none')
		   { document.getElementById(id).style.display=''; 
		   	document.getElementById("answer").style.display='none';
		   	
		   }
	}else{
			if(document.getElementById(id).style.display=='none')
			 { document.getElementById(id).style.display='';
			 document.getElementById("question").style.display='none'; }
			 
		 }
	}
