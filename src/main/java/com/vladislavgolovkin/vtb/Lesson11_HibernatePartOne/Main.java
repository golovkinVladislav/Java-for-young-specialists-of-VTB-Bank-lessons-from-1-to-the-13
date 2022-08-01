package com.vladislavgolovkin.vtb.Lesson11_HibernatePartOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

/*
1. В базе данных необходимо иметь возможность хранить информацию о покупателях (id, имя)
и товарах (id, название, стоимость);
2. У каждого покупателя свой набор купленных товаров, одна покупка одного товара это
отдельная запись в таблице (группировать не надо);
3. Написать тестовое консольное приложение (просто Scanner и System.out.println()), которое
позволит выполнять команды:
/showProductsByPerson имя_покупателя - посмотреть какие товары покупал клиент;
/findPersonsByProductTitle название_товара - какие клиенты купили определенный товар;
/removePerson(removeProduct) имя_элемента - предоставить возможность удалять из базы
товары/покупателей,
/buy имя_покупателя название_товара - организовать возможность “покупки товара”.
4. * Добавить детализацию по паре покупатель-товар: сколько стоил товар, в момент покупки
клиентом;
Заметка: желательно все таблицы создать “вручную” и приложить скрипты создания.
*/
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Consumer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Purchases.class)
                .buildSessionFactory();
        Session session = null;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter command: ");
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    session = sessionFactory.getCurrentSession();
                    System.out.println("Exit!!!");
                    break;
                }
                String[] commands = command.split(" ");
                switch (commands[0]) {
                    case "/buy":
                        session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Consumer consumer = (Consumer) session.createQuery("FROM Consumer c WHERE c.name = :name")
                                .setParameter("name", commands[1]).getSingleResult();
                        Product product = (Product) session.createQuery("FROM Product p WHERE p.productName= : name")
                                .setParameter("name", commands[2]).getSingleResult();
                        Purchases purchases = new Purchases();
                        purchases.setConsumer(consumer);
                        purchases.setProduct(product);
                        purchases.setPrice(product.getPrice());
                        session.save(purchases);
                        session.getTransaction().commit();
                        System.out.println("Successful purchase of the product : " + product.getProductName() + "" +
                                " in the name of: " + consumer.getName() + " product price: " + product.getPrice());
                        break;
                    case "/showProductsByPerson":
                        session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Consumer consumer1 = (Consumer) session.createQuery("from Consumer c WHERE c.name = :name")
                                .setParameter("name", commands[1]).getSingleResult();
                        for (Purchases p : consumer1.getPurchasesList()) {
                            System.out.println(consumer1.getName() + " bought: " + p.getProduct().getProductName());
                        }
                        session.getTransaction().commit();
                        break;
                    case "/findPersonsByProductTitle":
                        session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Product product1 = (Product) session.createQuery("from Product p WHERE p.productName = :name")
                                .setParameter("name", commands[1]).getSingleResult();
                        List<Purchases> purchases2 = session.createQuery("from Purchases pr where pr.product.productName= :name")
                                .setParameter("name", product1.getProductName()).getResultList();
                        for (Purchases pr : purchases2) {
                            System.out.println("Client : " + pr.getConsumer().getName() + " bought: " + pr.getProduct().getProductName());
                        }
                        session.getTransaction().commit();
                        break;
                    case "/removePerson":
                        session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Consumer consumer3 = (Consumer) session.createQuery("FROM Consumer c WHERE c.name = :name")
                                .setParameter("name", commands[1]).getSingleResult();
                        session.delete(consumer3);
                        System.out.println("Deleted consumer: " + consumer3.getName() + " with id " + consumer3.getId());
                        session.getTransaction().commit();
                        break;
                    case "/removeProduct":
                        session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Product product2 = (Product) session.createQuery("from Product p WHERE p.productName = :name")
                                .setParameter("name", commands[1]).getSingleResult();
                        session.delete(product2);
                        System.out.println("Deleted product: " + product2.getProductName() + " with id " + product2.getId());
                        session.getTransaction().commit();
                        break;
                    default:
                        break;
                }
            }
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
