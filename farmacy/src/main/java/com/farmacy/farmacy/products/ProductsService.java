/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacy.farmacy.products;

import static java.lang.Boolean.TRUE;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */
@Service
public class ProductsService {
    
    //a service se le inyecta el repository para usar los metodos del interface
    @Autowired
    private ProductRepository productRepository;

    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    
    //Methods
    
    //Objeto de mensaje del servidor
    public HashMap<String,Object> datos;
    
    //Repository contiene los metodos basicos de add, select, update, delete
    
    //obtener productos
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    
    //Response entity es para retornar alertas de servidor 
    public ResponseEntity<Object> addProduct(Product product){
        Optional res= productRepository.findProductByName(product.getName());
        
        //Es el objeto a retornar con el mensaje
        datos = new HashMap<>();
        if(res.isPresent()){
            datos.put("error", TRUE);
            datos.put("mensaje", "Product already exist!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.save(product);
        datos.put("Success", TRUE);
            datos.put("mensaje", "Product saved correctly!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );
    }
    
    //update method
    public ResponseEntity<Object> updateProduct(Product product){
        Optional res= productRepository.findById(product.getId());
        
        //Es el objeto a retornar con el mensaje
        datos = new HashMap<>();
        if(res.isPresent()){
            productRepository.save(product);
            datos.put("Success", TRUE);
            datos.put("mensaje", "Product updated correctly!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );
        }
        datos.put("error", TRUE);
        datos.put("mensaje", "Product doesnt exist!");
        return new ResponseEntity<>(
                datos,
                HttpStatus.NOT_FOUND
        );
    }
    
    public ResponseEntity<Object> deleteProduct(Long id){
        Optional res= productRepository.findById(id);
        
        //datos Es el objeto a retornar con el mensaje
        datos = new HashMap<>();
        if(res.isPresent()){
            productRepository.deleteById(id);
            datos.put("Success", TRUE);
            datos.put("mensaje", "Product deleted correctly!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );
        }
        datos.put("error", TRUE);
            datos.put("mensaje", "Product doesnt exist!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );
    }
}
