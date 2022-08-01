package com.vladislavgolovkin.vtb.Lesson11_HibernatePartOne;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private int price;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Purchases> purchasesList;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchases> purchasesList) {
        this.purchasesList = purchasesList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", purchasesList=" + purchasesList +
                '}';
    }
}
