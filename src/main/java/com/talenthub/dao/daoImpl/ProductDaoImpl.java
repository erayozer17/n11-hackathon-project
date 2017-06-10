package com.talenthub.dao.daoImpl;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.dao.ProductDao;
import com.talenthub.model.Product;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
    @Override
    public void add(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void edit(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(int Id) {
        sessionFactory.getCurrentSession().delete(getProduct(Id));
    }

    @Override
    public Product getProduct(int Id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, Id);
    }

    @Override
    public List getAllProduct() {
        return sessionFactory.getCurrentSession().createQuery("from  Product").list();
    }
}
