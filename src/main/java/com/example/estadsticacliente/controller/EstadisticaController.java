package com.example.estadsticacliente.controller;

import com.example.estadsticacliente.domain.dto.EstadisticasDto;
import com.example.estadsticacliente.service.EstadisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstadisticaController {

    private final EstadisticaService estadisticaService;

    @GetMapping("/kpideclientes")
    public EstadisticasDto getEstadistica() {
        return estadisticaService.getDto();
    }

}
