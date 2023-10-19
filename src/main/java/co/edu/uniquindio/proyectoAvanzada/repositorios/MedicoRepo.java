package co.edu.uniquindio.proyectoAvanzada.repositorios;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepo extends JpaRepository <Medico, Integer>{
    Optional<Medico> findByEmailMedico(String correo);
}
