package com.example.estadisticacliente.controller.implementation;

import com.example.estadisticacliente.controller.EstadisticaController;
import com.example.estadisticacliente.domain.dto.EstadisticasDto;
import com.example.estadisticacliente.service.EstadisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstadisticaControllerImp implements EstadisticaController {

    private final EstadisticaService estadisticaService;

    @Override
    public EstadisticasDto getEstadistica() {
        return estadisticaService.getDto();
    }

}
