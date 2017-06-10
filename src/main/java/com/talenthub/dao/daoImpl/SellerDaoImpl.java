package com.talenthub.dao.daoImpl;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.dao.SellerDao;
import com.talenthub.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class SellerDaoImpl implements SellerDao {


    private SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
    @Override
    public void add(Seller seller) {
        sessionFactory.getCurrentSession().save(seller);
    }

    @Override
    public void edit(Seller seller) {
        sessionFactory.getCurrentSession().update(seller);
    }

    @Override
    public void delete(int Id) {
        sessionFactory.getCurrentSession().delete(getSeller(Id));
    }

    @Override
    public Seller getSeller(int Id) {
        return (Seller)sessionFactory.getCurrentSession().get(Seller.class, Id);
    }

    @Override
    public List getAllSeller() {
        return sessionFactory.getCurrentSession().createQuery("from  Seller").list();
    }
}
