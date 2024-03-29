//form.js
//@author David Sturrock
//@version 1.0
//
//Description: A javascript file, called by the php/html form used to login and start the IRC chat client. The code makes sure that 
//required fields are entered and use valid data.




//formValidation: Called when the form is submitted, checks each field and only submits the data if all field validation calls respond with true
function formValidation(){
	if(!validNickname()){
		alert("Please enter a valid nickname");
		return false;
	}
	else if(!validServer()){
		alert("A server must be selected to proceed");
		return false;
	}
	else if(!validPort()){
		alert("Please enter a valid port number");	
		return false;}
	else {return true;}
}

//validNickname: Checks the Nickname field from the XHTML form and ensures it hasn't been left blank as it is a required field
function validNickname(){
	var nick = document.getElementById("nickname");
	if (nick.value==""){
		return false;
	}
	else{
		return true;
	}
}

//validServer: Checks the Server field from the XHTML form and ensures it hasn't been left blank as it is a required field
function validServer(){
	var server = document.getElementById("serverselect");
	if (server.value==""){
		return false;
	}
	else{
		return true;
	}
}
//validPort: The Port field should only contain numbers
function validPort(){

	var regexp =" /[0-9]{1,5}?/";
	var port = document.getElementById("port");
	if(port.value!=""){
		if(port.value.match(regexp)==null){
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}
//checkOther: Javascript to add extra form fields when certain criteria are met
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
//checkOther: Javascript to add username/password fields if the user indicates a need to authenticate themself
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
