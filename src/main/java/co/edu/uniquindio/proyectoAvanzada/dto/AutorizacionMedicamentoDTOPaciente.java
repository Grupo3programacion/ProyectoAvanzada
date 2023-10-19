package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record AutorizacionMedicamentoDTOPaciente(
        LocalDateTime fecha,
        int idPaciente,
        int idOrden,
        int idMedico,
        int idMedicamento,
        int cantidad
) {
}
