package co.edu.uniquindio.proyectoAvanzada.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public enum TipoSangre {
    O_POSITIVO("O+"),
    A_NEGATIVO("A-"),
    O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"),
    B_POSITIVO("B+");

    private String nombre;
    TipoSangre(String nombre){
        this.nombre = nombre;

    }


}
