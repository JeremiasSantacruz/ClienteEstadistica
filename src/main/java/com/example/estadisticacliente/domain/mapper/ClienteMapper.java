package com.example.estadisticacliente.domain.mapper;

import com.example.estadisticacliente.domain.dto.ClienteDto;
import com.example.estadisticacliente.domain.dto.ClienteResponseDto;
import com.example.estadisticacliente.domain.entity.Cliente;

public class ClienteMapper {

    public static ClienteDto toDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEdad(),
                cliente.getFechaDeNacimiento()
        );
    }

    public static ClienteResponseDto toResponse(Cliente cliente) {
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEdad(),
                cliente.getFechaDeNacimiento(),
                cliente.getFechaEstimadaDeMuerte()
        );
    }

    public static Cliente toEntity(ClienteDto clienteDto, Long maxAge) {
        return new Cliente(
                null, //No se soporta actualizaciones
                clienteDto.nombre(),
                clienteDto.apellido(),
                clienteDto.edad(),
                clienteDto.fechaDeNacimiento(),
                clienteDto.fechaDeNacimiento().plusYears(maxAge)
        );
    }
}
