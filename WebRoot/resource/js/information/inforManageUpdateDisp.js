$(function() {
	
	  $("#testDate").datepicker( { 
		  	changeMonth: true, 
		    changeYear: true, 
		    showWeek: true,
		    firstDay: "7",
            showMonthAfterYear : true,
            showButtonPanel:true,
		    currentText:"今天",
		    closeText:"关闭" 
		});

});