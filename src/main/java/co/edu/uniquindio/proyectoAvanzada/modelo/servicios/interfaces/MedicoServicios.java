package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces;

import co.edu.uniquindio.proyectoAvanzada.dto.*;

import java.util.List;

public interface MedicoServicios {

    List<CitasPendientesDTOMedico> listarCitasPendientes(CitasPendientesDTOMedico citasPendientesDTOMedico) throws Exception;

    String atenderCita(AtenderCitaDTOMedico atenderCitaDTOMedico) throws Exception;

    String agendarDiaLibre(DiaLibereDTOMedico diaLibereDTOMedico) throws Exception;

    List listarCitasRealizadasMedico(CitasRealizadasDTOMedico citasRealizadasDTOMedico) throws Exception;

    String asignarMedicamentosOrden( AsignacionMedicamentosDTO asignacionMedicamentosDTO )throws Exception;

}
