package com.supermarket.web.controller;

import com.supermarket.domain.Product;
import com.supermarket.domain.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public List<Product> getAll(){
    return productService.getAll();
  }

  @GetMapping("/{productId}")
  public Optional<Product> getProduct(@PathVariable("productId") int productId){
    return productService.getProduct(productId);
  }

  @GetMapping("/category/{categoryId}")
  public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
    return productService.getByCategory(categoryId);
  }

  @PostMapping("/save")
  public Product save(@RequestBody Product product){
    return productService.save(product);
  }

  @DeleteMapping("delete/{productId}")
  public boolean delete(@PathVariable("productId") int productId){
    return productService.delete(productId);
  }
}
