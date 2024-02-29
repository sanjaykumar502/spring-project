package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product product) {
        if(productService.postall(product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(product,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> k = productService.getall();
        if(k.size()==0)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(k,HttpStatus.CREATED);
    }
    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> getMethodNameId(@PathVariable int product_id) {
        Product k = productService.getallId(product_id);
        if(k==null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(k,HttpStatus.CREATED);
    }

    @GetMapping("/sortBy/{field}")
    public List<Product> sortByRate(@PathVariable("field") String field) {
        return productService.getSortedList(field);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    public List<Product> getMethodName1(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) {
        return productService.getPageList(offset,pagesize);
    }
    
}


