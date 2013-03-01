<?php include("head.inc.php"); createHeader("IRC Client - Project Overview	"); ?>
<div id="content">
<div id="contenttext">
<p>
	Our project is to build a web IRC client. This client is being implemented as a parameterised Java applet embedded within XHTML pages.
</p>
<p>
	The design is a web-based login form which then passes parameters into a Java Applet running on a different page. The IRC client itself will be implemented in the Java Applet. The login form has all the information required to connect to any IRC server and authenticate to network services if requested, using a specific account name and password (which could be different from the nickname the user has requested to use).
</p>
	<h2>Group Members</h2>
	<ul><li>Ximeng Bao</li><li>David Sturrock</li><li>Dean Thomson</li><li>Simon Walker</li></ul>
	
	<h2>Pages</h2>
	<ul>
		<li><a href="index.php">Login form</a></li>
		<li><a href="client.php">Client form</a></li>
        <li><a href="GuidePage.php">Guide page</a></li>
	</ul>
	<h2>Other files</h2>
	<ul>
		<li><a href="style.css">Stylesheet</a></li>
		<li><a href="java/src/Client.java">Client code</a></li>
		<li><a href="form.js">Validation javascript</a></li>
	</ul>
	
	
</div>
</div>
<?php include("foot.inc.php");?>