package co.edu.uniquindio.proyectoAvanzada.dto;

public record RecuperarPasswordDTO (
        String emailPaciente,
        String codigoEmail,
        String nuevaContrasenia,
        String confirmarContrasenia
) {
}
