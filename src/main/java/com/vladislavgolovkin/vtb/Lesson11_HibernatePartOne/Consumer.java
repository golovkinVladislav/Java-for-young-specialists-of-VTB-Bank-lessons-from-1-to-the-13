package com.vladislavgolovkin.vtb.Lesson11_HibernatePartOne;



import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "consumer")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "consumer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Purchases> purchasesList;

    public Consumer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchases> purchasesList) {
        this.purchasesList = purchasesList;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasesList=" + purchasesList +
                '}';
    }
}
