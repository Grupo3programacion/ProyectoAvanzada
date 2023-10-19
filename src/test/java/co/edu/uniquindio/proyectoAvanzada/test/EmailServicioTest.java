package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.EmailDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.ItemMedicoDTO;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.EmailServicioImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class EmailServicioTest {

    @Autowired
    EmailServicioImpl emailServicioImpl;

    @Test
    @Sql("classpath:dataset.sql" )
    public void enviarCorreoTest() throws Exception {

        EmailDTO emailDTO = new EmailDTO (
                "Prueba",
                "Contenido emial",
                "prueba@prueba.co");

        emailServicioImpl.enviarCorreo(emailDTO);

    }


}
