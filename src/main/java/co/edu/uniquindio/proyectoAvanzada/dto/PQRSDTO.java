package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.MensajePQRS;

import java.time.LocalDateTime;
import java.util.List;

public record PQRSDTO(

        LocalDateTime fecha,
        String motivo,
        int codigoCita,
        int codigoPaciente,
        List <MensajePQRS> mensajePQRS,
        String estado
){
}
