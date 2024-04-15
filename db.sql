CREATE DATABASE IF NOT EXISTS  aerolinea;
USE aerolinea;

--check
CREATE TABLE paises (
  id_pais INT AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id_pais)
);
--check
CREATE TABLE ciudades (
  id_ciudad INT AUTO_INCREMENT,
  id_pais INT NOT NULL,
  nombre VARCHAR(45)  NOT NULL,
  PRIMARY KEY (id_ciudad),
  FOREIGN KEY (id_pais) REFERENCES paises (id_pais)
);
--check
CREATE TABLE aeropuertos (
  id_aeropuerto INT AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  id_ciudad INT NOT NULL,
  PRIMARY KEY (id_aeropuerto),
  FOREIGN KEY (id_ciudad) REFERENCES ciudades (id_ciudad)
);

--check
CREATE TABLE destinos (
  id_destino INT AUTO_INCREMENT,
  id_ciudad_origen INT NOT NULL,
  id_ciudad_destino INT NOT NULL,
  distancia INT NOT NULL,
  PRIMARY KEY (id_destino),
  FOREIGN KEY (id_ciudad_destino) REFERENCES ciudades (id_ciudad),
  FOREIGN KEY (id_ciudad_origen) REFERENCES ciudades (id_ciudad)
);
--check
CREATE TABLE aviones (
  id_avion INT AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  modelo VARCHAR(45) NULL,
  capacidad INT NOT NULL,
  marca VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_avion)
);
-- check
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
-- check
CREATE TABLE clases (
  id_clase INT AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  precio INT NOt NULL,
  PRIMARY KEY (id_clase)
);
-- check
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
--check
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
--check
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
--check
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
--check
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