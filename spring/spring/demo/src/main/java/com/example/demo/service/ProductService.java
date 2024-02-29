package com.example.demo.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    public boolean postall(Product product)
    {
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public List<Product> getall()
    {
        return productRepo.findAll();
    }

    public Product getallId(int product_id)
    {
        return productRepo.findById(product_id).orElse(null);
    }

    public List<Product> getSortedList(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

     public List<Product> getPageList(int offset, int pagesize) {
        Page<Product> k = productRepo.findAll(PageRequest.of(offset, pagesize));
        return k.getContent();
    }
}

