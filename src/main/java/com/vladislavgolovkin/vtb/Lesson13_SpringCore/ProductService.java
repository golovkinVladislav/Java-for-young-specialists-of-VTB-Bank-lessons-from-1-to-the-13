package com.vladislavgolovkin.vtb.Lesson13_SpringCore;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component("productService")
public class ProductService {
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public void printAll(){
        productList.stream().forEach(System.out::print);
    }

    public Product findBTitle(String title){
        return productList.stream().filter(a->a.getTitle().equals(title)).findFirst().orElseThrow(RuntimeException::new);
    }


    @PostConstruct
    public void postConstruct(){
        Product product1 = new Product(1,"Apple",50);
        Product product2 = new Product(2,"Orange",60);
        Product product3 = new Product(3,"Nuts",70);
        Product product4 = new Product(4,"Chocolate",40);
        Product product5 = new Product(5,"Milk",50);
        Product product6 = new Product(6,"Peach",80);
        Product product7 = new Product(7,"Strawberry",110);
        Product product8 = new Product(8,"Cherry",90);
        Product product9 = new Product(9,"Lemon",70);
        Product product10 = new Product(10,"Pineapple",150);
        this.productList.add(product1);
        this.productList.add(product2);
        this.productList.add(product3);
        this.productList.add(product4);
        this.productList.add(product5);
        this.productList.add(product6);
        this.productList.add(product7);
        this.productList.add(product8);
        this.productList.add(product9);
        this.productList.add(product10);

    }
}
