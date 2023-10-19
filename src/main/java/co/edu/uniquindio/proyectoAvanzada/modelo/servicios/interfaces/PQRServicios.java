package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.InfoPQRSDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.PQRSDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.RegistroRespuestaDTO;

import java.util.List;

public interface PQRServicios {

    int crearPQR(PQRSDTO pqrsdto) throws Exception;
    int cambiarEstadoPQRS(int codigo, String estado) throws Exception;
    int responderPQRSAdmin(RegistroRespuestaDTO registroRespuestaDTO, int codigo)throws Exception;
    int responderPQRSPaciente(RegistroRespuestaDTO pqrsdto, int codigo)throws Exception;
    List<PQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;
    InfoPQRSDTO verDetallePQRS(int codigo)throws Exception;



}
