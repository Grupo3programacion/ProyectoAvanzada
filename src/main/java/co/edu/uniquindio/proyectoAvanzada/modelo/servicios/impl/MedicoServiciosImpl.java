package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces.MedicoServicios;
import co.edu.uniquindio.proyectoAvanzada.repositorios.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServiciosImpl implements MedicoServicios {

    private final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;
    private final PacienteRepo pacienteRepo;
    private final OrdenMedicaRepo ordenMedicaRepo;
    private final MedicamentoRepo medicamentoRepo;
    @Override
    public List<CitasPendientesDTOMedico> listarCitasPendientes(CitasPendientesDTOMedico citasPendientesDTOMedico) throws Exception {

        Optional<Medico> optionalMedico= medicoRepo.findById( citasPendientesDTOMedico.idMedico());

        if(optionalMedico.isEmpty()){
            throw new Exception("El id " + citasPendientesDTOMedico.idMedico() + " no esta registrado");
        }

        List<Cita> citas = citaRepo.findAll();

        if (citas.isEmpty()) {
            throw new Exception("No hay citas registradas");
        }

        List<CitasPendientesDTOMedico> citasPendientes = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getMedico().getIdMedico() == citasPendientesDTOMedico.idMedico() && citasPendientesDTOMedico.fecha().isBefore( LocalDateTime.now() )) {
                citasPendientes.add(new CitasPendientesDTOMedico(

                        c.getFechaCreacion(),
                        c.getMedico().getIdMedico(),
                        c.getIdCita(),
                        c.getPaciente().getNombrePaciente(),
                        c.getEstadoCita()
                ));

                citasPendientes.add(citasPendientesDTOMedico);
            }
        }

        return citasPendientes;
    }

    @Override
    public String atenderCita(AtenderCitaDTOMedico atenderCitaDTOMedico) throws Exception {

        Optional<Cita> optionalCita = citaRepo.findById( atenderCitaDTOMedico.idCita());

        if(optionalCita.isEmpty()){
            throw new Exception("El id de la cita no existe");
        }

        Optional<Paciente> optionalPaciente= pacienteRepo.findById( atenderCitaDTOMedico.idPaciente());

        if(optionalPaciente.isEmpty()){
            throw new Exception("El id de la cita no existe");
        }

        Optional<Medico> optionalMedico= medicoRepo.findById( atenderCitaDTOMedico.idMedico());

        if(optionalMedico.isEmpty()){
            throw new Exception("El id de la cita no existe");
        }

        Cita cita = optionalCita.get();
        Paciente paciente = optionalPaciente.get();
        Medico medico = optionalMedico.get();

        OrdenMedica ordenMedica = new OrdenMedica();

        ordenMedica.setPaciente(paciente);
        ordenMedica.setCitas(cita);
        ordenMedica.setNotaMedica(atenderCitaDTOMedico.notaMedica());
        ordenMedica.setDiagnostico(atenderCitaDTOMedico.diagnostico());
        ordenMedica.setTratamiento(atenderCitaDTOMedico.tratamiento());
        ordenMedica.setMedico(medico);
        ordenMedica.setSintomasPaciente(atenderCitaDTOMedico.sintomasPaciente());

        ordenMedicaRepo.save(ordenMedica);

        return "Cita atendida exitosamente";
    }
    @Override
    public String asignarMedicamentosOrden( AsignacionMedicamentosDTO asignacionMedicamentosDTO )throws Exception {

        Optional<OrdenMedica> optionalOrdenMedica = ordenMedicaRepo.findById(asignacionMedicamentosDTO.idOrdenMedica());
        if (optionalOrdenMedica.isEmpty()) {
            throw new Exception("El id de la cita no existe");
        }

        OrdenMedica om = optionalOrdenMedica.get();

        List<MedicamentoDTO> list = asignacionMedicamentosDTO.listaMedicamentos();

        for (MedicamentoDTO m : list) {

            Medicamento medi = new Medicamento();
            medi.setOrdenMedica(om);
            medi.setNombreMedicamento(m.nombre());
            medi.setCantidadMedicamentos(m.cantidad());
            medi.setDosis(m.dosis());

            medicamentoRepo.save(medi);
        }
    return "Medicamentos asignados exitosamente";

    }

    @Override
    public String agendarDiaLibre (DiaLibereDTOMedico diaLibreDTOMedico) throws Exception {
        Optional<Medico> optionalDiaLibre = medicoRepo.findById(diaLibreDTOMedico.idMedico());

        if (optionalDiaLibre.isEmpty()) {
            throw new Exception("El código " + diaLibreDTOMedico.idMedico() + " no está asociado a ningún médico");
        }

        Medico medico = optionalDiaLibre.get();

        if( medico.getDiaLibre() != null){
            if( medico.getDiaLibre().isAfter( LocalDateTime.now() ) ){
                throw new Exception("No se puede sacar un día libre");
            }else{
                medico.setDiaLibre(diaLibreDTOMedico.fecha());
            }
        }

        medicoRepo.save(medico);

        // Devolver un mensaje indicando que el día libre ha sido agendado exitosamente
        return "Día libre agendado exitosamente para el médico con código " + medico.getIdMedico();
    }

    @Override
    public List listarCitasRealizadasMedico(CitasRealizadasDTOMedico citasRealizadasDTOMedico) throws Exception {

        Optional<Medico> medicoOptional = medicoRepo.findById( citasRealizadasDTOMedico.idMedico() );

        if (medicoOptional.isEmpty()) {
            throw new Exception("Médico con ID " + citasRealizadasDTOMedico.idMedico() + " no encontrado");
        }

        List<Cita> citaOptional = citaRepo.findAll();

        if (citaOptional.isEmpty()) {
            throw new Exception("No hay citas registradas");
        }

        // for que recorra la lista de citas y que solo guarde las citas del medico buscado por ID cuya fecha sea anterior a la de hoy

        List<CitasRealizadasDTOMedico> citasRealizadas = new ArrayList<>();

        for (Cita c : citaOptional) {
            if (c.getMedico().getIdMedico() == citasRealizadasDTOMedico.idMedico() && citasRealizadasDTOMedico.fecha().isBefore( LocalDateTime.now() )) {
                citasRealizadas.add(new CitasRealizadasDTOMedico(


                        c.getMedico().getIdMedico(),
                        c.getFechaCreacion(),
                        c.getIdCita(),
                        c.getPaciente().getIdPaciente()
                ));

                citasRealizadas.add(citasRealizadasDTOMedico);
            }
        }
        return citasRealizadas;
    }
}


