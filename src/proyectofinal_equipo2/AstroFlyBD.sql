create database AstraFly;
USE AstraFly;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    apellido VARCHAR(50) NOT NULL UNIQUE,
    documento_cedula_pasaporte INT (15) NOT NULL UNIQUE, 
    correo VARCHAR (100) NOT NULL UNIQUE,
    numero_telefonico INT (11) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);
DROP TABLE usuarios;
