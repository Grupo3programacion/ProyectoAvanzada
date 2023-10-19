package co.edu.uniquindio.proyectoAvanzada.dto;

public record MensajeDTO<T> (
        boolean error,
        T respuesta
){
}
