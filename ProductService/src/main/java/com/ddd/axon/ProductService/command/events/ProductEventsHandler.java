package com.ddd.axon.ProductService.command.events;

import com.ddd.axon.ProductService.command.data.Product;
import com.ddd.axon.ProductService.command.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductRegistrarEvent event){
        Product product = new Product();

        BeanUtils.copyProperties(event,product);
        productRepository.save(product);
    }
}
