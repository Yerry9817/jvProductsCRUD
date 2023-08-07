/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacy.farmacy.products;

import static java.lang.Boolean.TRUE;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

@RestController
@RequestMapping(path="api/v1/products")
public class ProductsController {
    private final ProductsService productsService;
    
    @Autowired
    //Inyectando productsService en ProductsController
    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }
    
    //Para poder usar los metodos del service
    @GetMapping
    public List<Product> getProductos(){
        //No da error porque productsService.getProducts() retorna una lista
        return productsService.getProducts();
    }
    
    
    @PostMapping("/add")
    //Necesario el @requestBody porque es una peticion Product  
    public ResponseEntity<Object> AddProduct(@RequestBody Product product){
        //llamar el metodo add en service
        return productsService.addProduct(product);
    }
    
    @PutMapping("/update")
    //Necesario el @requestBody porque es una peticion Product  
    public ResponseEntity<Object> UpdateProduct(@RequestBody Product product){
        //llamar el metodo add en service
        return productsService.updateProduct(product);
    }
    
    @DeleteMapping(path="delete/{productId}")
    //Necesario el @requestBody porque es una peticion Product  
    public ResponseEntity<Object> UpdateProduct(@PathVariable("productId") Long id){
        //llamar el metodo add en service
        return productsService.deleteProduct(id);
    }
}
