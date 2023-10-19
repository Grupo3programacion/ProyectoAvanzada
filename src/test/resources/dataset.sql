-- Ejemplo 1
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (1, 'admin1@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Juan', 'Perez', '123-456-7890');

-- Ejemplo 2
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (2, 'admin2@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'María', 'López', '987-654-3210');

-- Ejemplo 3
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (3, 'admin3@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Pedro', 'Gómez', '555-555-5555');

-- Ejemplo 4
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (4, 'admin4@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Laura', 'Martínez', '333-333-3333');

-- Ejemplo 5
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (5, 'admin5@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Carlos', 'Rodríguez', '777-777-7777');

-- Ejemplo 6
INSERT INTO Administrador (id_Administrador, email_Administrador, contrasenia_Administrador, nombre_Administrador, apellido_Administrador, telefono_Administrador)
VALUES (6, 'admin6@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Sofía', 'García', '111-111-1111');


-- Ejemplo 1
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (1, 'medico1@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Carlos', 'González', '1', '1', '123-456-7890', 'foto1.jpg', '2023-10-15 14:00:00', true);

-- Ejemplo 2
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (2, 'medico2@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'María', 'López', '1', '1', '987-654-3210', 'foto2.jpg', '2023-10-16 10:30:00', true);

-- Ejemplo 3
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (3, 'medico3@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Pedro', 'Gómez', '1', '1', '555-555-5555', 'foto3.jpg', '2023-10-17 12:15:00', true);

-- Ejemplo 4
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (4, 'medico4@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Laura', 'Martínez', '1', '1', '333-333-3333', 'foto4.jpg', '2023-10-18 11:00:00', true);

-- Ejemplo 5
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (5, 'medico5@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Juan', 'Pérez', '1', '1', '777-777-7777', 'foto5.jpg', '2023-10-19 15:45:00', true);

-- Ejemplo 6
INSERT INTO Medico (id_Medico, email_Medico, contrasenia_Medico, nombre_Medico, apellido_Medico, ciudad_Medico, especilidad_Medico, telefono_Medico, foto_Medico, dia_Libre, estado)
VALUES (6, 'medico6@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Sofía', 'García', '1', '1', '111-111-1111', 'foto6.jpg', '2023-10-20 09:30:00', true);


-- Ejemplo 1
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (1, true, 'paciente1@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Juan', 'Pérez', '1990-01-15 14:00:00', 1234567, '1', '1', '1', 'foto1.jpg', '1');

-- Ejemplo 2
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (2, true, 'paciente2@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'María', 'López', '1985-05-20 10:30:00', 987654, '1', '1', '1', 'foto2.jpg', '1');

-- Ejemplo 3
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (3, true, 'paciente3@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Pedro', 'Gómez', '1995-03-10 12:15:00', 5555555, '1', '1', '1', 'foto3.jpg', '1');

-- Ejemplo 4
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (4, true, 'paciente4@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Laura', 'Martínez', '1988-12-05 11:00:00', 3333333, '1', '1', '1', 'foto4.jpg', '1');

-- Ejemplo 5
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (5, true, 'paciente5@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Carlos', 'Rodríguez', '1992-07-30 15:45:00', 777777, '1', '1', '1', 'foto5.jpg', '1');

-- Ejemplo 6
INSERT INTO Paciente (id_Paciente, estado, emailPaciente, contrasenia_Paciente, nombre_Paciente, apellido_Paciente, feche_Nacimiento, telefono_Paciente, eps_Paciente, tipo_Sangre, ciudad_Paciente, foto_Paciente, tipo_Alergia)
VALUES (6, true, 'paciente6@example.com', '$2a$10$TOdw9dGT3avd20LcPYg28.m/1sNZPxktRdc/Q0mmxWSqr9TCzQ6Xm', 'Sofía', 'García', '1997-11-25 09:30:00', 111111, '1', '1', '1', 'foto6.jpg', '1');


-- Ejemplo 1
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (1, 1, 1, '1', '2023-10-15 09:00:00', 'Motivo 1');

-- Ejemplo 2
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (2, 2, 2, '1', '2023-10-16 10:30:00', 'Motivo 2');

-- Ejemplo 3
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (3, 3, 3, '1', '2023-10-17 12:15:00', 'Motivo 3');

-- Ejemplo 4
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (4, 4, 4, '1', '2023-10-18 14:00:00', 'Motivo 4');

-- Ejemplo 5
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (5, 5, 5, '1', '2023-10-19 15:45:00', 'Motivo 5');

-- Ejemplo 6
INSERT INTO Cita (id_Cita, paciente_id_paciente, medico_id_medico, estado_Cita, fecha_Creacion, motivo_Consulta)
VALUES (6, 6, 6, '1', '2023-10-20 16:30:00', 'Motivo 6');



-- Ejemplo 1
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (1, 'Medicamento1', '5mg', 50);

-- Ejemplo 2
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (2, 'Medicamento2', '10mg', 30);

-- Ejemplo 3
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (3, 'Medicamento3', '15mg', 40);

-- Ejemplo 4
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (4, 'Medicamento4', '20mg', 60);

-- Ejemplo 5
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (5, 'Medicamento5', '25mg', 25);

-- Ejemplo 6
INSERT INTO Medicamento (id_Medicamento, nombre_Medicamento, dosis, cantidad_Medicamentos)
VALUES (6, 'Medicamento6', '30mg', 35);



-- Ejemplo 1
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (1, 'Diagnóstico 1', 'Tratamiento 1', 'Síntomas del paciente 1', 'Nota médica 1', 1, 1, 1);

-- Ejemplo 2
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (2, 'Diagnóstico 2', 'Tratamiento 2', 'Síntomas del paciente 2', 'Nota médica 2', 2, 2, 2);

-- Ejemplo 3
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (3, 'Diagnóstico 3', 'Tratamiento 3', 'Síntomas del paciente 3', 'Nota médica 3', 3, 3, 3);

-- Ejemplo 4
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (4, 'Diagnóstico 4', 'Tratamiento 4', 'Síntomas del paciente 4', 'Nota médica 4', 4, 4, 4);

-- Ejemplo 5
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (5, 'Diagnóstico 5', 'Tratamiento 5', 'Síntomas del paciente 5', 'Nota médica 5', 5, 5, 5);

-- Ejemplo 6
INSERT INTO Orden_Medica (id_Orden_Medica, diagnostico, tratamiento, sintomas_Paciente, nota_Medica, citas_id_cita, paciente_id_paciente, medico_id_medico)
VALUES (6, 'Diagnóstico 6', 'Tratamiento 6', 'Síntomas del paciente 6', 'Nota médica 6', 6, 6, 6);


-- Ejemplo 1
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (1, 1, '2023-10-15 14:00:00', 'Motivo 1', 'En proceso');

-- Ejemplo 2
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (2, 2, '2023-10-16 10:30:00', 'Motivo 2', 'Resuelto');

-- Ejemplo 3
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (3, 3, '2023-10-17 12:15:00', 'Motivo 3', 'En proceso');

-- Ejemplo 4
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (4, 4, '2023-10-18 11:00:00', 'Motivo 4', 'Pendiente');

-- Ejemplo 5
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (5, 5, '2023-10-19 15:45:00', 'Motivo 5', 'En proceso');

-- Ejemplo 6
INSERT INTO PQRS (idPQRS, cita_id_cita, fecha_Creacion, motivo, estado)
VALUES (6, 6, '2023-10-20 09:30:00', 'Motivo 6', 'Resuelto');



-- Ejemplo 1
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (1, 1, 1, true);

-- Ejemplo 2
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (2, 2, 2, false);

-- Ejemplo 3
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (3, 3, 3, true);

-- Ejemplo 4
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (4, 4, 4, false);

-- Ejemplo 5
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (5, 5, 5, true);

-- Ejemplo 6
INSERT INTO Autorizacion_Medicamento (id_Autorizacion, orden_medica_id_orden_medica, administrador_id_administrador, estado)
VALUES (6, 6, 6, false);



-- Ejemplo 1
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (1, 'Dirección 1', 1, 1);

-- Ejemplo 2
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (2, 'Dirección 2', 2, 2);

-- Ejemplo 3
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (3, 'Dirección 3', 3, 3);

-- Ejemplo 4
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (4, 'Dirección 4', 4, 4);

-- Ejemplo 5
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (5, 'Dirección 5', 5, 5);

-- Ejemplo 6
INSERT INTO Entrega_Medicamento (id, direccion_Entrega, paciente_id_paciente, medicamento_id_medicamento)
VALUES (6, 'Dirección 6', 6, 6);



-- Ejemplo 1
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (1, '2023-10-15 08:00:00', '2023-10-15 12:00:00', 1);

-- Ejemplo 2
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (2, '2023-10-16 09:00:00', '2023-10-16 13:00:00', 2);

-- Ejemplo 3
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (3, '2023-10-17 10:00:00', '2023-10-17 14:00:00', 3);

-- Ejemplo 4
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (4, '2023-10-18 11:00:00', '2023-10-18 15:00:00', 4);

-- Ejemplo 5
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (5, '2023-10-19 12:00:00', '2023-10-19 16:00:00', 5);

-- Ejemplo 6
INSERT INTO Horario (id, hora_Entrada, hora_Salida, medico_id_medico)
VALUES (6, '2023-10-20 13:00:00', '2023-10-20 17:00:00', 6);



-- Ejemplo 1
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (1, 'Mensaje 1 de PQRS 1', 1, 1, '2023-10-15 08:00:00');

-- Ejemplo 2
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (2, 'Mensaje 2 de PQRS 1', 2, 1, '2023-10-16 09:00:00');

-- Ejemplo 3
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (3, 'Mensaje 1 de PQRS 2', 3, 2, '2023-10-17 10:00:00');

-- Ejemplo 4
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (4, 'Mensaje 2 de PQRS 2', 4, 2, '2023-10-18 11:00:00');

-- Ejemplo 5
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (5, 'Mensaje 1 de PQRS 3', 5, 3, '2023-10-19 12:00:00');

-- Ejemplo 6
INSERT INTO MensajePQRS (id, mensajePQRS, administrador_id_administrador, pqrs_idpqrs, fecha)
VALUES (6, 'Mensaje 2 de PQRS 3', 6, 3, '2023-10-20 13:00:00');



