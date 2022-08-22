package com.vladislavgolovkin.vtb.Lesson13_SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("cart")
public class Cart {
    private List<Product> list;

    @PostConstruct
    public void postConstruct(){
        list = new ArrayList<>();
    }

   public void add(Product product){
       list.add(product);
   }

    public List<Product> getList() {
        return list;
    }
}
