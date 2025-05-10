package com.example.estadsticacliente.domain.dto;

import java.math.BigDecimal;

public record EstadisticasDto(
        BigDecimal promedio,
        BigDecimal desviacionEstandar
) {
}
