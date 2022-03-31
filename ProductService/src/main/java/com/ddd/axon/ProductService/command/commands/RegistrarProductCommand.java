package com.ddd.axon.ProductService.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class RegistrarProductCommand {
    @TargetAggregateIdentifier
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
}
