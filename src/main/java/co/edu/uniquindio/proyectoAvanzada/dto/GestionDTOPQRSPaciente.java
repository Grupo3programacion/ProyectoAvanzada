package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record GestionDTOPQRSPaciente(
        int idPQRS,
        String comentarios,
        int idAmin
) {
}
