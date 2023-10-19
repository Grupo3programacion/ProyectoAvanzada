package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.*;

import java.util.List;

public interface PacienteServicios {

    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarPerfil(int idPaciente, PacienteDTO pacienteDTO) throws Exception;

    void recuperarPassword(RecuperarPasswordDTO dto) throws Exception;

    void eliminarCuenta(int idPaciente) throws Exception;

    void enviarLinkRecuperacion(String emailPaciente) throws Exception;

    int cambiarPassword(int idPaciente, String nuevaPassword) throws Exception;

    void agendarCita(CitaPacienteDTO citaPacienteDTO) throws Exception;

    void responderPQRS(GestionDTOPQRSPaciente gestionDTOPQRSPaciente) throws Exception;

    List<ItenCitaPacienteDTO> listarCitasPaciente(int idPaciente);

    List<MedicoDTOPaciente> filtrarCitaPorMedico(int idPaciente, int idMedico) throws Exception;

    List<FiltrarFechaPacienteDTO> filtrarCitaPorFecha(FiltrarFechaPacienteDTO filtrarFechaPacienteDTO) throws Exception;

    List<MedicoDTOPaciente> verDetalleCita(MedicoDTOPaciente medicoDTOPaciente) throws Exception;

    List<ConsultaMedicamentosDTOPaciente> consultaMedicamentos(int idMedicamento) throws Exception;
    PacienteDTO obtenerPaciente(int codigo) throws Exception;
}