package com.talenthub.dao;

import com.talenthub.model.Product;

import java.util.List;


public interface ProductDao {
    public void add(Product product);
    public void edit(Product product);
    public void delete(int Id);
    public Product getProduct(int Id);
    public List getAllProduct();
}
