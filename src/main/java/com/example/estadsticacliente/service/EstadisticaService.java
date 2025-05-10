package com.example.estadsticacliente.service;

import com.example.estadsticacliente.domain.dto.EstadisticasDto;
import com.example.estadsticacliente.domain.entity.Estadistica;
import com.example.estadsticacliente.domain.mapper.EstadisticasMapper;
import com.example.estadsticacliente.domain.repository.EstadisticaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EstadisticaService {

    private final EstadisticaRepository estadisticaRepository;

    @Cacheable("estadisticas")
    public EstadisticasDto getDto() {
        var estadistica = getEstadistica();
        return EstadisticasMapper.toDto(estadistica);
    }

    @Cacheable("estadisticas")
    public Estadistica getEstadistica() {
        var estadistica = estadisticaRepository.findById(1L);
        if (estadistica.isEmpty()) {
            throw new IllegalStateException("No hay estadísticas registradas");
        }
        return estadistica.get();
    }

    @Async
    @CacheEvict("estadisitcas")
    public void nuevoDato(BigDecimal edadNuevoCliente) {
        var estadistica = getEstadistica();
        estadistica.agregarEdad(edadNuevoCliente);
        estadisticaRepository.save(estadistica);
    }

}
