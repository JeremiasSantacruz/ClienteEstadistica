package com.example.estadisticacliente.domain.mapper;

import com.example.estadisticacliente.domain.dto.EstadisticasDto;
import com.example.estadisticacliente.domain.entity.Estadistica;

public class EstadisticasMapper {

    public static EstadisticasDto toDto(Estadistica estadistica) {
        return new EstadisticasDto(
                estadistica.getMedia(),
                estadistica.getDesviacionEstandar()
        );
    }
}
