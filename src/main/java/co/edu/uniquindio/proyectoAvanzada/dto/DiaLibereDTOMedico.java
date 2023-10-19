package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record DiaLibereDTOMedico(
        int idMedico,
        LocalDateTime fecha,
        String comentario
) {
}
