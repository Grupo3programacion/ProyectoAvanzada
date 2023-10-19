package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl;

import co.edu.uniquindio.proyectoAvanzada.dto.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.*;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Ciudad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.EstadoCita;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.proyectoAvanzada.repositorios.*;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//por cada una de las interfaces debe tener un implement

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    //aca van todos los repositorios
    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final AutorizacionMedicamentoRepo autorizacionMedicamentoRepo;
    private final AdministradorRepo administradorRepo;



   /* public AdministradorServicioImpl(MedicoRepo medicoRepo,PQRSRepo pqrsRepo) {
este construntor es remplazado por el @RequiredArgsConstructor
        this.medicoRepo = medicoRepo;
        this.pqrsRepo = pqrsRepo;
    }*/

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {

        Medico medico = new Medico();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        medico.setIdMedico(medicoDTO.cedula());
        medico.setTelefonoMedico(medicoDTO.telefono());
        medico.setNombreMedico(medicoDTO.nombre() );
        medico.setEspecilidadMedico( medicoDTO.especialidad());
        medico.setCiudadMedico(medicoDTO.ciudad());
        medico.setEmailMedico(medicoDTO.correo() );
        medico.setContraseniaMedico( passwordEncoder.encode( medicoDTO.password()) ) ;
        medico.setFotoMedico(medicoDTO.fotoMedico());
        medico.setEstado(true);

        Medico medicoNuevo = medicoRepo.save(medico);
        return medicoNuevo.getIdMedico();
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {
        Optional<Medico> buscado = medicoRepo.findById(medicoDTO.cedula());

        if(buscado.isEmpty() ){
            throw new Exception("El código "+medicoDTO.cedula()+" no existe");
        }

        Medico medico = buscado.get();
        medico.setTelefonoMedico(medicoDTO.telefono());
        medico.setNombreMedico(medicoDTO.nombre() );
        medico.setEspecilidadMedico( medicoDTO.especialidad());
        medico.setCiudadMedico(medicoDTO.ciudad());
        medico.setEmailMedico(medicoDTO.correo() );
        medico.setFotoMedico(medicoDTO.fotoMedico());

        Medico medicoNuevo = medicoRepo.save(medico);
        return medicoNuevo.getIdMedico();
    }

    @Override
    public int guardarMedico(int codigo, MedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public int historialMedicoPaciente(int codigo, HistorialMedicoPacienteDTOAdmin historialMedicoPacienteDTOAdmin) throws Exception {
        return 0;
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

        //findById es para buscar
        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if(buscado.isEmpty() ){
            throw new Exception("El código "+codigo+" no existe");
        }

        //medicoRepo.delete( buscado.get() );
        Medico obtenido = buscado.get();
        obtenido.setEstado( false );

        medicoRepo.save(obtenido);
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if(buscado.isEmpty() ){
            throw new Exception("El código "+codigo+" no existe");
        }

        Medico obtenido = buscado.get();

        DetalleMedicoDTO detalleMedicoDTO = new DetalleMedicoDTO(
                //se debe manejar el orden del constructor porque si no da error

                obtenido.getNombreMedico(),
                obtenido.getIdMedico(),
                obtenido.getCiudadMedico(),
                obtenido.getEspecilidadMedico(),
                obtenido.getTelefonoMedico(),
                obtenido.getEmailMedico(),
                obtenido.getFotoMedico(),
                obtenido.getHorarios()
                //new ArrayList<>

        );

      return detalleMedicoDTO;
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();
        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for(Medico medico : medicos){
            if(medico.isEstado()) {
                respuesta.add(new ItemMedicoDTO(
                        medico.getIdMedico(),
                        medico.getNombreMedico(),
                        medico.getFotoMedico(),
                        medico.getEspecilidadMedico()));




            }
        }

        return respuesta;
    }

    @Override
    public List<GestionDTOPQRSAdmin> listarPQRS(int idPQRS) throws Exception {

        List<PQRS>listaPqrs = pqrsRepo.findAll();//esto es como una consulta select * from pqrs
        List <GestionDTOPQRSAdmin> respuesta = new ArrayList<>();

        for (PQRS p : listaPqrs){
            respuesta.add(new GestionDTOPQRSAdmin(
                    p.getIdPQRS(),
                    p.getCita().getFechaCreacion(),
                    p.getEstado(),
                    p.getCita().getPaciente().getIdPaciente(),
                    p.getCita().getPaciente().getNombrePaciente(),
                    p.getCita().getPaciente().getApellidoPaciente(),
                    p.getCita().getPaciente().getTelefonoPaciente(),
                    p.getCita().getPaciente().getEmaiLPaciente(),
                    p.getMensajePqrs()));
        }

       /* List<GestionDTOPQRSAdmin>lista = listaPqrs.stream().map(pqrs -> new GestionDTOPQRSAdmin(
                //va lo mismo de los get de arriba
        )).toList();*/

        return respuesta;
    }

    @Override
    public List<CitaDTOAdmin> listarCitas() throws Exception {

        List<Cita> listaCitas = citaRepo.findAll();
        List<CitaDTOAdmin> respuesta = new ArrayList<>();

        for(Cita c : listaCitas){
            respuesta.add(new CitaDTOAdmin(
                    c.getIdCita(),
                    c.getPaciente().getIdPaciente(),
                    c.getPaciente().getNombrePaciente(),
                    c.getFechaCreacion(),
                    c.getMotivoConsulta()));

        }
        return respuesta;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        //obtener el PQRS
        Optional<PQRS> opcional = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoPQRS()+"no esta asociado a ningun PQRS"));
        }

        //obtener LA CUENTA
        Optional<Administrador> opcionalAdministrador = administradorRepo.findById(registroRespuestaDTO.codigoCuenta());
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

    @Override
    public int autorizacionMedicamentos(AutorizacionDTOAdmin autorizacionDTOAdmin) throws Exception {
        //obtener la autorizacion
        Optional<AutorizacionMedicamento> opcional = autorizacionMedicamentoRepo.findById(autorizacionDTOAdmin.idOrdenMedica());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+autorizacionDTOAdmin.idOrdenMedica()+"no esta asociado a ninguna orden medica"));
        }
        //obtener LA CUENTA
        Optional<Medico> opcionalMedico = medicoRepo.findById(autorizacionDTOAdmin.idPaciente());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+autorizacionDTOAdmin.idPaciente()+"no esta asociado a ningun PQRS"));
        }

        AutorizacionMedicamento autorizacionMedicamento = new AutorizacionMedicamento();
        autorizacionMedicamento.getIdAutorizacion();
        autorizacionMedicamento.getOrdenMedica();
        autorizacionMedicamento.getAdministrador();
        autorizacionMedicamento.setEstado(autorizacionDTOAdmin.estado());

        return autorizacionMedicamentoRepo.save(autorizacionMedicamento).getIdAutorizacion();
    }
//todas la enumeraciones deben tener listas
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
}
