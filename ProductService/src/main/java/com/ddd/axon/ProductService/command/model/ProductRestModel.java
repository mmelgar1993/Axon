package com.ddd.axon.ProductService.command.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRestModel {
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
}
