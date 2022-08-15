package com.vladislavgolovkin.vtb.Lesson12_HibernatePartTwo;
/*
1. Создайте таблицу items (id serial, val int, ...), добавьте в нее 40 строк со значением 0;
2. Запустите 8 параллельных потоков, в каждом из которых работает цикл, выбирающий
случайную строку в таблице и увеличивающий val этой строки на 1. Внутри транзакции
необходимо сделать Thread.sleep(5). Каждый поток должен сделать по 20.000 таких
изменений;
3. По завершению работы всех потоков проверить, что сумма всех val равна соответственно
160.000;
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();

        CountDownLatch countDownLatch = new CountDownLatch(8);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20000; j++) {
                        Integer randomValue = new Integer(random.nextInt((40 - 1) + 1) + 1);
                        Session session = sessionFactory.getCurrentSession();
                        session.beginTransaction();
                        Item item = session
                                .createQuery("FROM Item i WHERE i.id = :id", Item.class)
                                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                                .setParameter("id", randomValue)
                                .getSingleResult();
                        int temp = item.getValue();
                        item.setValue(++temp);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        session.save(item);
                        session.getTransaction().commit();
                        if (session != null) {
                            session.close();
                        }
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sumRezult = 0;
        Session session1 = null;
        try {
            session1 = sessionFactory.getCurrentSession();
            session1.beginTransaction();
            List<Item> itemList = session1.createQuery("SELECT i FROM Item i", Item.class).getResultList();
            for (Item it : itemList) {
                sumRezult += it.getValue();
            }
            session1.getTransaction().commit();
            System.out.println(sumRezult);
        } finally {
            sessionFactory.close();
            if (session1 != null) {
                session1.close();
            }
        }
    }
}
