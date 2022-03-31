package com.ddd.axon.ProductService.command.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
}
