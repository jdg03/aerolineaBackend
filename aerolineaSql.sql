CREATE DATABASE IF NOT EXISTS  aerolinea;
USE aerolinea;

CREATE TABLE paises (
  id_pais INT AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id_pais)
);

INSERT INTO paises (nombre) VALUES ('Honduras'), ('Estados Unidos');

select * from paises;

CREATE TABLE ciudades (
  id_ciudad INT AUTO_INCREMENT,
  id_pais INT NOT NULL,
  nombre VARCHAR(45)  NOT NULL,
  PRIMARY KEY (id_ciudad),
  FOREIGN KEY (id_pais) REFERENCES paises (id_pais)
);

INSERT INTO ciudades (id_pais, nombre) 
VALUES 
    (1, 'Tegucigalpa'),
    (2, 'Miami');

select * from ciudades;

CREATE TABLE aeropuertos (
  id_aeropuerto INT AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  id_ciudad INT NOT NULL,
  PRIMARY KEY (id_aeropuerto),
  FOREIGN KEY (id_ciudad) REFERENCES ciudades (id_ciudad)
);

INSERT INTO aeropuertos (nombre, id_ciudad) 
VALUES 
    ('Aeropuerto Internacional de Toncontín', 1),
    ('Aeropuerto Internacional de Miami', 2);

select * from aeropuertos;

CREATE TABLE destinos (
  id_destino INT AUTO_INCREMENT,
  id_ciudad_origen INT NOT NULL,
  id_ciudad_destino INT NOT NULL,
  distancia INT NOT NULL,
  PRIMARY KEY (id_destino),
  FOREIGN KEY (id_ciudad_destino) REFERENCES ciudades (id_ciudad),
  FOREIGN KEY (id_ciudad_origen) REFERENCES ciudades (id_ciudad)
);

INSERT INTO destinos (id_ciudad_origen, id_ciudad_destino, distancia) 
VALUES 
    (1, 2, 1500), -- De Tegucigalpa a Miami
    (2, 1, 1500); -- De Miami a Tegucigalpa

select * from destinos;

CREATE TABLE aviones (
  id_avion INT AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  modelo VARCHAR(45) NULL,
  capacidad INT NOT NULL,
  fabricante VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_avion)
);

INSERT INTO aviones (nombre, modelo, capacidad, fabricante) 
VALUES 
    ('Boeing 737', '737-800', 90, 'Boeing'),
    ('Airbus A320', 'A320-200', 100, 'Airbus');
    
select * from aviones;

CREATE TABLE vuelos (
  id_vuelo INT AUTO_INCREMENT,
  id_avion INT NOT NULL,
  id_destino INT NOT NULL,
  fecha_salida DATE NOT NULL,
  fecha_llegada DATE NOT NULL,
  estado VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_vuelo),
  FOREIGN KEY (id_avion) REFERENCES aviones (id_avion),
  FOREIGN KEY (id_destino) REFERENCES destinos (id_destino)
);

INSERT INTO vuelos (id_avion, id_destino, fecha_salida, fecha_llegada, estado) 
VALUES 
    (1, 1, '2024-04-20', '2024-04-20', 'Programado'), -- Un vuelo de Tegucigalpa a Miami programado para el 20 de abril de 2024
    (2, 2, '2024-04-22', '2024-04-22', 'Programado'); -- Un vuelo de Miami a Tegucigalpa programado para el 22 de abril de 2024

select * from vuelos;

CREATE TABLE clases (
  id_clase INT AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  precio INT NOt NULL,
  PRIMARY KEY (id_clase)
);

INSERT INTO clases (nombre, precio) 
VALUES 
    ('Primera Clase', 500),
    ('Premium', 300), 
    ('Básico', 150);

select * from clases;

CREATE TABLE asientos (
  id_asiento INT AUTO_INCREMENT,
  id_avion INT NOT NULL,
  numero_asiento INT NOT NULL,
  id_clase INT NOT NULL,
  estado BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id_asiento),
  FOREIGN KEY (id_avion) REFERENCES aviones (id_avion),
  FOREIGN KEY (id_clase) REFERENCES clases (id_clase)
);

-- primera clase
INSERT INTO asientos (id_avion, numero_asiento, id_clase) 
VALUES 
    (1, 1, 1), -- Asiento 1 de primera clase
    (1, 2, 1), -- Asiento 2 de primera clase
    (1, 3, 1); -- Asiento 3 de primera clase
  
 -- primera clase del avion 2 
INSERT INTO asientos (id_avion, numero_asiento, id_clase) 
VALUES 
    (2, 1, 1), -- Asiento 1 de primera clase
    (2, 2, 1), -- Asiento 2 de primera clase
    (2, 3, 1); -- Asiento 3 de primera clase

-- Premium
INSERT INTO asientos (id_avion, numero_asiento, id_clase) 
VALUES 
    (1, 4, 2), -- Asiento 1 de premium
    (1, 5, 2), -- Asiento 2 de premium
    (1, 6, 2); -- Asiento 3 de premium

-- Básico
INSERT INTO asientos (id_avion, numero_asiento, id_clase) 
VALUES 
    (1, 7, 3), -- Asiento 1 de básico
    (1, 8, 3), -- Asiento 2 de básico
    (1, 9, 3); -- Asiento 3 de básico
    
    
select * from asientos;

CREATE TABLE clientes (
  id_cliente INT AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  correo VARCHAR(45) NOT NULL,
  direccion VARCHAR(45) NOT NULL,
  nacionalidad  VARCHAR(45) NOT NULL,
  pasaporte  VARCHAR(45) NOT NULL,
  cliente_registrado BOOLEAN DEFAULT FALSE, 
  PRIMARY KEY (id_cliente)
);

CREATE TABLE boletos (
  id_boleto INT AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  id_vuelo INT NOT NULL,
  id_asiento INT NOT NULL,
  fecha DATE NOT NULL,
  precio_total DOUBLE NOT NULL,
  PRIMARY KEY (id_boleto),
  FOREIGN KEY (id_vuelo) REFERENCES vuelos (id_vuelo),
  FOREIGN KEY (id_asiento) REFERENCES asientos (id_asiento),
  FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);

CREATE TABLE ventas (
  id_venta INT AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE NULL,
  total DOUBLE NOT NULL,
  descuento DOUBLE NOT NULL,
  impuesto  DOUBLE NOT NULL,
  sub_total DOUBLE NOT NULL,
  PRIMARY KEY (id_venta),
  FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);

CREATE TABLE medio_venta (
  id_medio_venta INT AUTO_INCREMENT,
  descripcion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_medio_venta)
);

CREATE TABLE detalle_ventas (
  id_detalle_venta INT AUTO_INCREMENT,
  id_venta INT NOT NULL,
  id_boleto INT NOT NULL,
  cantidad_boletos INT NULL,
  id_medio_venta INT NOT NULL,
  PRIMARY KEY (id_detalle_venta),
  FOREIGN KEY (id_venta) REFERENCES ventas (id_venta),
  FOREIGN KEY (id_medio_venta) REFERENCES medio_venta (id_medio_venta),
  FOREIGN KEY (id_boleto) REFERENCES boletos (id_boleto)
);



