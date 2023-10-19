package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.LoginDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.TokenDTO;

public interface AutenticacionServicio {

    TokenDTO login(LoginDTO loginDTO) throws Exception;


}
