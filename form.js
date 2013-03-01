function formValidation(){
	if(!validNickname()){
		alert("Please enter a valid nickname");
		return false;
	}
	else if(!validServer()){
		alert("A server must be selected to proceed");
		return false;
	}
	else if(!validPort()){return false;}
	else if(!validUsername()){return false;}
	else if(!validPassword()){return false;}
	else {return true;}
}

function validNickname(){
	var nick = document.getElementById("nickname");
	if (nick.value==""){
		return false;
	}
	else{
		return true;
	}
}
function validServer(){
	var server = document.getElementById("serverselect");
	if (server.value==""){
		return false;
	}
	else{
		return true;
	}
}
<!--Javascript to add extra form fields when certain criteria are met-->
function checkOther(){
	var selectBox = document.getElementById("serverselect");
	var selectedValue = selectBox.options[selectBox.selectedIndex].value;
	if(selectedValue=="other"){
		document.getElementById('hostname').style.display="block";
		document.getElementById('port').style.display="block";
		}
	else{
		document.getElementById('hostname').style.display="none";
		document.getElementById('port').style.display="none";
		}

}

function authenticate(){
	if(document.getElementById('auth').checked){
		document.getElementById("username").style.display="block";
		document.getElementById("password").style.display="block";
		}
	else
		{
		document.getElementById("username").style.display="none";
		document.getElementById("password").style.display="none";
		}
}
