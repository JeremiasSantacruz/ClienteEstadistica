package com.example.estadsticacliente.domain.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClienteResponseDto(
        Long id,
        @NotNull @Size(max = 40) String nombre,
        @NotNull @Size(max = 40) String apellido,
        @NotNull @Positive Integer edad,
        @NotNull @Past() LocalDate fechaDeNacimiento,
        @NotNull LocalDate fechaEstimadaDeMuerte
) {
}
