CREATE DATABASE IF NOT EXISTS AstraFly;
USE AstraFly;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Usuario VARCHAR(50) NOT NULL UNIQUE,
    nombre_apellido VARCHAR(100) NOT NULL UNIQUE,
    documento_cedula_pasaporte VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL UNIQUE,
    numero_telefonico VARCHAR(15) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,

    UNIQUE KEY uq_email (correo),
    UNIQUE KEY uq_usuario (nombre_Usuario)
);

INSERT INTO usuarios
    (nombre_Usuario, nombre_apellido, documento_cedula_pasaporte, correo, numero_telefonico, contrasena)
VALUES
    ('scruz', 'Shing Cruz', '40229300500', 'shing@gmail.com', '8091234567', 'claveSegura123');
    
    INSERT INTO usuarios
    (nombre_Usuario, nombre_apellido, documento_cedula_pasaporte, correo, numero_telefonico, contrasena)
VALUES
    ('ejimenez', 'Edwis Jimenez', '40235484635', 'edwis@gmail.com', '8091231536', 'clave123');


#############################################################################



CREATE TABLE Vuelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_vuelo VARCHAR(10) NOT NULL,
    aerolinea VARCHAR(50) NOT NULL,
    origen VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    estado ENUM('programado', 'retrasado', 'cancelado') DEFAULT 'programado',
    
    UNIQUE KEY uq_numero_fecha_hora (numero_vuelo, fecha_salida, hora_salida)
);


INSERT INTO Vuelos 
    (numero_vuelo, aerolinea, origen, destino, fecha_salida, hora_salida, precio, estado)
VALUES
    ('AV205', 'Avianca', 'Santo Domingo', 'Bogotá', '2026-09-10', '08:30:00', 15500.00, 'programado'),
    ('AA904', 'American Airlines', 'Santo Domingo', 'Miami', '2026-09-12', '06:15:00', 22000.00, 'programado'),
    ('CM478', 'Copa Airlines', 'Santo Domingo', 'Panamá', '2026-09-15', '14:00:00', 18300.00, 'programado');

############################################################################################################

CREATE TABLE VueloReservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    vuelo_id INT NOT NULL,
    codigo_reserva VARCHAR(10) NOT NULL,
    nombre_pasajero VARCHAR(100) NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('confirmada', 'cancelada', 'pendiente') DEFAULT 'pendiente',
    precio_pagado DECIMAL(10,2) NOT NULL,
    
    UNIQUE KEY uq_codigo_reserva (codigo_reserva),
    
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (vuelo_id) REFERENCES Vuelos(id) ON DELETE CASCADE
);

INSERT INTO VueloReservas
    (usuario_id, vuelo_id, codigo_reserva, nombre_pasajero, estado, precio_pagado)
VALUES
    (1, 1, 'RES001', 'Shing Cruz', 'confirmada', 15500.00),
    (1, 2, 'RES002', 'Shing Cruz', 'pendiente', 22000.00);










##########################################################################################
##SElECT

SELECT id, nombre_Usuario FROM usuarios;
SELECT id, numero_vuelo FROM Vuelos;

SELECT * FROM Vuelos;