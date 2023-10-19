package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.MensajePQRS;

import java.time.LocalDateTime;
import java.util.List;

public record GestionDTOPQRSAdmin(
        int idPQRS,
        LocalDateTime fechaConsultaPQRS,
        String estadoPQRS,
        int idPaciente,
        String nombrePaciente,
        String apellidoPaciente,
        int telefonoPaciente,
        String emailPaciente,

        List <MensajePQRS> mensajePQRS
) {
}
