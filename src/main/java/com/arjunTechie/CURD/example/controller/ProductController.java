package com.arjunTechie.CURD.example.controller;

import com.arjunTechie.CURD.example.entity.Product;
import com.arjunTechie.CURD.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Spring RestController annotation is used to create RESTful web services using Spring MVC.
// Spring RestController takes care of mapping request data to the defined request handler method.
// Once response body is generated from the handler method, it converts it to JSON or XML response.

public class ProductController { // controller is talking to the service class.
//    now inject service in controller class
    @Autowired
    private ProductService service;

    //Post API
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

// Get API
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
        }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

//    Put  or update Mapping
    @PutMapping("/update") // requesting
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

//    Deleting product
    @DeleteMapping("/delete/{id}")
//    @PathVariable It is used to pass parameter along with the url,
//    sometimes we need to pass parameters along with the url to get the data.
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
