package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

import java.time.LocalDateTime;

public record FiltrarFechaPacienteDTO(
        int idPaciente,
        LocalDateTime fechaCreacion,
        String NombreMedico,
        Especialidad EspecilidadMedico
) {
}
