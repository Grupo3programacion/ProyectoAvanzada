package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.LoginDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.TokenDTO;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.AutenticacionServicioImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class AutenticacionServicioTest {

    @Autowired

    AutenticacionServicioImpl autenticacionServicioImpl;


    @Test
    @Sql("classpath:dataset.sql" )
    public void loginTest() throws Exception {
        LoginDTO loginDTO = new LoginDTO(
                "medico1@example.com",
                "1234");

        TokenDTO tokenDTO = autenticacionServicioImpl.login(loginDTO);

        Assertions.assertNotNull(tokenDTO);
    }
}
