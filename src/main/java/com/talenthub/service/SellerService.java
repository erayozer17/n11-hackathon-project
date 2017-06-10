package com.talenthub.service;

import com.talenthub.model.Product;
import com.talenthub.model.Seller;
import java.util.*;

public interface SellerService {
    public void add(Product product);
    public void edit(Product product);
    public void delete(int Id);

}

