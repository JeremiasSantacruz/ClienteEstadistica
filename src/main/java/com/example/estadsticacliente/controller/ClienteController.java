package com.example.estadsticacliente.controller;

import com.example.estadsticacliente.domain.dto.ClienteDto;
import com.example.estadsticacliente.domain.dto.ClienteResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Clientes API", description = "Endpoint para manipular los clientes")
public interface ClienteController {

    @PostMapping("/crearcliente")
    @Operation(summary = "Crear un cliente.", description = "Crear un cliente en la base de datos.")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Crea un cliente.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "412", description = "Parametros incorrectos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error, support is required", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content) })
    ClienteResponseDto crearCliente(@Valid @RequestBody ClienteDto clienteDto);

    @GetMapping("/listclientes")
    @Operation(summary = "Devuelve una Lista de clientes.", description = "Obtiene una lista de los clientes registrados.")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Crea un cliente.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "412", description = "Parametros incorrectos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error, support is required", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content) })
    Iterable<ClienteResponseDto> listarClientes(Pageable pageable);
}
