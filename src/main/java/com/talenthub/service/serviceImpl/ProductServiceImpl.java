package com.talenthub.service.serviceImpl;


import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.dao.ProductDao;
import com.talenthub.dao.daoImpl.ProductDaoImpl;
import com.talenthub.model.Product;
import com.talenthub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private HibernateUtility<Product> uti = new HibernateUtility<Product>();


    @Transactional
    public void add(Product product) {
        uti.save(product);
    }

    @Transactional
    public void edit(Product product) {
        uti.update(product);
    }

    @Transactional
    public void delete(int Id) {
        uti.delete(Product.class,Id);
    }

    @Transactional
    public Product getProduct(int Id) {
        return uti.get(Product.class,Id);
    }

    @Transactional
    public List getAllProduct() {
        return uti.get(Product.class);
    }
}
