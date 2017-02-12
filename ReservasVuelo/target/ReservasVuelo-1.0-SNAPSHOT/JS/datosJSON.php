<?php
    $datos[] = array(
            array('aerolineaId' => '1', 'codigo' => 'IBE', 'nombre'=>'Iberia'),
			array('aerolineaId' => '2', 'codigo' => 'AEU', 'nombre'=>'Air Europa'),
			array('aerolineaId' => '3', 'codigo' => 'SWN', 'nombre'=>'Smart Wings'),
			array('aerolineaId' => '4', 'codigo' => 'RYA', 'nombre'=>'Ryan Air'),
            );
header('Content-type: application/json');
echo json_encode($datos);