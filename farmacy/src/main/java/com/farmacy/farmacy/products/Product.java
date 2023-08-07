/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacy.farmacy.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer price;
    private Boolean isStock;

    
    //constructor sin parametros para crear un producto enviandole los valores uno a la vez
    public Product() {
    }
    
    //constructor con parametros menos id, para crear un producto haciendo el id autoincremental
    public Product(String name, Integer price, Boolean isStock) {
        this.name = name;
        this.price = price;
        this.isStock = isStock;
    }
    
    //constructor con todos los parametos enviando el id para hacer actualizaciones
    public Product(Long id, String name, Integer price, Boolean isStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isStock = isStock;
    }
    
    
    //get and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getIsStock() {
        return isStock;
    }

    public void setIsStock(Boolean isStock) {
        this.isStock = isStock;
    }
}
