package com.example.estadisticacliente.domain.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClienteDto(
        @NotNull @Size(max = 40) String nombre,
        @NotNull @Size(max = 40) String apellido,
        @NotNull @Positive Integer edad,
        @NotNull @Past() LocalDate fechaDeNacimiento
) {
}
