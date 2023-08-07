/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farmacy.farmacy.products;

import java.util.Optional;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

//JpaRepository se le envia el tipo de dato del repository y el tipo de dato del ID
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product>findProductByName(String name);
}
