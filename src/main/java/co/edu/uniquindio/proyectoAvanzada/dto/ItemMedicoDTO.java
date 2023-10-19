package co.edu.uniquindio.proyectoAvanzada.dto;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;

public record ItemMedicoDTO(
                            int cedula,
                            String nombre,
                            String urlFoto,
                            Especialidad especialidad)
                            //String especialidad)
                            {
    //esta clase es para listar los medicos
}
