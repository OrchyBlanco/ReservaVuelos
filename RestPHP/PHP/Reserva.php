<?php
  $server="localhost";
  $user="2dawa";
  $pass = "2dawA2!06";
  $bd = "ReservaVuelos";

  //Creamos la conexión
  $conexion = mysqli_connect($server, $user, $pass,$bd) or die("Ha sucedido un error inexperado en la conexion de la base de datos");

  //Recogemos Parametros
  $cad=json_decode(stripcslashes($_REQUEST['param']));


$sql = "insert into reservas (reservas_id, vuelo_id, nombre, apellidos, telefono, tarjeta,importe) VALUES (NULL,'".$cad->vueloid."',".$cad->nombre.",'".$cad->apellidos."','".$cad->telefono."','".$cad->tarjeta."','".$cad->importe."')";

mysqli_query($conexion,$sql) or die("Problemas con el select".mysqli_error($conexion));

if(!$result = mysqli_query($conexion, $sql)) die();
while($row = mysqli_fetch_array($result))
{
 $vuelo[] = $row;
}

//desconectamos la base de datos
mysqli_close($conexion) or die("Ha sucedido un error inesperado en la desconexion de la base de datos");

//Creamos el JSON
$cad = json_encode($vuelo);
echo $cad;

 ?>
