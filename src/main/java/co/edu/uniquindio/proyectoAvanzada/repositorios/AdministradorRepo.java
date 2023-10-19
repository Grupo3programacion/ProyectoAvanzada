package co.edu.uniquindio.proyectoAvanzada.repositorios;
import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {
    Optional<Administrador> findByEmailAdministrador(String correo);
}
