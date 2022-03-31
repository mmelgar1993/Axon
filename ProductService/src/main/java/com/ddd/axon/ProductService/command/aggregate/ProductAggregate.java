package com.ddd.axon.ProductService.command.aggregate;

import com.ddd.axon.ProductService.command.commands.RegistrarProductCommand;
import com.ddd.axon.ProductService.command.events.ProductRegistrarEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;

    @CommandHandler
    public ProductAggregate(RegistrarProductCommand registrarProductCommand) {
        ProductRegistrarEvent productRegistrarEvent =  new ProductRegistrarEvent();

        BeanUtils.copyProperties(registrarProductCommand,productRegistrarEvent);

        AggregateLifecycle.apply(productRegistrarEvent);

    }

    public ProductAggregate() {
    }

    @EventSourcingHandler
    public void on(ProductRegistrarEvent productRegistrarEvent){
        this.nombre = productRegistrarEvent.getNombre();
        this.cantidad = productRegistrarEvent.getCantidad();
        this.productoId = productRegistrarEvent.getProductoId();
        this.precio = productRegistrarEvent.getPrecio();

    }
}
