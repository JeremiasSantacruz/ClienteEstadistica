package com.example.estadsticacliente.controller.implementation;

import com.example.estadsticacliente.controller.EstadisticaController;
import com.example.estadsticacliente.domain.dto.EstadisticasDto;
import com.example.estadsticacliente.service.EstadisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
