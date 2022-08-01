package com.vladislavgolovkin.vtb.Lesson11_HibernatePartOne;



import javax.persistence.*;


@Entity
@Table(name = "purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price_of_purchases")
    private int price;

    public Purchases() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                ", consumer=" + consumer.getId() +
                ", product=" + product.getId() +
                ", price=" + price +
                '}';
    }
}
