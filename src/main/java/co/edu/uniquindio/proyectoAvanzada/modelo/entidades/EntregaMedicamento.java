package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EntregaMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,length = 10, unique = true)
    private int id;

    @Column(nullable = false, length = 20)
    private String direccionEntrega;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medicamento medicamento;

    @ManyToOne
    private Medico medico;
}
