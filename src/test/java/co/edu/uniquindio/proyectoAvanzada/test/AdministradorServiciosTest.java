package co.edu.uniquindio.proyectoAvanzada.test;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl.AdministradorServicioImpl;
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
public class AdministradorServiciosTest {

    @Autowired
    AdministradorServicioImpl administradorServicioImpl;

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarMedicoTest() throws Exception{

        DetalleMedicoDTO detalleMedicoDTO = administradorServicioImpl.obtenerMedico(1);

        DetalleMedicoDTO modificado = new DetalleMedicoDTO(
                detalleMedicoDTO.nombre(),
                detalleMedicoDTO.cedula(),
                detalleMedicoDTO.ciudad(),
                detalleMedicoDTO.especialidad(),
                "555555",
                detalleMedicoDTO.correo(),
                detalleMedicoDTO.fotoMedico(),
                detalleMedicoDTO.horarios());


        administradorServicioImpl.actualizarMedico(modificado);

        //Se obtiene nuevamente el paciente para comprobar que sí se haya actualizado
        DetalleMedicoDTO objetoModificado = administradorServicioImpl.obtenerMedico(1);
        //Se comprueba que el teléfono del paciente sea el que se le asignó en la actualización
        Assertions.assertEquals("555555", objetoModificado.telefono());
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarMedicoTest() throws Exception {

        //Se borra por ejemplo el paciente con el código 2
        administradorServicioImpl.eliminarMedico(2);

        //Si intentamos buscar un paciente con el código del paciente borrado debemos obtener una
        // excepción indicando que ya no existe
       //Assertions.assertThrows(Exception.class, () -> administradorServicioImpl.obtenerMedico(2));
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void obtenerMedicoTest() throws Exception {
        //Se borra por ejemplo el paciente con el código 2
        DetalleMedicoDTO detalleMedicoDTO = administradorServicioImpl.obtenerMedico(2);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarMedicosTest() throws Exception {
        //Obtenemos la lista de todos los pacientes
        List<ItemMedicoDTO> lista = administradorServicioImpl.listarMedicos();
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 medicos, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(6, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarPQRSTest() throws Exception {
        //Obtenemos la lista de todos los pacientes
        List<GestionDTOPQRSAdmin> lista = administradorServicioImpl.listarPQRS(1);
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 medicos, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(6, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasTest() throws Exception {
        //Obtenemos la lista de todos los pacientes
        List<CitaDTOAdmin> lista = administradorServicioImpl.listarCitas();
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 citas, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(6, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void responderPQRSTest() throws Exception {
        int codigoCuenta = 1;
        int codigoPQRS = 1;
        int codigoMensaje =1;
        String mensaje = "Mensaje Administrador";
        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
                codigoCuenta,
                codigoPQRS,
                codigoMensaje,
                mensaje);

        int codigo = administradorServicioImpl.responderPQRS(registroRespuestaDTO);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void verDetallePQRSTest() throws Exception {

        administradorServicioImpl.verDetallePQRS(1);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void autorizarMedicamentosTest() throws Exception {

        int idOrdenMedica = 1;
        int idPaciente = 1;
        int idMedicamento = 1;
        int idAdmin = 1;
        Boolean estado = true;
        AutorizacionDTOAdmin autorizacionDTOAdmin = new AutorizacionDTOAdmin(
                idOrdenMedica,
                idPaciente,
                idMedicamento,
                idAdmin,
                estado);
        administradorServicioImpl.autorizacionMedicamentos(autorizacionDTOAdmin);
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void cambiarEstadoPQRSTest() throws Exception {
        administradorServicioImpl.cambiarEstadoPQRS(1, "Cerrada");
    }

}