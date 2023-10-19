package co.edu.uniquindio.proyectoAvanzada.modelo.enums;

public enum TipoAlergia {

    ASMA("ASMA"),
    RENITIS("RENITIS"),
    DERMATITIS("DERMATITIS");
       private String nombre;
    TipoAlergia(String nombre){
        this.nombre = nombre;

    }

}
