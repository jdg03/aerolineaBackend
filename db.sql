drop database aerolinea;
create database aerolinea;
use aerolinea;

create table aeropuertos(
    id_aeropuerto int primary key auto_increment,
    codigo_iata varchar(5),
    nombre varchar(50),
    pais varchar(50)
);

create table clientes(
    id_cliente int primary key auto_increment,
    nombre varchar(50)
);

create table aviones(
    id_avion int primary key auto_increment,
    marca varchar(20),
    asientos_primera_clase int,
    asientos_premium int,
    asientos_basico int
);

create table vuelos(
    id_vuelo int primary key auto_increment,
    salida int,
    llegada int,
    fecha_salida date,
    numero_vuelo varchar(10),
    avion int,
    foreign key(salida) references aeropuertos(id_aeropuerto),
    foreign key(llegada) references aeropuertos(id_aeropuerto),
    foreign key(avion) references aviones(id_avion)
);

SELECT * FROM aerolinea.vuelos;
select * from aeropuertos;
select * from aviones;
