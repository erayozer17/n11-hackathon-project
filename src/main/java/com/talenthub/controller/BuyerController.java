package com.talenthub.controller;

import com.talenthub.controller.db.HibernateUtility;
import com.talenthub.model.Product;
import com.talenthub.service.BuyerService;
import com.talenthub.service.serviceImpl.BuyerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class BuyerController {

    BuyerService buyerService = new BuyerServiceImpl();
    List<String> keywords=new ArrayList<>();
    HibernateUtility<Product> hibernateUtility = new HibernateUtility<Product>();
    List<Product> searchRes = null;



    @RequestMapping(value = "/buyer")
    public String karsilama(Model model){
        model.addAttribute("productList",hibernateUtility.get(Product.class));
        return "buyerScreen";
    }


    @RequestMapping(value = "/search.do", method = RequestMethod.POST)
    public String ara(Model model, @RequestParam("selection") String selection, @RequestParam("query") String query){

        String[] arananlar = query.split(" ");

        if(query == null || selection == null){

        }

        for (String aranan:arananlar) {
            keywords.add(aranan);
        }


        if (selection.equals("title")) {
            searchRes = buyerService.search(keywords, "title");
        }
        else if (selection.equals("subtitles")) {
            searchRes = buyerService.search(keywords, "subtitles");
        }
        else {
            searchRes = buyerService.search(keywords, "category");
        }

        model.addAttribute("searchRes",searchRes);

        model.addAttribute("productList",hibernateUtility.get(Product.class));
        keywords.clear();

        return "buyerScreen";
    }

}