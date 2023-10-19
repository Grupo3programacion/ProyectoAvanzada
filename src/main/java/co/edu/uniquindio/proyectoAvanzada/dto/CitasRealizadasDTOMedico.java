package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.TipoIdentificacion;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public record CitasRealizadasDTOMedico(
        int idMedico,
        LocalDateTime fecha,
        int idConsulta,
        int idPaciente

) {
}
