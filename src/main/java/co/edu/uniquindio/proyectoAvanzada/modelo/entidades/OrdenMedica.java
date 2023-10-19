package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class OrdenMedica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false,length = 10, unique = true)
    private int idOrdenMedica;

    @Column(nullable = false, length = 200)
    private String diagnostico;

    @Column(nullable = false, length = 200)
    private String tratamiento;

    @Column(nullable = false, length = 200)
    private String sintomasPaciente;

    @Column(nullable = false, length = 200)
    private String notaMedica;

    @ManyToOne
    private Cita citas;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;


    // mapped by va en la tabla no dependiente
    @OneToMany(mappedBy = "ordenMedica")
    private List<Medicamento> medicamentos;

    // mapped by va en la tabla no dependiente
    @OneToMany(mappedBy = "ordenMedica")
    private List<AutorizacionMedicamento> autorizacionMedicamentos;

}
