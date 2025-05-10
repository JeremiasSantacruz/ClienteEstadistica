package com.example.estadsticacliente.controller.implementation;

import com.example.estadsticacliente.controller.ClienteController;
import com.example.estadsticacliente.domain.dto.ClienteDto;
import com.example.estadsticacliente.domain.dto.ClienteResponseDto;
import com.example.estadsticacliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImp implements ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crearcliente")
    @Override
    public ClienteResponseDto crearCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.crearCliente(clienteDto);

    }

    @GetMapping("/listclientes")
    @Override
    public Iterable<ClienteResponseDto> listarClientes(Pageable pageable){
        return clienteService.listarClientes(pageable);
    }
}
