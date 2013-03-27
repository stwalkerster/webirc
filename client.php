<?php include("head.inc.php"); createHeader("IRC Client");

	$host = $_POST['server'];
	$port = 6667;
	$nick = $_POST['nick'];
	$user = $_POST['user'];
	$password = $_POST['password'];
	
	// Params retreived in the applet by: String hostname = getParameter("hostname");
	
?>
<div id="content">
	<div id="applet">
		<object type="application/x-java-applet" name="irc" width="800" height="600">
			<param name="codebase" value="java/bin" />
			<param name="code" value="Client.class" />
			<param name="scriptable" value="true" />
			<param name="mayscript" value="true" />
			<param name="host" value="<?php echo $host; ?>" />
			<param name="port" value="<?php echo $port; ?>" />
			<param name="nick" value="<?php echo $nick; ?>" />
			<param name="user" value="<?php echo $user; ?>" />
			<param name="password" value="<?php echo $password; ?>" />
		</object>
	</div>
</div>
<?php include("foot.inc.php");?>