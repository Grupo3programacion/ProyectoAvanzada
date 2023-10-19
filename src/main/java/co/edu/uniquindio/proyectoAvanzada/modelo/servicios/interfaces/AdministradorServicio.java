package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.EstadoCita;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(DetalleMedicoDTO detalleMedicoDTO) throws Exception;
    int guardarMedico(int codigo, MedicoDTO medico) throws Exception;
    int historialMedicoPaciente(int codigo, HistorialMedicoPacienteDTOAdmin historialMedicoPacienteDTOAdmin) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;
    List<ItemMedicoDTO> listarMedicos() throws Exception;

    List <GestionDTOPQRSAdmin> listarPQRS(int idPQRS) throws Exception;
    List <CitaDTOAdmin>listarCitas() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    InfoPQRSDTO verDetallePQRS(int codigo)throws Exception;

    int autorizacionMedicamentos(AutorizacionDTOAdmin autorizacionDTOAdmin) throws Exception;
    int cambiarEstadoPQRS (int codigoPQRS, String estadoPQRS) throws Exception;

}
