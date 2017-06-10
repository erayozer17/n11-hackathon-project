package com.talenthub.controller;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.model.Product;
import com.talenthub.service.serviceImpl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.talenthub.model.Seller;
import com.talenthub.service.SellerService;

@org.springframework.stereotype.Controller
public class SellerController {

    private SellerService sellerService = new SellerServiceImpl();

    private HibernateUtility<Seller> hibernateUtility = new HibernateUtility<Seller>();
    private HibernateUtility<Product> uti = new HibernateUtility<Product>();

    @RequestMapping(value="/seller")
    public String test(@RequestParam(value="name", required=false) String name, Model model){
        model.addAttribute("Product", new Product());
        return "sellerScreen";
    }


    @RequestMapping(value="/seller.do", method = RequestMethod.POST)
    public String productUtilities(@ModelAttribute Product product, BindingResult result, @RequestParam String action,@RequestParam("seller") String sellerID, Model model){
        Product productResult = new Product();

        switch(action.toLowerCase()){
            case "add":
                product.setSeller(hibernateUtility.get(Seller.class,Integer.parseInt(sellerID)));
                sellerService.add(product);
                break;
            case "edit":
                sellerService.edit(product);
                break;
            case "delete":
                sellerService.delete(product.getId());

        }
        model.addAttribute("productList", uti.get(Product.class));
        model.addAttribute("Product", new Product());
        return "productScreen";
    }


}
