package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record CitaDTOAdmin(
        int idCita,
        int idPaciente,
        String nombrePaciente,
        LocalDateTime fecha,
        String detalleCita


) {




}
