package com.example.estadisticacliente.domain.repository;

import com.example.estadisticacliente.domain.entity.Estadistica;
import org.springframework.data.repository.CrudRepository;

public interface EstadisticaRepository extends CrudRepository<Estadistica, Long> {
}
