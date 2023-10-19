package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Horario;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Ciudad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

import java.util.List;

public record DetalleMedicoDTO(
        String nombre,

        int cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String fotoMedico,
        List <Horario> horarios


)
//estos atributos es de acuerdo a los mockup diseaños en el proyecto
{
}
