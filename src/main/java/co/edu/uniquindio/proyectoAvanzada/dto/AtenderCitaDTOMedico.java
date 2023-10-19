package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Paciente;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.TipoIdentificacion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public record AtenderCitaDTOMedico(
        @NotNull
        int idPaciente,
        int idCita,
        int idMedico,
        String diagnostico,
        String tratamiento,
        String sintomasPaciente,
        String notaMedica

) {
}
