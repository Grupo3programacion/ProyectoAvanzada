package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(nullable = false, length = 10, unique = true)
    private Integer idCita;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "citas")
    private List<OrdenMedica> ordenMedicas;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;

    @Column(nullable = false)
    private EstadoCita estadoCita;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 200)
    private String motivoConsulta;

}
