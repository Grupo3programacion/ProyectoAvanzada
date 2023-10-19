package co.edu.uniquindio.proyectoAvanzada.modelo.servicios.impl;


import co.edu.uniquindio.proyectoAvanzada.dto.LoginDTO;
import co.edu.uniquindio.proyectoAvanzada.dto.TokenDTO;
import co.edu.uniquindio.proyectoAvanzada.modelo.Utils.JWTUtils;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Administrador;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Medico;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Paciente;
import co.edu.uniquindio.proyectoAvanzada.modelo.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.proyectoAvanzada.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyectoAvanzada.repositorios.MedicoRepo;
import co.edu.uniquindio.proyectoAvanzada.repositorios.PacienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final PacienteRepo pacienteRepo;
    private final MedicoRepo medicoRepo;
    private final AdministradorRepo administradorRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String paswordGuardada = "";
        String rol;
        String nombre;
        int codigo;

        Optional<Paciente> optionalPaciente = pacienteRepo.findByEmaiLPaciente( loginDTO.correo() );

        if( optionalPaciente.isEmpty() ){

            Optional<Medico> optionalMedico = medicoRepo.findByEmailMedico( loginDTO.correo() );

            if( optionalMedico.isEmpty() ){

                Optional<Administrador> optionalAdministrador = administradorRepo.findByEmailAdministrador( loginDTO.correo() );

                if( optionalAdministrador.isEmpty() ){
                    throw new Exception("EL correo no existe");
                }else{
                    codigo = optionalAdministrador.get().getIdAdministrador();
                    nombre = optionalAdministrador.get().getNombreAdministrador();
                    rol = "Admin";
                    paswordGuardada = optionalAdministrador.get().getContraseniaAdministrador();
                }

            }else{
                codigo = optionalMedico.get().getIdMedico();
                nombre = optionalMedico.get().getNombreMedico();
                rol = "Medico";
                paswordGuardada = optionalMedico.get().getContraseniaMedico();
            }

        }else{
            codigo = optionalPaciente.get().getIdPaciente();
            nombre = optionalPaciente.get().getNombrePaciente();
            rol = "Paciente";
            paswordGuardada = optionalPaciente.get().getContraseniaPaciente();
        }

        if (!passwordEncoder.matches(loginDTO.contrasenia(), paswordGuardada)) {
            throw new Exception("La contraseña ingresada es incorrecta");
        }

        return new TokenDTO(crearToken(loginDTO.correo(), rol, codigo, nombre));
    }

    private String crearToken(String email, String rol, int codigo, String nombre) {

        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", codigo);

        return jwtUtils.generarToken(email, map);
    }
}