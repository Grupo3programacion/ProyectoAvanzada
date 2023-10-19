package co.edu.uniquindio.proyectoAvanzada.repositorios;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.AutorizacionMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacionMedicamentoRepo extends JpaRepository<AutorizacionMedicamento,Integer> {
}
