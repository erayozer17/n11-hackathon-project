package com.talenthub.dao;

import com.talenthub.model.Seller;
import java.util.*;


public interface SellerDao {
    public void add(Seller seller);
    public void edit(Seller seller);
    public void delete(int Id);
    public Seller getSeller(int Id);
    public List getAllSeller();
}
