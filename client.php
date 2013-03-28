<?php include("head.inc.php"); createHeader("IRC Client");

	// Server side input validation
	// If server, port or nick is not provided, go back to the index page
	// Author: Dean Thomson
	
	if(isset($_POST['server'])) { $host = $_POST['server']; }
		else { header("Location: index.php"); }
	if(isset($_POST['port'])) { $post = $_POST['port']; }
		else { header("Location: index.php"); }
	if(isset($_POST['nick'])) { $nick = $_POST['nick']; }
		else { header("Location: index.php"); }
	
	// If these variables are not set, set them to an empty string.
	$user = isset($_POST['user']) ? $_POST['user'] : "";
	$password = isset($_POST['password']) ? $_POST['password'] : "";
	
?>
<div id="content">
	<div id="applet">
		<object type="application/x-java-applet" name="irc" width="800" height="600">
			<param name="archive" value="client.jar?mtime=<?php echo filemtime("client.jar"); ?>" />
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