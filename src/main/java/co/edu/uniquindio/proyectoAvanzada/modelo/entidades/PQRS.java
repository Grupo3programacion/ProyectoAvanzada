package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class PQRS implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(nullable = false, length = 10, unique = true)
    private int idPQRS;


    // mapped by va en la tabla no dependiente
    @OneToMany(mappedBy = "pqrs")
    private List<MensajePQRS> mensajePqrs;

    @ManyToOne
    private Cita cita;

    private LocalDateTime fechaCreacion;

    private String motivo;

    private String estado;

}
