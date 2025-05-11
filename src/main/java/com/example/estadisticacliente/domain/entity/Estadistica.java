package com.example.estadisticacliente.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estadistica {
    @Id
    Long id = 1L;
    BigDecimal media = BigDecimal.ZERO;
    BigDecimal varianza = BigDecimal.ZERO;
    BigDecimal desviacionEstandar = BigDecimal.ZERO;
    BigDecimal desviacion;
    BigDecimal suma = BigDecimal.ZERO;
    BigDecimal sumaDeCuadrados = BigDecimal.ZERO;
    BigDecimal numeroDeClientes = BigDecimal.ZERO;

    public void agregarEdad(BigDecimal edadNuevoCliente) {
        // Calculamos las bases
        suma = suma.add(edadNuevoCliente);
        sumaDeCuadrados = sumaDeCuadrados.add(edadNuevoCliente.pow(2));
        numeroDeClientes = numeroDeClientes.add(BigDecimal.ONE);

        if (numeroDeClientes.compareTo(BigDecimal.ZERO) > 0) {
            media = suma.divide(numeroDeClientes, 2, RoundingMode.HALF_UP);
        } else {
            media = BigDecimal.ZERO;
        }

        if (numeroDeClientes.compareTo(BigDecimal.ONE) > 0) {
            BigDecimal numerador = sumaDeCuadrados.subtract(suma.pow(2).divide(numeroDeClientes, 10, RoundingMode.HALF_UP));
            varianza = numerador.divide(numeroDeClientes.subtract(BigDecimal.ONE), 10, RoundingMode.HALF_UP);
            desviacionEstandar = new BigDecimal(Math.sqrt(varianza.doubleValue())).setScale(2, RoundingMode.HALF_UP);
        } else {
            varianza = BigDecimal.ZERO;
            desviacionEstandar = BigDecimal.ZERO;
        }

        this.desviacion = edadNuevoCliente.subtract(media);
    }

}
