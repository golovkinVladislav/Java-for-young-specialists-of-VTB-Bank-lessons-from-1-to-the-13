package com.vladislavgolovkin.vtb.Lesson13_SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderService")
public class OrderService {
    @Autowired
    private Cart cart;

    public void showAllOrders(){
        List<Product> list = cart.getList();
        for (Product p : list){
            System.out.println("Name: " +p.getTitle() + " cost: " + p.getCost());
        }
        System.out.println("Total amount " + list.stream().mapToInt(p->p.getCost()).sum());
    }
}
