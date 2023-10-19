package co.edu.uniquindio.proyectoAvanzada.modelo.entidades;

import co.edu.uniquindio.proyectoAvanzada.modelo.enums.Ciudad;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.EPS;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.TipoAlergia;
import co.edu.uniquindio.proyectoAvanzada.modelo.enums.TipoSangre;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.expression.spel.ast.NullLiteral;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Paciente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false,length = 15, unique = true)
    private Integer idPaciente;

    private boolean estado;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private List<EntregaMedicamento> entregaMedicamentos;

    @OneToMany(mappedBy = "paciente")
    private List<OrdenMedica> ordenMedica;


    @OneToMany(mappedBy = "paciente")
    private List<AutorizacionMedicamento> autorizacionMedicamentos;

    @Column(nullable = false, unique = true)
    private String emaiLPaciente;

    @Column(nullable = false)
    private String contraseniaPaciente;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private String apellidoPaciente;

    @Column(nullable = false)
    private LocalDateTime fecheNacimiento;

    @Column(nullable = false, length = 20)
    private int telefonoPaciente;

    @Column(nullable = false)
    private EPS epsPaciente;

    @Column(nullable = false)
    private TipoSangre tipoSangre;

    @Column(nullable = false)
    private Ciudad ciudadPaciente;

    @Lob
    @Column(nullable = false)
    private String fotoPaciente;

    @Column(nullable = false)
    private TipoAlergia tipoAlergia;

}
