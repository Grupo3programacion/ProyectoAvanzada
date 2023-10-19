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
public class Administrador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int idAdministrador;

    @Column(nullable = false,length = 50, unique = true)
    private String emailAdministrador;

    @Column(nullable = false)
    private String contraseniaAdministrador;

    @Column(nullable = false, length = 50)
    private String nombreAdministrador;

    @Column(nullable = false, length = 50)
    private String apellidoAdministrador;

    @Column(nullable = false, length = 15)
    private String telefonoAdministrador;

    // mapped by va en la tabla no dependiente
    @OneToMany(mappedBy = "administrador")
    private List<MensajePQRS> mensajePqrsPQRS;

    @OneToMany(mappedBy = "administrador")
    private List<AutorizacionMedicamento> autorizacionMedicamentos;



}
