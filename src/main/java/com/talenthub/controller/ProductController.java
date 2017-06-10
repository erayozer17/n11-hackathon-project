package com.talenthub.controller;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.model.Product;
import com.talenthub.service.ProductService;
import com.talenthub.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ProductController {


    private ProductService productService = new ProductServiceImpl();


    @GetMapping(value="/product")
    public String test(Model model){

        Product product = new Product();

//        model.addAttribute("productList",uti.get(Product.class));
        model.addAttribute("productList", productService.getAllProduct());
        model.addAttribute("Product", new Product());


        return "productScreen";
    }

    @GetMapping(value="/product/{id}")
    public String showProduct(@PathVariable("id") int id,Model model){
        Product product=productService.getProduct(id);
        model.addAttribute("product",product);
        return "product";
    }


}
