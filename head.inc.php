<?php

function createHeader($title, $scripts = array()) {
	echo
'<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>'.$title.'</title>
		<link rel="stylesheet" href="style.css" />';
	
	foreach($scripts as $s) {
		echo '<script type="text/javascript" src="'.$s.'" ></script>';
	}
	
	echo 
'	
	</head>
	<body>
		<div id="header"><h1>'.$title.'</h1></div>';
}