<?php include("head.inc.php"); createHeader("IRC Client"); ?>
<div id="content"><div id="applet"><object type="application/x-java-applet"
    name="irc" width="800" height="600">
    <param name="codebase" value="java/bin" />
    <param name="code" value="Client.class" />
    <param name="scriptable" value="true" />
    <param name="mayscript" value="true" />
</object></div>
</div>
<?php include("foot.inc.php");?>