package com.pinApp.clientes.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class EstadisticasEdadDto {
    private BigDecimal promedio;
    private Double desvio;
}
