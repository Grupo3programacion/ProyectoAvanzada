package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record AutorizacionDTOAdmin(
        int idOrdenMedica,
        int idPaciente,
        int idMedicamento,
        int idAdmin,
        Boolean estado
) {


}
