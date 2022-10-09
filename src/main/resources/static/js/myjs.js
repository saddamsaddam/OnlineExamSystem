$(document).ready(function(){
 document.querySelector("#file-upload").onchange = function(){
  document.querySelector("#file-name").textContent = this.files[0].name;
   $("#cross").html('<span class="glyphicon glyphicon-remove"></span>');
    document.getElementById("workc").style.display = "block";
}
});

function fileremove(){
	
	 document.getElementById("workc").style.display = "none";
}

function privatecomment(){
	document.getElementById("pvcmtbutton").style.display = "none";
	document.getElementById("inputboxprivate").style.display = "inline-block";
	document.getElementById("btnsubmit").style.display = "inline-block";
	}
	
function publiccomment(){
	document.getElementById("publicbutton").style.display = "none";
	document.getElementById("inputboxpublic").style.display = "inline-block";
	document.getElementById("btnsubmitpublic").style.display = "inline-block";
	}
	
	
function copyEvent(id)
    {
        var str = document.getElementById(id);
        window.getSelection().selectAllChildren(str);
        document.execCommand("Copy")
    }
    
  $(document).ready(function() {
  $("#headercheckbox").click(function(event) {
   			 if ($("#headercheckbox").is(":checked")) {
                $(".studentcheckbox").prop("checked", true );
            } else {
               $(".studentcheckbox").prop('checked', false );
            }
  });
});

$(document).ready(function() {
  $(".studentcheckbox").click(function(event) {
	 $("#headercheckbox").prop('checked', false );
  });
});

$(document).ready(function() {
  $("#assigncheckbox").click(function(event) {
   			 if ($("#assigncheckbox").is(":checked")) {
                $(".assigncheckbox").prop("checked", true );
            } else {
               $(".assigncheckbox").prop('checked', false );
            }
  });
});

$(document).ready(function() {
  $(".assigncheckbox").click(function(event) {
	 $("#assigncheckbox").prop('checked', false );
  });
});

$(document).ready(function() {
  $("#turnedcheckbox").click(function(event) {
   			 if ($("#turnedcheckbox").is(":checked")) {
                $(".turnedcheckbox").prop("checked", true );
            } else {
               $(".turnedcheckbox").prop('checked', false );
            }
  });
});

$(document).ready(function() {
  $(".turnedcheckbox").click(function(event) {
	 $("#turnedcheckbox").prop('checked', false );
  });
});
$(document).ready(function() {
  $("#returnedcheckbox").click(function(event) {
   			 if ($("#returnedcheckbox").is(":checked")) {
                $(".returnedcheckbox").prop("checked", true );
            } else {
               $(".returnedcheckbox").prop('checked', false );
            }
  });
});

$(document).ready(function() {
  $(".returnedcheckbox").click(function(event) {
	 $("#returnedcheckbox").prop('checked', false );
  });
});

function turnedInf(){
	document.getElementById("turnedin").style.display = "inline-block";
	document.getElementById("assignedin").style.display = "none";
	document.getElementById("returnedin").style.display = "none";
	document.getElementById("allin").style.display = "none";
	
	}
	
	function assignedInf(){
	document.getElementById("turnedin").style.display = "none";
	document.getElementById("assignedin").style.display = "inline-block";
	document.getElementById("returnedin").style.display = "none";
	document.getElementById("allin").style.display = "none";
	
	}
	function returnedInf(){
	document.getElementById("turnedin").style.display = "none";
	document.getElementById("assignedin").style.display = "none";
	document.getElementById("returnedin").style.display = "inline-block";
	document.getElementById("allin").style.display = "none";
	
	}
	function allInf(){
	document.getElementById("turnedin").style.display = "none";
	document.getElementById("assignedin").style.display = "none";
	document.getElementById("returnedin").style.display = "none";
	document.getElementById("allin").style.display = "inline-block";
	
	}
	
$(document).ready(function() {
  $("#turnoff").click(function(event) {
 document.getElementById("turnoffdiv").style.display = "none";
  });
 // $('#admintextarea').richText();
  $("#announce").click(function(event) {
	$('#admintextarea').richText();
	document.getElementById("announce").style.display = "none";
	document.getElementById("admintextareafirst").style.display = "inline-block";
	document.getElementById("admintextareasecond").style.display = "inline-block";
	document.getElementById("admintextareathird").style.display = "inline-block";
	
  });
  

});
	
	
	