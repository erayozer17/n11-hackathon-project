package com.talenthub.service.serviceImpl;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.model.Product;
import com.talenthub.service.BuyerService;

import java.util.List;

/**
 * Created by user on 14/05/2017.
 */
public class BuyerServiceImpl implements BuyerService{
    HibernateUtility<Product> hibernateUtility = new HibernateUtility<Product>();

    @Override
    public List<Product> search(List<String> keywords, String columnName) {
        return hibernateUtility.search(Product.class,keywords,columnName);
    }
}
