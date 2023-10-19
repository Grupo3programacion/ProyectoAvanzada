package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Ciudad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Especialidad;
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
public class Medico implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false,length = 200, unique = true)
    private int idMedico;

    @Column(nullable = false, length = 200)
    private String emailMedico;

    @Column(nullable = false)
    private String contraseniaMedico;

    @Column(nullable = false, length = 200)
    private String nombreMedico;

    @Column(nullable = false, length = 200)
    private String apellidoMedico;

    @Column(nullable = false)
    private Ciudad ciudadMedico;

    @Column(nullable = false)
    private Especialidad especilidadMedico;

    @Column(nullable = false,length = 200)
    private String telefonoMedico;

    @Lob
    @Column(nullable = false)
    private String fotoMedico;

    @Column(nullable = false)
    private LocalDateTime diaLibre;

    //declaracion de la variable para relacionar de 1 a muchos, el mapped by va en nombre de la otra tabla en minuscula
    // donde este la llave foranea dentro del UML  va el mapped by
    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;

   // mapped by va en la tabla no dependiente
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<EntregaMedicamento> entregaMedicamentos;

    @OneToMany(mappedBy = "medico")
    private List<OrdenMedica> ordenMedica;

    @Column (length = 200)
    private boolean estado;


}
