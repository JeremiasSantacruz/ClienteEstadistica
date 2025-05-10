package com.example.estadsticacliente.domain.repository;

import com.example.estadsticacliente.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
