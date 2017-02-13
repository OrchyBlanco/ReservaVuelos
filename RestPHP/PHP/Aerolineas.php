<?php

$server = "localhost";
$user = "2dawa";
$pass = "2dawA2!06";
$bd = "ReservaVuelos";

//Creamos la conexión
$conexion = mysqli_connect($server, $user, $pass,$bd) or die("Ha sucedido un error inexperado en la conexion de la base de datos");

//generamos la consulta
$sql = "SELECT * FROM aerolinea";

if(!$result = mysqli_query($conexion, $sql)) die();


while($row = mysqli_fetch_array($result))
{
 $aerolinea[] = $row;

}

//desconectamos la base de datos
mysqli_close($conexion) or die("Ha sucedido un error inesperado en la desconexion de la base de datos");


//Creamos el JSON
$cad = json_encode($aerolinea);
echo $cad;


?>
