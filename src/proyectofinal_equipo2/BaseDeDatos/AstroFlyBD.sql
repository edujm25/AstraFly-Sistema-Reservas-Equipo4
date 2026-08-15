create database AstraFly;
USE AstraFly;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Usuario VARCHAR(50) NOT NULL UNIQUE,
    nombre_apellido VARCHAR(100) NOT NULL UNIQUE,
    documento_cedula_pasaporte INT (15) NOT NULL UNIQUE, 
    correo VARCHAR (100) NOT NULL UNIQUE,
    numero_telefonico INT (11) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    
    UNIQUE KEY uq_email (correo),
    UNIQUE KEY uq_usuario (nombre_Usuario)
);

CREATE TABLE Vuelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_vuelo VARCHAR(10) NOT NULL,
    aerolinea VARCHAR(50) NOT NULL,
    origen VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE VueloReservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    vuelo_id INT NOT NULL,
    codigo_reserva VARCHAR(10) NOT NULL,
    nombre_pasajero VARCHAR(100) NOT NULL,
    asiento VARCHAR(5),
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('confirmada', 'cancelada', 'pendiente') DEFAULT 'pendiente',
    precio_pagado DECIMAL(10,2) NOT NULL,
    
    UNIQUE KEY uq_codigo_reserva (codigo_reserva),
    
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (vuelo_id) REFERENCES vuelos(id) ON DELETE CASCADE
);

