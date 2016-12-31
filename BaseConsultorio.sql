create database Consulturio;

use Consulturio;

CREATE TABLE Paciente (
    id VARCHAR(16),
    nombre VARCHAR(25),
    telefono VARCHAR(16),
    direccion VARCHAR(40),
    fechaNaciemiento VARCHAR(15),
    enfermedades VARCHAR(60),
    PRIMARY KEY (id)
);

CREATE TABLE Cita (
    idPaciente VARCHAR(16),
    consulturio VARCHAR(30),
    fecha VARCHAR(16),
    confirmado BOOLEAN,
    PRIMARY KEY (idPaciente)
);

ALTER TABLE Cita ADD Foreign Key (idPaciente) REFERENCES Paciente(id);

insert into Paciente(id, nombre, telefono, direccion, fechaNaciemiento, enfermedades) values("111","kevin","6546","cdsdsd","321312","vc vcdx ");

SELECT 
    *
FROM
    Cita;