package ru.geekbrains.paymentservice.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.soap.payment.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    public List<Product> getProducts(int price) {

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Лимонад");
        product1.setPrice(100);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Хлеб");
        product2.setPrice(50);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Яблоки");
        product3.setPrice(100);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Сыр");
        product4.setPrice(200);

        return new ArrayList<Product>() {{
            add(product1);
            add(product2);
            add(product3);
            add(product4);
        }}.stream().filter(
            product -> product.getPrice() >= (price)
        ).collect(Collectors.toList());

    }

}