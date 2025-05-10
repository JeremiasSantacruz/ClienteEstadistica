package com.example.estadsticacliente.domain.mapper;

import com.example.estadsticacliente.domain.dto.EstadisticasDto;
import com.example.estadsticacliente.domain.entity.Estadistica;

public class EstadisticasMapper {

    public static EstadisticasDto toDto(Estadistica estadistica) {
        return new EstadisticasDto(
                estadistica.getMedia(),
                estadistica.getDesviacionEstandar()
        );
    }
}
