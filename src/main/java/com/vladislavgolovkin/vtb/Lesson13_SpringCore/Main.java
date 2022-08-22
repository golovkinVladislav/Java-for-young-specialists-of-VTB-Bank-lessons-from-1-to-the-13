package com.vladislavgolovkin.vtb.Lesson13_SpringCore;
/*
Практическое задание
1. Создайте класс Product (id, title, cost);
2. Создайте компонент ProductService, который хранит в себе List<Product>, допустим с 10
видами товаров. В ProductService должен быть метод вывода всех товаров в консоль printAll(),
получения ссылки на Product по имени findByTitle(String title);
3. Создайте компонент Cart (корзина) с возможностью добавления туда товаров add(Product
product);
4. Создайте компонент OrderService, позволяющий из корзины сформировать заказ. Под
формирование заказа подразумевается распечатка всех позиций в консоли, с выводом
итоговой стоимости выбранных товаров.


Не надо прописывать ввод данных с консоли. Достаточно набросать немного кода,
демонстрирующего выполнение действий с указанными выше компонентами. Базу данных
прикручивать к проекту тоже не надо.
В ProductService у вас будет List<Product> для его заполнения не стоит использовать конструктор, как
бы мы это делали в обычном проекте. Вместо этого пропишите метод с аннотацией @PostConstruct,
который сработает после подготовки бина к работе, и в нем сделайте всю необходимую
подготовительную работу.
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(MyConfiguration.class);
        ProductService productService = applicationContext.getBean("productService",ProductService.class);
        productService.printAll();
        System.out.println();
        System.out.println(productService.findBTitle("Lemon"));

        Cart cart = applicationContext.getBean("cart",Cart.class);
        cart.add(productService.findBTitle("Apple"));
        cart.add(productService.findBTitle("Milk"));
        cart.add(productService.findBTitle("Peach"));

        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        orderService.showAllOrders();

        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
