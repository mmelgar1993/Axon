package com.ddd.axon.ProductService.command.controller;

import com.ddd.axon.ProductService.command.commands.RegistrarProductCommand;
import com.ddd.axon.ProductService.command.model.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel productRestModel){
        RegistrarProductCommand registrarProductCommand = RegistrarProductCommand.builder()
                .productoId(UUID.randomUUID().toString())
                .nombre(productRestModel.getNombre())
                .precio(productRestModel.getPrecio())
                .cantidad(productRestModel.getCantidad())
                .build();
        String resultado = commandGateway.sendAndWait(registrarProductCommand);
        return resultado;
    }
}
