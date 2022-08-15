package com.vladislavgolovkin.vtb.Lesson12_HibernatePartTwo;

import javax.persistence.*;

@Entity
@Table(name = "items",schema = "public")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "val")
    int value;
    @Version
    long version;

    public Item() {
    }

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", value=" + value +
                ", version=" + version +
                '}';
    }
}
