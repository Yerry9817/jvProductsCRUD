package com.farmacy.farmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FarmacyApplication {
    public static void main(String[] args) {
            SpringApplication.run(FarmacyApplication.class, args);
    }
    
    @GetMapping("/Hola")
    public String hola(){
        return "Hola";
    }
}
