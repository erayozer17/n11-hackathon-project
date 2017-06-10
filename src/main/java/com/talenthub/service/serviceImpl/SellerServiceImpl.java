package com.talenthub.service.serviceImpl;

import java.util.List;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.dao.SellerDao;
import com.talenthub.model.Product;
import com.talenthub.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talenthub.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    SellerDao sellerDao;
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


}
