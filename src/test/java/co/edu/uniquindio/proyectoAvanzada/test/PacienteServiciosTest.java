package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.PacienteServiciosImpl;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces.PacienteServicios;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class PacienteServiciosTest {

    @Autowired
    private PacienteServiciosImpl pacienteServiciosImpl;


    @Test
    @Sql("classpath:dataset.sql" )
    public void editarPerfilTest() throws Exception{

        PacienteDTO pacienteDTO = pacienteServiciosImpl.obtenerPaciente(1);

        PacienteDTO modificado = new PacienteDTO(
                pacienteDTO.nomnbrePaciente(),
                pacienteDTO.apellidoPaciente(),
                pacienteDTO.idPaciente(),
                pacienteDTO.fechaNacimiento(),
                32878444,
                pacienteDTO.emailPaciente(),
                pacienteDTO.epsPaciente(),
                pacienteDTO.tipoSangre(),
                pacienteDTO.ciudadPaciente(),
                pacienteDTO.fotoPaciente(),
                pacienteDTO.tipoAlergia(),
                pacienteDTO.contrasenia(),
                pacienteDTO.confirmarContrasenia());

        pacienteServiciosImpl.editarPerfil(1, modificado);
        PacienteDTO objetoModificado = pacienteServiciosImpl.obtenerPaciente(1);
        Assertions.assertEquals(32878444, objetoModificado.telefonoPaciente());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void obtenerPacienteTest() throws Exception {

        PacienteDTO detalleMedicoDTO = pacienteServiciosImpl.obtenerPaciente(1);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarPacienteTest() throws Exception {
        pacienteServiciosImpl.eliminarCuenta(2);
        //Assertions.assertThrows(Exception.class, () -> pacienteServiciosImpl.obtenerPaciente(2));
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void cambiarPasswordTest() throws Exception {
        pacienteServiciosImpl.cambiarPassword(2, "");
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void agendarCitaTest() throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        int codigoMedico = 1;
        int codigoPaciente = 2;
        String motivo = "Prueba";

        CitaPacienteDTO citaPacienteDTO = new CitaPacienteDTO(
                fecha,
                codigoMedico,
                codigoPaciente,
                motivo);
        pacienteServiciosImpl.agendarCita(citaPacienteDTO);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void responderPQRSTest() throws Exception {
        int idPQRS = 2;
        String comentarios = "Prueba";
        int idAmin = 1;

        GestionDTOPQRSPaciente gestionDTOPQRSPaciente = new GestionDTOPQRSPaciente(
                idPQRS,
                comentarios,
                idAmin);
        pacienteServiciosImpl.responderPQRS(gestionDTOPQRSPaciente);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasPacienteTest() throws Exception {
        List<ItenCitaPacienteDTO> lista = pacienteServiciosImpl.listarCitasPaciente(1);
        lista.forEach(System.out::println);
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void filtrarCitaPorMedicoTest() throws Exception {
        List<MedicoDTOPaciente> lista = pacienteServiciosImpl.filtrarCitaPorMedico(1, 2);
        lista.forEach(System.out::println);
        //Assertions.assertEquals(2, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void filtrarCitaPorFechaTest() throws Exception {
        int idPaciente = 1;
        LocalDateTime fechaCreacion = LocalDateTime.now();
        String NombreMedico = "";
        Especialidad EspecilidadMedico = Especialidad.PEDIATRA;

        FiltrarFechaPacienteDTO filtrarFechaPacienteDTO = new FiltrarFechaPacienteDTO(
                idPaciente,
                fechaCreacion,
                NombreMedico,
                EspecilidadMedico);

        List<FiltrarFechaPacienteDTO> lista = pacienteServiciosImpl.filtrarCitaPorFecha(filtrarFechaPacienteDTO);
        lista.forEach(System.out::println);
        //Assertions.assertEquals(2, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void verDetalleCitaTest() throws Exception {
        int idCita = 1;
        int idPaciente= 1;
        String nombreMedico = "";
        Especialidad especialidad = Especialidad.PEDIATRA;
        LocalDateTime fechaCreacion = LocalDateTime.now();

        MedicoDTOPaciente medicoDTOPaciente = new MedicoDTOPaciente(
                idCita,
                idPaciente,
                nombreMedico,
                especialidad,
                fechaCreacion);

        List<MedicoDTOPaciente> lista = pacienteServiciosImpl.verDetalleCita(medicoDTOPaciente);
        lista.forEach(System.out::println);
        //Assertions.assertEquals(2, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void consultaMedicamentosTest() throws Exception {
        List<ConsultaMedicamentosDTOPaciente> lista = pacienteServiciosImpl.consultaMedicamentos(1);
        lista.forEach(System.out::println);
        //Assertions.assertEquals(2, lista.size());
    }



}

