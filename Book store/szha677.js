var currentTab = "";
      function openTab1() {
         if (currentTab != "tab1") {
            currentTab = "tab1";
            showNoTabs();
			
            document.getElementById("SectionA").style.display = "block";
			var xhr = new XMLHttpRequest();
			var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/booklist";
			xhr.open("GET", uri, true);
			xhr.setRequestHeader("Accept", "application/json");
			xhr.onload = function(){
			var myBL = JSON.parse(xhr.responseText);
			showTab1(myBL);
		} 
		xhr.send(null);
        }
      }
	  function showTab1(tab1){
		  var bookListString = "";
		  for(var i = 0; i<4; ++i){
			 
			  var record = tab1[i];
			  var bookimage ="http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/bookimg?id=" + record.Id;
			  
			  bookListString += "<div class = image><img src=" + bookimage +"></div>"; 
		  }
		 document.getElementById("SectionA1").innerHTML = bookListString;
	  }
	  
      function openTab2() {
         if (currentTab != "tab2") {
            currentTab = "tab2";
            showNoTabs();
			document.getElementById("x").style.display = "block";
			document.getElementById("SectionB").style.display = "block";

			var xhr = new XMLHttpRequest();
			var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/booklist";
			xhr.open("GET", uri, true);
			xhr.setRequestHeader("Accept", "application/json");
			xhr.onload = function(){
			var myBL = JSON.parse(xhr.responseText);
			showTab2(myBL);
		} 
		xhr.send(null);
        }
      }
	  function showTab2(tab2){
		  var bookListString = "";
		  for(var i = 0; i<tab2.length; ++i){
			  var record = tab2[i];
			  var bookimage ="http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/bookimg?id=" + record.Id;
			  
			  bookListString += "<div class = image><img src=" + bookimage +"></div>"+ "<div class = 'booktitle'>" + record.Title+"</div><div class = 'authorI'>" + record.AuthorInitials+ " "+ record.AuthorSurname+"</div><div><button id = 'buy' onclick = 'lg(\"" +record.Id + "\")'>Purchase</button></div>"; 
		  }
		 document.getElementById("SectionB").innerHTML = bookListString;
	  }
	  
	  function lg(c){
		window.open("http://redsox.uoa.auckland.ac.nz/BC/Closed/Service.svc/bookbuy?id=" + c );
	  }

      function openTab3() {
         if (currentTab != "tab3") {
            currentTab = "tab3";
            showNoTabs();  
			document.getElementById("y").style.display = "block";
            document.getElementById("SectionC").style.display = "block";
		
			var xhr = new XMLHttpRequest();
			var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/brlist";
			xhr.open("GET", uri, true);
			xhr.setRequestHeader("Accept", "application/json");
			xhr.onload = function(){
			var myBR = JSON.parse(xhr.responseText);
			showTab3(myBR);
			
		} 
		xhr.send(null);
        }
      }
	  function showTab3(tab3){
		  var bluListString = "";
		  for(var i = 0; i<tab3.length; ++i){
			  var record = tab3[i];
			  var bluimage ="http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/brimg?id=" + record.Id;
			  bluListString += "<div class = 'box'><div><img src=" + bluimage +"></div>"+ "<div class = 'blutitle'>" + record.Title+"</div></div><div><button id = 'buy1' onclick = 'lg1(\"" +record.Id + "\")'>Purchase</button></div>"; 
		  }
		 document.getElementById("SectionC").innerHTML = bluListString;
	  } 
	  
	  function lg1(c1){
		window.open("http://redsox.uoa.auckland.ac.nz/BC/Closed/Service.svc/brbuy?id=" + c1 );  
	  }

	  function openTab4() {
         if (currentTab != "tab4") {
            currentTab = "tab4";
            showNoTabs();  
            document.getElementById("SectionD").style.display = "block";	
		 }
      }
	  function gettingP(){
			var xhr = new XMLHttpRequest();
			var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/comment?name=" + document.getElementById('inputn').value;
			
			xhr.open("POST", uri, true);
			xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
			xhr.send(JSON.stringify(document.getElementById('inputc').value));
			setTimeout(function() {gettingC();}, 100);
	  }

	  function gettingC(){
		var xhr = new XMLHttpRequest();
		var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/htmlcomments";
		xhr.open("GET", uri, true);
		xhr.setRequestHeader("Accept", "application/json");
		xhr.onload = function(){
			var res = xhr.responseText;
			document.getElementById("commenting").innerHTML = res;
	  }
	  xhr.send(null);
	  }window.onload = gettingC();
	  
	  function openTab5() {
         if (currentTab != "tab5") {
            currentTab = "tab5";
            showNoTabs();  
            document.getElementById("SectionE").style.display = "block";
				
         }
      }
	  function gettingR(){
		  var xhr = new XMLHttpRequest();
		  var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/register";
		  xhr.open("POST", uri, true);
		  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		  xhr.onload = function(){
			  document.getElementById("rmsg").innerHTML = xhr.responseText;
		  } 
		  xhr.send(JSON.stringify({"Address": document.getElementById("inputa").value,"Name": document.getElementById("inputu").value,"Password": document.getElementById("inputp").value}));
	  }
	  
	function blSearch(){
	var xhr = new XMLHttpRequest();
	var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/booksearch?term=" + document.getElementById("x").value;
	xhr.open("GET", uri, true);
	xhr.setRequestHeader("Accept", "application/json");
			xhr.onload = function(){
			var mySearch = showTab2(JSON.parse(xhr.responseText));
		  } 
		xhr.send(null); 
		
	}
	function brSearch(){
	var xhr = new XMLHttpRequest();
	var uri = "http://redsox.uoa.auckland.ac.nz/BC/Open/Service.svc/brsearch?term=" + document.getElementById("y").value;
	xhr.open("GET", uri, true);
	xhr.setRequestHeader("Accept", "application/json");
			xhr.onload = function(){
			var mySearch = showTab3(JSON.parse(xhr.responseText));
		  } 
		xhr.send(null); 
		
	}	
	  
      function showNoTabs() {
         document.getElementById("tab1").style.backgroundColor = "transparent";
         document.getElementById("tab2").style.backgroundColor = "transparent";
         document.getElementById("tab3").style.backgroundColor = "transparent";
		 document.getElementById("tab4").style.backgroundColor = "transparent";
		 document.getElementById("tab5").style.backgroundColor = "transparent";
		
         document.getElementById("SectionA").style.display = "none";
         document.getElementById("SectionB").style.display = "none";
         document.getElementById("SectionC").style.display = "none";
		 document.getElementById("SectionD").style.display = "none";
		 document.getElementById("SectionE").style.display = "none";
		 document.getElementById("x").style.display = "none";
		 document.getElementById("y").style.display = "none";
      }

      window.onload = function () {
         openTab1();
      }
	function mouseOver() {
    document.getElementById("tab1").style.backgroundColor = "#076AF9";
}
	function mouseOut() {
    document.getElementById("tab1").style.backgroundColor = "black";
}
function mouseOver1() {
    document.getElementById("tab2").style.backgroundColor = "#076AF9";
}
	function mouseOut1() {
    document.getElementById("tab2").style.backgroundColor = "black";
}
function mouseOver2() {
    document.getElementById("tab3").style.backgroundColor = "#076AF9";
}
	function mouseOut2() {
    document.getElementById("tab3").style.backgroundColor = "black";
}
function mouseOver3() {
    document.getElementById("tab4").style.backgroundColor = "#076AF9";
}
	function mouseOut3() {
    document.getElementById("tab4").style.backgroundColor = "black";
}
function mouseOver4() {
    document.getElementById("tab5").style.backgroundColor = "#076AF9";
}
	function mouseOut4() {
    document.getElementById("tab5").style.backgroundColor = "black";
}
