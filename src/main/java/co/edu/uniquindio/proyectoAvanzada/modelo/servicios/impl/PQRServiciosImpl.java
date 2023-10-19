package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces.PQRServicios;
import co.edu.uniquindio.proyectoAvanzada.repositorios.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//por cada una de las interfaces debe tener un implement

@Service
@RequiredArgsConstructor
public class PQRServiciosImpl implements PQRServicios {

    private final CitaRepo citaRepo;
    private final PQRSRepo pqrsRepo;
    private final MensajeRepo mensajeRepo;
    private final AdministradorRepo administradorRepo;
    private final PacienteRepo pacienteRepo;

    @Override
    public int crearPQR(PQRSDTO pqrsdto) throws Exception {
        Optional<Cita> optional = citaRepo.findById(pqrsdto.codigoCita());
        PQRS pqrs = new PQRS();
        pqrs.setCita(optional.get());
        pqrs.setMotivo(pqrsdto.motivo());
        pqrs.setFechaCreacion(pqrsdto.fecha());
        pqrs.setEstado("Abierta");

        PQRS pqrsNew = pqrsRepo.save(pqrs);
        return pqrsNew.getIdPQRS();
    }

    @Override
    public int cambiarEstadoPQRS(int codigoPQRS, String estadoPQRS) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+codigoPQRS+"no esta asociado a ningun PQRS"));
        }
        PQRS pqrs = opcional.get();
        pqrs.setEstado(estadoPQRS);
        pqrsRepo.save(pqrs);
        return pqrs.getIdPQRS();
    }

    @Override
    public int responderPQRSAdmin(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception {
        //obtener el PQRS
        Optional<PQRS> opcional = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoPQRS()+"no esta asociado a ningun PQRS"));
        }
        //obtener LA CUENTA
        Optional<Administrador> opcionalCuenta = administradorRepo.findById(registroRespuestaDTO.codigoCuenta());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoCuenta()+"no esta asociado a ningun PQRS"));
        }
        MensajePQRS mensajePQRS = new MensajePQRS();
        mensajePQRS.setId(registroRespuestaDTO.codigoCuenta());
        mensajePQRS.setPqrs(opcional.get());
        mensajePQRS.setFecha(LocalDateTime.now());
        mensajePQRS.setMensajePQRS(registroRespuestaDTO.mensaje());
        return mensajeRepo.save(mensajePQRS).getId();
    }

    @Override
    public int responderPQRSPaciente(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception {
        //obtener el PQRS
        Optional<PQRS> opcional = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoPQRS()+"no esta asociado a ningun PQRS"));
        }
        //obtener LA CUENTA
        Optional<Paciente> opcionalCuenta = pacienteRepo.findById(registroRespuestaDTO.codigoCuenta());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoCuenta()+"no esta asociado a ningun PQRS"));
        }
        MensajePQRS mensajePQRS = new MensajePQRS();
        mensajePQRS.setId(registroRespuestaDTO.codigoCuenta());
        mensajePQRS.setPqrs(opcional.get());
        mensajePQRS.setFecha(LocalDateTime.now());
        mensajePQRS.setMensajePQRS(registroRespuestaDTO.mensaje());
        return mensajeRepo.save(mensajePQRS).getId();
    }


    @Override
    public List<PQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<PQRS>listaPqrs = pqrsRepo.findAllByCitaPacienteIdPaciente(codigoPaciente);
        List <PQRSDTO> respuesta = new ArrayList<>();

        for (PQRS p : listaPqrs){
            respuesta.add(new PQRSDTO(
                    p.getFechaCreacion(),
                    p.getMotivo(),
                    p.getCita().getIdCita(),
                    p.getCita().getPaciente().getIdPaciente(),
                    p.getMensajePqrs(),
                    p.getEstado()));
        }
        return respuesta;
    }

    @Override
    public InfoPQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+codigo+"no esta asociado a ningun PQRS"));
        }
        PQRS pqrs = opcional.get();

        return new InfoPQRSDTO(
                pqrs.getIdPQRS(),
                pqrs.getEstado(),
                pqrs.getCita().getIdCita(),
                pqrs.getFechaCreacion(),
                pqrs.getMotivo(),
                pqrs.getMensajePqrs());
    }
}