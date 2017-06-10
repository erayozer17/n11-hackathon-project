package com.talenthub.service;

import com.talenthub.model.Product;

import java.util.List;


public interface BuyerService {
    public List<Product> search(List<String> keywords,String columnName);
}
