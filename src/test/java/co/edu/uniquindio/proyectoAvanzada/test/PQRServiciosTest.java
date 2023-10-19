package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.PQRSDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.MensajePQRS;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.PQRServiciosImpl;
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
public class PQRServiciosTest {
    @Autowired
    PQRServiciosImpl pQRServiciosImpl;

    @Test
    @Sql("classpath:dataset.sql" )
    public void crearPQRTest() throws Exception{

        MensajePQRS mensaje1 = new MensajePQRS(1, "Mensaje 1 de PQRS 1", null, null, LocalDateTime.now());
        List<MensajePQRS> listaMensajes = new ArrayList<>();
        listaMensajes.add(mensaje1);

        PQRSDTO pqrsDTO = new PQRSDTO(
                LocalDateTime.now(),
                "Reclamo",
                1,
                1,
                listaMensajes,
                "Abierta");
        pQRServiciosImpl.crearPQR(pqrsDTO);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void cambiarEstadoPQRSTest() throws Exception {

        pQRServiciosImpl.cambiarEstadoPQRS(1, "Cerrada");
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void responderPQRSTest() throws Exception {

        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
                1,
                1,
                1,
                "Mensaje Administrador");

        int codigo = pQRServiciosImpl.responderPQRSAdmin(registroRespuestaDTO, 1);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void responderPQRSPacienteTest() throws Exception {

        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
                1,
                1,
                1,
                "Mensaje Administrador");

        int codigo = pQRServiciosImpl.responderPQRSPaciente(registroRespuestaDTO, 1);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarPQRSPacienteTest() throws Exception {
        List<PQRSDTO> lista = pQRServiciosImpl.listarPQRSPaciente(1);
        lista.forEach(System.out::println);
        Assertions.assertEquals(1, lista.size());
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void verDetallePQRSTest() throws Exception {
        pQRServiciosImpl.verDetallePQRS(1);
    }
}
