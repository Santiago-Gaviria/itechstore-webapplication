package com.itechstore.platform.controller;

import com.itechstore.platform.model.Product;
import com.itechstore.platform.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import jakarta.validation.Valid;


@RestController

@RequestMapping("/api/products")//Endpoint API
public class controllerProduct {
    @Autowired
    private ServiceProduct serviceProduct;

    //GetMapping: Sirve para listar o consultar 
    @GetMapping
    public List<Product> getListProduct() {
        return serviceProduct.getAll();

    }

     //Para este metodo se le asigna una etiqueta '@PostMapping con id', esto se hace
    //para ubicar el producto al cual se quiere acceder para registrar y/o crear sus datos.
    @PostMapping
    public Product createNewProduct(@Valid@RequestBody Product product) {
        return serviceProduct.saveProduct(product);
    }

     //Para este metodo se le asigna una etiqueta '@DeleteMapping con id', esto se hace
    //para ubicar el producto al cual se quiere acceder para eliminar sus datos.
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        serviceProduct.deleteProduct(id);
        return "EL producto con el id: " +id+" fue eliminado correctamente. ";
    }

    //Para este metodo se le asigna una etiqueta '@PutMapping con id', esto se hace
    //para ubicar el producto al cual se quiere acceder para actualizar sus datos.
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @RequestBody Product productData){
        serviceProduct.updateProduct(id,productData);

        return "El producto con el id: " + id+ "ha sido actualizado con exito. ";

    }
     //Para este metodo se le asigna una etiqueta '@GetMapping con id', esto se hace
    //para ubicar el producto al cual se quiere acceder para actualizar sus datos.
    @GetMapping("/stock/{cantidad}")
    public List<Product>getProductsByStock(@PathVariable Integer quantity){
        return serviceProduct.getProductsByStock(quantity);

    }
    


    



}
