package com.ddd.axon.ProductService.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegistrarEvent {

    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
}
