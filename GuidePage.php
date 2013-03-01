<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Guide</title>
<link rel="stylesheet" href="style.css" />

<style type="text/css">

.container {
	position: absolute;
	color: #FFF;
	margin: 0em 0em 0em 10em;
}

</style>

</head>
<body>
<script type="text/javascript" >
function showDiffLayer(int){
	if(int == 1){
		introLayer.style.visibility = "visible";
		loginLayer.style.visibility = "hidden";
		mainLayer.style.visibility = "hidden";
		cpLayer.style.visibility = "hidden";
	}
	else if(int == 2){
		introLayer.style.visibility = "hidden";
		loginLayer.style.visibility = "visible";
		mainLayer.style.visibility = "hidden";
		cpLayer.style.visibility = "hidden";
	}
	else if(int == 3){
		introLayer.style.visibility = "hidden";
		loginLayer.style.visibility = "hidden";
		mainLayer.style.visibility = "visible";
		cpLayer.style.visibility = "hidden";
	}
}

function mainPage(){
	location.href="overview.php";
}
</script>

<div id="header"><h1>IRC Client</h1>
</div>

<h1 style="color:white;
	margin: 0em 0em 0em 20em;">Guide Page</h1>

<div class ="navigator">

<table style="margin: 0em 0em 0em 35em;">
	<tr>
    	<td>
        	<button type="submit" id="b1" onclick="showDiffLayer(1)">Introduction</button>
        </td>
		<td>
  			<button type="submit" id="b2" onclick="showDiffLayer(2)">Login</button>
  		</td>
  		<td>
  			<button type="submit" id="b3" onclick="showDiffLayer(3)">Mainpage</button>
  		</td>
  		<td>
  			<button type="submit" id="b4" onclick="mainPage()">Home</button>
  		</td>
	</tr>
</table>

</div>

<div class ="container"  id="introLayer" style=" visibility:visible;"> 
<p>Welcome to the chat forum. You can select the above buttons to view the guide information for each part of the website.</p>
<p>If you want to return to the overview page, please click the "Home" button.</p>
</div>

<div class ="container"  id="loginLayer" style=" visibility:hidden;">
<p>The Login page contains several forms to be filled in. </p>
<p>"Nickname" is the name of the IRC server. </p>
<p>User can use the dropdown list to select server. If the "other" option is chosen, then user need to fill in the corresponding "Host" and "Port" to connect to that server. </p>
<p>For security issues, some channels may require the autentication. User need to click the "Auth" checkbox and then insert their username and password to login.</p> 
</div>

<div class ="container" id="mainLayer" style=" visibility:hidden;">
<p>The main page has been divided into 3 panels.</p>
<p>The panel on the left shows the current channels which user is in.</p> 
<p>The panel in the center shows the sent messages from all users in the selected channels. User can find the details of the current topic in selected channels at the top of the center panel and send their own message by using the dialgue box at the bottom of the center panel.</p>
<p>The panel on the right lists all the users who are currently available.</p>
</div>

<?php /*include common footer*/ include("foot.inc.php");?>
