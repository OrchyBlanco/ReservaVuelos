create database if not exists ReservaVuelos;
use ReservaVuelos;
drop table if exists vuelo;
create table if not exists vuelo
(
vuelo_id int not null auto_increment,
plazasLibres int unsigned not null,
fecha datetime not null unique,
nVuelo int not null unique,
PRIMARY KEY (vuelo_id),
UNIQUE KEY(fecha, nVuelo)
);

drop table if exists reservas;
create table if not exists reservas
(
reservas_id INT auto_increment,
vuelo_id INT not null,
nombre varchar(200) not null,
apellidos varchar(200) not null,
telefono char(9) not null,
tarjeta char(16) not null,
importe double not null,
PRIMARY KEY (reservas_id),
UNIQUE KEY (vuelo_id, tarjeta)
);

drop table if exists vueloGenerico;
create table if not exists vueloGenerico
(
nVuelo int not null auto_increment,
horaSalida int,
horaLlegada int,
precio double not null,
capacidad int not null,
ordenAsiento varchar(150) not null,
aeropuerto_id int not null,
aerolinea_id int,
PRIMARY KEY (nVuelo),
UNIQUE KEY (nVuelo)
);
 
drop table if exists aeropuerto;
create table if not exists aeropuerto
(
aeropuerto_id int not null auto_increment,
codigo varchar(100) not null unique,
nombre varchar(200) not null,
categoria int not null,
id_ciudad int not null,
PRIMARY KEY (aeropuerto_id),
UNIQUE KEY (codigo)
);

drop table if exists ciudad;
create table if not exists ciudad
(
id_ciudad int not null auto_increment,
nombre varchar(200) not null,
pais varchar(200) not null,
PRIMARY KEY (id_ciudad)
);

drop table if exists aerolinea;
create table if not exists aerolinea
(
aerolinea_id int not null,
codigo varchar(100) not null,
nombre varchar(200) not null,
PRIMARY KEY (aerolinea_id),
UNIQUE KEY (codigo)
);



alter table reservas add constraint fk_vuelo_id foreign key (vuelo_id) references vuelo(vuelo_id);
alter table vuelo add constraint fk_vuelogenerico_id foreign key(nVuelo) references vueloGenerico(nVuelo);
alter table aeropuerto add constraint fk_aeropuerto_ciudad_id foreign key(id_ciudad) references ciudad(id_ciudad);
alter table vueloGenerico add constraint fk_aerolinea_vueloGenerico foreign key(aerolinea_id) references aerolinea(aerolinea_id);
alter table vueloGenerico add constraint fk_aeropuerto_vueloGenerico foreign key(aeropuerto_id) references aeropuerto(aeropuerto_id);          

alter table vueloGenerico add constraint chk_horaSalida check(horaSalida<24 & horaSalida>0);
alter table vueloGenerico add constraint chk_horaLlegada check(horaLlegada<24 & horaLlegada>0);
