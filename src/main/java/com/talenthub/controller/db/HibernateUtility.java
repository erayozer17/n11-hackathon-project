package com.talenthub.controller.db;

import com.talenthub.model.Seller;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;

/**
 * Created by user on 13/05/2017.
 */
public class HibernateUtility <T>{

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtility.class);
    private SessionFactory sessionFactory;

    public HibernateUtility(){
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();

        return sessionFactory;

    }


    public void save(T obj){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + obj.toString());

    }

    public void update(T obj){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + obj.toString());

    }


    public <T> List<T> get(Class<T> clazz) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<T> objs=new ArrayList<T>();
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM "+clazz.getSimpleName();
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(clazz);
            objs =(List<T>) query.list();


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return objs;
        }
    }


    public <T> T get(Class<T> clazz,int id){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<T> objs=new ArrayList<T>();
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM "+clazz.getSimpleName() +" where id="+id;
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(clazz);
            objs =(List<T>) query.list();


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return objs.get(0);
        }
    }

    public <T> List<T> get(Class<T> clazz, Map<String,String> parameters){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<T> objs=new ArrayList<T>();
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM "+clazz.getSimpleName() +" where ";
            for (Iterator<Map.Entry<String,String>> iterator = parameters.entrySet().iterator(); iterator.hasNext(); iterator.next()){

                Map.Entry<String,String> entry=iterator.next();
                        sql+=entry.getKey()+"='"+entry.getValue() +"' and ";
                        if(!iterator.hasNext()) break;
            }
            sql=sql.substring(0,sql.length()-4);
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(clazz);
            objs =(List<T>) query.list();



            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return objs;
        }
    }

    public <T> void delete(Class<T> clazz,int id){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("delete "+clazz.getSimpleName() +" where id = :id");
            query.setParameter("id", id);
            int result = query.executeUpdate();
            tx.commit();

        }catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public <T> List<T> search(Class<T> clazz,List<String> keywords, String columnName){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<T> objs=new ArrayList<T>();
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM "+clazz.getSimpleName()+ " WHERE ";
            for (String keyword: keywords) {
                sql+=columnName+" LIKE '%"+keyword +"%' OR";
            }
            sql=sql.substring(0,sql.length()-2);

            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(clazz);
            objs =(List<T>) query.list();


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return objs;
        }
    }


}
