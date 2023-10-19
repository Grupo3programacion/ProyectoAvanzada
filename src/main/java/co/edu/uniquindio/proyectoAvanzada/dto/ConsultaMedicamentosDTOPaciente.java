package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record ConsultaMedicamentosDTOPaciente(
        int idMedicamento,
        LocalDateTime fecha,
        String nombreMedicamento,
        int cantidadMedicamento,
        String dosis
) {
}
