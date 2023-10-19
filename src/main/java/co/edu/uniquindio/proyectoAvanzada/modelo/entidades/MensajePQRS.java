package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class MensajePQRS implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10, unique = true)
    private int id;

    @Column(nullable = false, length = 200)
    private String mensajePQRS;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private PQRS pqrs;

    private LocalDateTime fecha;
}
