package com.example.estadisticacliente.service;

import com.example.estadisticacliente.domain.dto.EstadisticasDto;
import com.example.estadisticacliente.domain.entity.Estadistica;
import com.example.estadisticacliente.domain.mapper.EstadisticasMapper;
import com.example.estadisticacliente.domain.repository.EstadisticaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstadisticaService {

    private final EstadisticaRepository estadisticaRepository;

    public EstadisticasDto getDto() {
        var estadistica = getEstadistica();
        return EstadisticasMapper.toDto(estadistica);
    }

    public Estadistica getEstadistica() {
        var estadistica = estadisticaRepository.findById(1L);
        return estadistica.orElseGet(() -> estadisticaRepository.save(new Estadistica()));
    }

    @Async // Se puede hacer mejor con un manejador custmon
    public void nuevoDato(BigDecimal edadNuevoCliente) {
        var estadistica = getEstadistica();
        log.info("Agregando edad: {}", edadNuevoCliente);
        log.info("Estadistica: {}", estadistica);
        estadistica.agregarEdad(edadNuevoCliente);
        estadisticaRepository.save(estadistica);
    }

}
