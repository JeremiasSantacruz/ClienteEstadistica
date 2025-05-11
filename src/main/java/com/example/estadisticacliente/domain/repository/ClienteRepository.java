package com.example.estadisticacliente.domain.repository;

import com.example.estadisticacliente.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
