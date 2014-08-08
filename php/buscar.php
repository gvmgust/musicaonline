<?php
	$dbHost = "localhost";
	$dbUser = "root";
	$dbPass = "";
	$dbName = "musica";
	$mysqli = mysqli_connect($dbHost,$dbUser,$dbPass, $dbName);	
	include("dir.php");
	if($mysqli->connect_errno)
		echo "No se pudo establecer la conexion MySQL: ".$mysql->connect_errno;
	
	$consulta = "SELECT * FROM cancion WHERE tit like '%".$_GET['lista']."%' ORDER BY tit;";
	$resultado = $mysqli->query($consulta);
	if($resultado){
		@header("Content-type:txt/xml");		
		@header('Content-Disposition: attachment; filename= lista.xml');
		echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		echo "<songs>\n";
		while($fila = $resultado->fetch_assoc()){
			echo "<song \n";
			echo "\tpath=\"".$musicas.$fila['dir']."/".$fila['tit']."\"\n";
			echo "\ttitle=\"".$fila['tit']."\"\n/>\n";
		}
		echo "</songs>";
	}
	$mysqli->close();
?>