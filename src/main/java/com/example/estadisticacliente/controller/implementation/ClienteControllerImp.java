package com.example.estadisticacliente.controller.implementation;

import com.example.estadisticacliente.controller.ClienteController;
import com.example.estadisticacliente.domain.dto.ClienteDto;
import com.example.estadisticacliente.domain.dto.ClienteResponseDto;
import com.example.estadisticacliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImp implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ClienteResponseDto crearCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.crearCliente(clienteDto);

    }

    @Override
    public Page<ClienteResponseDto> listarClientes(Pageable pageable) {
        return clienteService.listarClientes(pageable);
    }
}
