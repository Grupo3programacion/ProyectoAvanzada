package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record DetalleCitaPacienteDTO(
        int idConsulta,
        LocalDateTime fecha,
        LocalDateTime hora,
        String nombreMedico,
        String apellidoMedico,
        String detalleConsulta
) {
}
