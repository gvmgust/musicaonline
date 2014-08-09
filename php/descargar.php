<?php
	if($_GET["down"]<>""){
		$down = $_GET["down"];
		function downnei($down){
			$down = str_replace(" ","%20",$down);
			$down = str_replace("xlx",$codexxx,$down);
			return $down;
		}
		@header("Content-Type: audio/mpeg3");
		@@header('Content-Disposition: attachment; filename="'.$_GET["nombre"].' - [ElCallejon.CoM].mp3"');
		@readfile(downnei($down));
	}else{
		print "<script> location.href='http://elcallejon.com'; </script>";
	}
?>