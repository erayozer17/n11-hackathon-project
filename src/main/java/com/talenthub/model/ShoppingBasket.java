package com.talenthub.model;

import javax.persistence.*;

/**
 * Created by user on 14/05/2017.
 */
@Entity
public class ShoppingBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch=FetchType.EAGER)
    Buyer buyer;
    @ManyToOne(fetch=FetchType.EAGER)
    Product product;

    public ShoppingBasket(){}

    public ShoppingBasket(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
