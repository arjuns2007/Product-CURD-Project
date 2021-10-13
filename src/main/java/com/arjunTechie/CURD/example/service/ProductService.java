package com.arjunTechie.CURD.example.service;

import com.arjunTechie.CURD.example.entity.Product;
import com.arjunTechie.CURD.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // productService talk to repository
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//post method()
    //    Autowiring-enables to inject the object dependency implicitly.
//    It internally uses setter or constructor injection.
//    Autowiring can't be used to inject primitive and string values.
    public Product saveProduct(Product product){ // Product object is entity product
//        return  productRepository.save(product); // one product save at a time; is in-built method by given by Jpa repository
        return productRepository.save(product);

    }

    public List<Product> saveProducts(List<Product> products){ // SaveAll product in one time.
        return productRepository.saveAll(products);
    }

//Three Get method()
//Fetching the all products one time
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

//    Fetching the single product one time
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

//   Fetching the single product one time
    public Product getProductByName(String name){
       return productRepository.findByName(name);
    }

//    Delete method
    public String deleteProduct(int id){
       productRepository.deleteById(id);
       return "You successfully removed the product by using its ID !!!" + id;
    }
//Update product
//    You can update the product info from existing product, first fetch the product which was already saved.
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setId(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

}
