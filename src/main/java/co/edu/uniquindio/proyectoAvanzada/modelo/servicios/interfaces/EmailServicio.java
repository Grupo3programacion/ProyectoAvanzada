package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.EmailDTO;

public interface EmailServicio {

    void enviarCorreo(EmailDTO emailDTO) throws Exception;



}
