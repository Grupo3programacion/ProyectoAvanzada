package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class AutorizacionMedicamento implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAutorizacion;

    @ManyToOne
    private OrdenMedica ordenMedica;

    @ManyToOne
    private Administrador administrador;

    private Boolean estado;

    @ManyToOne
    private Paciente paciente;



}

