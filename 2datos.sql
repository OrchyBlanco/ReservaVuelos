select * from reservas

insert into aerolinea values(1, "1111111", "Aerolinea1")
insert into aerolinea values(2, "2222222", "Aerolinea2")
insert into ciudad values(1, "ciudad1", "España")
insert into ciudad values(2, "ciudad2", "America")
insert into aeropuerto values(1,"codigo1", "aeropuerto1", 1, 1)
insert into aeropuerto values(2,"codigo2", "aeropuerto2", 2, 2)
insert into vueloGenerico (nVUelo, horaSalida, horaLlegada, aeropuerto_origen, aeropuerto_destino, precio, capacidad, ordenAsiento, aeropuerto_id, aerolinea_id) values (1, 10, 11, "Tenerife Norte", "Lanzarote", 100, 50, "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", 1, 1)
insert into vueloGenerico (nVUelo, horaSalida, horaLlegada, aeropuerto_origen, aeropuerto_destino, precio, capacidad, ordenAsiento, aeropuerto_id, aerolinea_id) values (2, 10, 11, "Tenerife Sur", "La Palma", 100, 50, "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", 2, 2)
insert into vuelo values(1, 50, "2014-01-30 12:00:00", 1)
insert into vuelo values(2, 50, "2017-02-06 11:00:00", 2)
insert into reservas (vuelo_id, nombre, apellidos, telefono, tarjeta, importe) values (1, "juan", "juanillo juanillo", 123456987, 1234567898741256, 20)
insert into reservas (vuelo_id, nombre, apellidos, telefono, tarjeta, importe) values (2, "pepe", "martin martinez", 123456457, 1234567858741256, 50)