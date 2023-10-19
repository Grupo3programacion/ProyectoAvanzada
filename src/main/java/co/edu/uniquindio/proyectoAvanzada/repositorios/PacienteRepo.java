package co.edu.uniquindio.proyectoAvanzada.repositorios;

import co.edu.uniquindio.proyectoAvanzada.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
Optional<Paciente> findByEmaiLPaciente(String emailPaciente);
}
