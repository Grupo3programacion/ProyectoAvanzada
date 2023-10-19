package co.edu.uniquindio.proyectoAvanzada.repositorios;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<PQRS,Integer> {

    List<PQRS> findAllByCitaPacienteIdPaciente(int idPaciente);
}
