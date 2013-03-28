<div id="footer">
	<div id="foot-left">
		<p><?php $uri = urlencode("http" . ((isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] == "on") ? "s" : "" ) . "://" . $_SERVER["HTTP_HOST"] . $_SERVER["REQUEST_URI"]); ?>
      <a href="http://validator.w3.org/check?uri=<?php echo $uri; ?>"><img
          src="img/valid-xhtml10-blue.png"
          alt="Valid XHTML 1.0!" height="31" width="88" /></a>
	  <a href="http://jigsaw.w3.org/css-validator/validator?uri=<?php echo $uri; ?>">
        <img style="border:0;width:88px;height:31px"
            src="img/vcss-blue.gif"
            alt="Valid CSS!" />
    </a>
    </p>
	</div>
	<div id="foot-right">
		<p>Developed by: X Bao, D Sturrock, D Thomson and S Walker</p>
	</div>
</div>
</body>
</html>