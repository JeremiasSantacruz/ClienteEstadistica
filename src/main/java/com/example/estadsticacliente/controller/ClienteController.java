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
@Tag(name = "Search API", description = "Count and save search realizated.")
public interface ClienteController {

    @PostMapping("/crearcliente")
    @Operation(summary = "Make a search.", description = "Endpoint to make and count same searchs.")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Search successfully", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "412", description = "Parameters validator errors", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error, support is required", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content) })

    ClienteResponseDto crearCliente(@Valid @RequestBody ClienteDto clienteDto);

    @GetMapping("/listclientes")
    Iterable<ClienteResponseDto> listarClientes(Pageable pageable);
}
