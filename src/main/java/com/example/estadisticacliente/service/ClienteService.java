package com.example.estadisticacliente.service;

import com.example.estadisticacliente.domain.dto.ClienteDto;
import com.example.estadisticacliente.domain.dto.ClienteResponseDto;
import com.example.estadisticacliente.domain.mapper.ClienteMapper;
import com.example.estadisticacliente.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final EstadisticaService estadisticaService;

    @Value("${estadisticas.esperanzaDeVida}")
    private Long esperanzaDeVida;

    public ClienteResponseDto crearCliente(ClienteDto clienteDto) {
        int edad = Period.between(clienteDto.fechaDeNacimiento(), LocalDate.now()).getYears();
        if (edad != clienteDto.edad()) {
            String msg = String.format("La edad del cliente no coincide con la fecha de nacimiento. Esperado %s Actual %s", edad, clienteDto.edad());
            throw new IllegalArgumentException(msg);
            // TODO: Ver manejo de errores
        }
        var response = clienteRepository.save(ClienteMapper.toEntity(clienteDto, esperanzaDeVida));
        estadisticaService.nuevoDato(BigDecimal.valueOf(edad)); // Async
        return ClienteMapper.toResponse(response);
    }

    public Page<ClienteResponseDto> listarClientes(Pageable page) {
        return clienteRepository.findAll(page).map(ClienteMapper::toResponse);
    }

}
