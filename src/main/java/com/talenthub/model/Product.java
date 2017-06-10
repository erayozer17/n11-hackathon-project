package com.talenthub.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by user on 13/05/2017.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String subtitle;
    @ManyToOne(fetch=FetchType.EAGER)
    private Seller seller;
    private BigDecimal price;
    private String category;
    private BigDecimal disCount;

    public Product(){}

    public Product(String title, String subtitle, Seller seller, BigDecimal price, String category, BigDecimal disCount) {
        this.title = title;
        this.subtitle = subtitle;
        this.seller = seller;
        this.price = price;
        this.category = category;
        this.disCount = disCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDisCount() {
        return disCount;
    }

    public void setDisCount(BigDecimal disCount) {
        this.disCount = disCount;
    }
}
