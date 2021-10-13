package com.arjunTechie.CURD.example.repository;

import com.arjunTechie.CURD.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {// model name is product and datatype is Integer primary key
    Product findByName(String name);

}
