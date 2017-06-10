package com.talenthub.model;

import com.talenthub.controller.db.HibernateUtility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 13/05/2017.
 */
public class test {

    public static void main(String args[]){

        Seller seller = new Seller("Enver","Evci");
        HibernateUtility<Seller> hibernateUtility = new HibernateUtility<Seller>();
        HibernateUtility<Product> hibernateUtility2 = new HibernateUtility<Product>();

        HibernateUtility<Buyer> hibernateUtility1 = new HibernateUtility<Buyer>();
        HibernateUtility<ShoppingBasket> hibernateUtility3 = new HibernateUtility<ShoppingBasket>();
        hibernateUtility.save(seller);

        Product product = new Product("tasd","asd",seller,new BigDecimal(3),"asd",new BigDecimal(2));

        hibernateUtility2.save(product);

        Product pro2=hibernateUtility2.get(Product.class,22);
        System.out.println(pro2.getTitle());
        //hibernateUtility2.delete(Product.class,22);
        List<String> keywords=new ArrayList<>();
        keywords.add("OO");
        List<Product> searchRes=hibernateUtility2.search(Product.class,keywords,"category");
        for (Product res: searchRes
             ) {
            System.out.println(res.getCategory());
        }
        ShoppingBasket basket=new ShoppingBasket(hibernateUtility1.get(Buyer.class,2));
        basket.setProduct(searchRes.get(0));
        hibernateUtility3.save(basket);
        HashMap<String,String> map=new HashMap<>();

        map.put("buyer_id","2");
        List<ShoppingBasket> res=hibernateUtility3.get(ShoppingBasket.class,map);
        for (ShoppingBasket res1: res
                ) {
            System.out.println(res1.getProduct().getCategory());
        }
    }
}
