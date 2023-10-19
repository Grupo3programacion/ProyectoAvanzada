package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.ImagenesServicioImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class ImagenesServicioTest {

    @Autowired
    ImagenesServicioImpl imagenesServicioImpl;


    @Test
    @Sql("classpath:dataset.sql" )
    public void subirImagenTest() throws Exception {
        String nombreArchivo = "Prueba.jpg";
        String rutaArchivo = "C:\\Users\\josew\\Desktop\\" + nombreArchivo;
        MultipartFile imagen = new MockMultipartFile("imagen", nombreArchivo, "image/jpeg", Files.readAllBytes(Paths.get(rutaArchivo)));

        imagenesServicioImpl.subirImagen(imagen);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarImagenTest() throws Exception {
        imagenesServicioImpl.eliminarImagen("1");
    }



}

