package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record GestionCitasPacienteDTO(
        LocalDateTime fecha,
        LocalDateTime hora,
        String lugar,
        String nombreMedico
) {
}
