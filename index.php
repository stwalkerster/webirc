<?php include("head.inc.php"); createHeader("IRC Client", array("form.js")); ?>

<div id="content">
	<div id="formfloat">
		<!--Form to handle the login and authentication data to be passed to the IRC client-->
		<form id ="irclogin" action="client.php" method="post" onsubmit="return formValidation()">
			<p><label>Nickname</label><input id="nickname" name="nick" value="" type="text" onchange="validNickname()"/></p>
			<p><label>Server</label><select id="serverselect" name="server" onchange="checkOther()">
				<option value="">Please select a network:</option>
				<option value="chat.freenode.net">Freenode</option>
				<option value="other">Other</option>
				</select></p>
			<p id="hostname" style="display:none"><label>Host</label><input name="host" type="text" /></p>
			<p id="port" style="display:none"><label>Port</label><input name="port" type="text" /></p>
			<p><label>Auth</label><input id="auth" name="auth" type="checkbox" onclick="authenticate()"/></p>
			<p id="username" style="display:none"><label>Username</label><input name="user" type="text" onchange="validUsername()" /></p>
			<p id="password" style="display:none"><label>Password</label><input name="password" type="text" onchange="validPassword()" /></p>
			<input class="submit" type="submit" value="submit"/>
		</form>
	</div>
</div>
<?php include("foot.inc.php");?>
