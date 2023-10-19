package co.edu.uniquindio.proyectoAvanzada.repositorios;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaMedicamentosRepo extends JpaRepository<Medicamento,Integer> {
}
