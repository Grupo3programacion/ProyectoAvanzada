package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

import java.time.LocalDateTime;
import java.util.List;

public record CitaPacienteDTO(
        LocalDateTime fecha,
        int codigoMedico,
        int codigoPaciente,
        String motivo


) {
}
