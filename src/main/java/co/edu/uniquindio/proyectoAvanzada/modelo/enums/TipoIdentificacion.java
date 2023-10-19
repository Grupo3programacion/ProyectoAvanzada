package co.edu.uniquindio.proyectoAvanzada.modelo.enums;

public enum TipoIdentificacion {

    CEDULA_CIUDADANIA("CEDULA CIUDADANÍA"),
    CEDULA_EXTRANJERIA("CEDULA EXTRANJERÍA"),
    DOCUMENTO_IDENTIDAD("DOCUEMENTO IDENTIDAD"),
    PASAPORTE("PASAPORTE");

    private String nombre;
    TipoIdentificacion(String nombre){
        this.nombre = nombre;

}
}
