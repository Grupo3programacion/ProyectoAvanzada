package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.EstadoCita;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.AdministradorServicioImpl;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.MedicoServiciosImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class MedicosServiciosTest {


    @Autowired
    MedicoServiciosImpl medicoServiciosImpl;

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasPendientesTest() throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        int idMedico = 1;
        int idCita = 1;
        String nombrePaciente = "";
        EstadoCita estado = EstadoCita.CERRADO;

        CitasPendientesDTOMedico CitasPendientesDTOMedico = new CitasPendientesDTOMedico(
                fecha,
                idMedico,
                idCita,
                nombrePaciente,
                estado);

        List<CitasPendientesDTOMedico> lista = medicoServiciosImpl.listarCitasPendientes(CitasPendientesDTOMedico);
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void atenderCitaTest() throws Exception {
        int idPaciente = 2;
        int idCita = 2;
        int idMedico = 2;
        String diagnostico = "Prueba";
        String tratamiento = "Prueba";
        String sintomasPaciente = "Prueba";
        String notaMedica = "Prueba";

        AtenderCitaDTOMedico atenderCitaDTOMedico = new AtenderCitaDTOMedico(
                idPaciente,
                idCita,
                idMedico,
                diagnostico,
                tratamiento,
                sintomasPaciente,
                notaMedica);
        medicoServiciosImpl.atenderCita(atenderCitaDTOMedico);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void asignarMedicamentosOrdenTest() throws Exception {
        int idOrdenMedica = 1;
        MedicamentoDTO medicamento1 = new MedicamentoDTO("Medicamento1", 10, "5mg");
        MedicamentoDTO medicamento2 = new MedicamentoDTO("Medicamento2", 20, "10mg");
        MedicamentoDTO medicamento3 = new MedicamentoDTO("Medicamento3", 30, "15mg");
        List<MedicamentoDTO> listaMedicamentos = new ArrayList<>();
        listaMedicamentos.add(medicamento1);
        listaMedicamentos.add(medicamento2);
        listaMedicamentos.add(medicamento3);

        AsignacionMedicamentosDTO asignacionMedicamentosDTO = new AsignacionMedicamentosDTO(
                idOrdenMedica,
                listaMedicamentos);
        medicoServiciosImpl.asignarMedicamentosOrden(asignacionMedicamentosDTO);
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void agendarDiaLibreTest() throws Exception {
        int idMedico = 1;
        LocalDateTime fecha = LocalDateTime.now();
        String comentario = "Prueba";

        DiaLibereDTOMedico diaLibereDTOMedico = new DiaLibereDTOMedico(
                idMedico,
                fecha,
                comentario);
        medicoServiciosImpl.agendarDiaLibre(diaLibereDTOMedico);
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasRealizadasMedicoTest() throws Exception {
        int idMedico = 3;
        LocalDateTime fecha = LocalDateTime.now();
        int idConsulta = 3;
        int idPaciente = 4;

        CitasRealizadasDTOMedico citasRealizadasDTOMedico = new CitasRealizadasDTOMedico(
                idMedico,
                fecha,
                idConsulta,
                idPaciente);

        List<CitasRealizadasDTOMedico> lista = medicoServiciosImpl.listarCitasRealizadasMedico(citasRealizadasDTOMedico);
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());
    }

}

