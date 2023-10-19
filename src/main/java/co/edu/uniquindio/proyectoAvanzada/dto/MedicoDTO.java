package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Ciudad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

import java.util.List;

public record MedicoDTO(
    String nombre,
    int cedula,
    Ciudad ciudad,
    Especialidad especialidad,
    String telefono,
    String correo,
    String password,
    String fotoMedico,
    String horaInicioJornada,
    String horaFinJornada,

    List<HorarioDTO> horarios
)
//estos atributos es de acuerdo a los mockup diseaños en el proyecto
{
}
