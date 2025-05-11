package com.example.estadisticacliente.controller;

import com.example.estadisticacliente.domain.dto.EstadisticasDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Estadistica API", description = "Endpoint para obtener las estadisiticas de los clientes")
public interface EstadisticaController {

    @GetMapping("/kpideclientes")
    @Operation(summary = "Obtiene las estadisticas de los clientes", description = "Obtiene las estadisticas de los clientes.")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Crea un cliente.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "412", description = "Parametros incorrectos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error, support is required", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content) })
    EstadisticasDto getEstadistica();

}
