 window.onload = function(){
    var oTable = document.getElementById("self_add");
    for(var i=0;i<oTable.rows.length;i++){
    oTable.rows[i].cells[0].innerHTML = (i+1);
    }
    }