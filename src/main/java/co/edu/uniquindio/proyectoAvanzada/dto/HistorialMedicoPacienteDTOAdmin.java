package co.edu.uniquindio.proyectoAvanzada.dto;

import java.time.LocalDateTime;

public record HistorialMedicoPacienteDTOAdmin(

        LocalDateTime fechaInicial, LocalDateTime fechaFinal,
        LocalDateTime fecha, int idConsulta, LocalDateTime hora,
        String nombreMedico, int idMedico, String apellidoMedico, String telefonoMedico, String especialidadMedico,
        String nombrePaciente, String apellidoPaciente, int idPaciente, String telefonoPaciente, String emailPaciente,
        String detalle, int idMedicamento, String nombreMedicamento, int cantidadMedicamento



) {
}
