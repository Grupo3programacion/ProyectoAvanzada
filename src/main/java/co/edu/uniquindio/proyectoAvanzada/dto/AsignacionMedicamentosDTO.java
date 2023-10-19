package co.edu.uniquindio.proyectoAvanzada.dto;

import java.util.List;

public record AsignacionMedicamentosDTO(
        int idOrdenMedica,
        List<MedicamentoDTO> listaMedicamentos
) {
}
