package org.test.java.project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product [] products = {
                new Product(1L, "Pencils", "Office utilities", 190.89, new HashSet<>()),
                new Product(2L, "Cups", "Kitchen utilities", 2423.89, new HashSet<>()),
                new Product(4L, "Home library", "Books", 3424.2, new HashSet<>()),
                new Product(6L, "Pencils", "Office utilities", 190.89, new HashSet<>()),
                new Product(8L, "Home library", "Books", 64.6, new HashSet<>()),
                new Product(42L, "Pencils", "Office utilities", 190.89, new HashSet<>()),
                new Product(54L, "Home library", "Books", 11234.2, new HashSet<>()),
                new Product(345L, "Pencils", "Office utilities", 190.89, new HashSet<>()),
                new Product(622L, "Home library", "Books", 34.4, new HashSet<>()),
                new Product(626L, "Pencils", "Office utilities", 190.89, new HashSet<>())
        };

        List<Product> filteredProductsList = Arrays.stream(products)
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100.0)
                .toList();

        filteredProductsList.forEach(System.out::println);
    }
}
