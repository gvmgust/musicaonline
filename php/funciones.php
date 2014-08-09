<?php		
	function dameURL(){
		return "http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
	}
	function botonesArtistas(){		
		$mysqli = mysqli_connect('localhost','root','','musica');
		if($mysqli->connect_errno)
			echo "No se pudo establecer la conexion MySQL: ".$mysql->connect_errno;
		else{
			$consulta = "SELECT dir FROM cancion GROUP BY dir ORDER BY dir ASC";
			$resultado = $mysqli->query($consulta);
			if($resultado){
				$ant = "";
				$fin = "";
				$cont = 0;
				$k = 0;
				echo "<table><tr>";	
				while($fila = $resultado->fetch_assoc()){
					if($cont ==0){
						$ant = $fila['dir'];
					}
					$fin = $fila['dir'];
					if($cont == 20){
						if($k==8){
							echo "</tr>";
							echo "<tr>";
							$k = 0;
						}
						
						echo "<td>\n";
						echo "<div id='sobreponer'><img src='base.jpg' width='35'  height='17'/>\n";
						echo "\t<label class='letra'>".strtoupper(substr($ant,0,1)."-".substr($fin,0,1))."</label>\n";
						echo "\t<a href='index.php?i=".$ant."&f=".$fin."' target='_self'>\n";
						echo "\t<img class='sobre' src='mascara.png' width='35' height='17'/></a>\n";							
						echo "</div></td>\n";	
						$cont = -1;
						$k++;
					}
					$cont++;
				}	
						if($k==8){
							echo "</tr>";
							echo "<tr>";
							$k = 0;
						}				
				echo "<td><div id='sobreponer'><img src='base.jpg' width='35'  height='17'/>\n";
				echo "\t<label class='letra'>".strtoupper(substr($ant,0,1)."-".substr($fin,0,1))."</label>\n";
				echo "\t<a href='index.php?i=".$ant."&f=".$fin."' target='_self'>\n";
				echo "\t<img class='sobre' src='mascara.png' width='35' height='17'/></a>\n";							
				echo "</div></td>\n";
				echo "</tr></table>";
			}		
			$mysqli->close();
		}
	}
	
	function mostrarArtistas($consulta){
		$mysqli = mysqli_connect('localhost','root','','musica');
		$resultado = $mysqli->query($consulta);
		if($resultado){
			echo "<table>";
			while($fila = $resultado->fetch_assoc()){
				echo "<tr><td><div id='sobreponer'><img src='fm.png' width='300'  height='16'/>\n";
				echo "\t<label class='letra'>".strtoupper($fila['dir'].' ['.$fila['cant'].']')."</label>\n";
				echo "\t<a href='index.php?play=".$fila['dir']."'target='_self'>\n";
				echo "\t<img class='sobre' src='mascara.png' width='300' height='16'/></a>\n";							
				echo "</div></td></tr>\n";
			}
			echo "</table>";
			echo '<table><td valing = "buttom"><form method="post" action="index.php">
    	Buscar Tema: <input type="text" name="q" value=""/>
        <input type="submit" name="submit" value="<Buscar>"/> </form></td></table>';
		}
		$mysqli->close();
	}
?>