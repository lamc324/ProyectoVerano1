create database Consulturio;

use Consulturio;

CREATE TABLE Paciente (
    id NOT NULL VARCHAR(16),
    nombre NOT NULL VARCHAR(25),
    telefono VARCHAR(16),
    direccion VARCHAR(40),
    fechaNaciemiento NOT NULL VARCHAR(15),
    enfermedades VARCHAR(60),
    observaciones VARCHAR(60),
    PRIMARY KEY (id)
);

CREATE TABLE Consultorio {
	nombre NOT NULL VARCHAR(30),
	horarioAtencion NOT NULL VARCHAR(30),
	telefono VARCHAR(15),
	PRIMARY KEY (nombre)
}

CREATE TABLE Cita (
    idPaciente VARCHAR(16),
    consulturio VARCHAR(30),
    fecha VARCHAR(16),
    confirmado BOOLEAN,
    PRIMARY KEY (idPaciente)
);

ALTER TABLE Cita ADD Foreign Key (idPaciente) REFERENCES Paciente(id);

insert into Paciente(id, nombre, telefono, direccion, fechaNaciemiento, enfermedades, observaciones) values("111","kevin","6546","cdsdsd","321312","vc vcdx ", "skadf");

SELECT 
    *
FROM
    Cita;