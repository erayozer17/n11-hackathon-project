package com.talenthub.service;

import com.talenthub.model.Product;

import java.util.List;


public interface ProductService {
    public void add(Product product);
    public void edit(Product product);
    public void delete(int Id);
    public Product getProduct(int Id);
    public List getAllProduct();
}
