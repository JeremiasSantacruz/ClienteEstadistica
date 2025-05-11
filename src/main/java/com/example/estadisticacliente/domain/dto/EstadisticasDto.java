package com.example.estadisticacliente.domain.dto;

import java.math.BigDecimal;

public record EstadisticasDto(
        BigDecimal promedio,
        BigDecimal desviacionEstandar
) {
}
