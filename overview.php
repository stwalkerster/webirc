<?php include("head.inc.php"); createHeader("IRC Client - Project Overview	"); ?>
<div id="content">
<div id="contenttext">
<p>
	Our project is to build a web IRC client. This client is being implemented as a parameterised Java applet embedded within XHTML pages.
</p>
	<h2>Group Members</h2>
	<ul><li>Ximeng Bao</li><li>David Sturrock</li><li>Dean Thomson</li><li>Simon Walker</li></ul>
	
	<h2>Pages</h2>
	<ul>
		<li><a href="index.php">Login form</a> (David Sturrock) - Allows the user to provide the information required to connect to an IRC server and start chatting. This information is passed to the IRC client.</li>
		<li><a href="client.php">Client form</a> (Simon Walker) - Displays the Java applet which will be used as the IRC client.</li>
        <li><a href="GuidePage.php">Guide page</a> (Ximeng Bao) - Provide the user with information on using this application.</li>
	</ul>
	<h2>Other files</h2>
	<ul>
		<li><a href="style.css">Stylesheet</a></li>
		<li><a href="java/src/com/stwalkerster/apps/uni/webirc/Client.java">Client code</a></li>
	</ul>
	
	
</div>
</div>
<?php include("foot.inc.php");?>