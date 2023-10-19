package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

import java.time.LocalDateTime;

public record MedicoDTOPaciente(
        int idCita,
        int idPaciente,
        String nombreMedico,
        Especialidad especialidad,

        LocalDateTime fechaCreacion
) {
}
