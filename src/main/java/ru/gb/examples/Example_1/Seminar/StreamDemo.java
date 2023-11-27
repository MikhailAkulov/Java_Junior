package ru.gb.examples.Example_1.Seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        /**
         * Методы создания stream, который что-то генерирует
         */
        // 1
        // Stream, в котором бесконечне (Long max value = 2 в 64 степени) число чисел от 0 до 999
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000))
                .limit(100) // для ограниения до 100 чисел
                .toList();
        System.out.println(list);

        // 2
        // Stream с примитивами
//        IntStream.generate()
//                .map() // принимает UnaryOperator (принимает примитив и возвращает примитив)
//                .boxed() // делает из него обычный стрим в boxed
//                .mapToInt(); // делает из обычного стрима обычный toIntFunction, который принимает объект а возвращает примитив

        List<Product> products = generateRandomProducts();

        /**
         * Найти и распечатать все товары из категории Электроника дешевле 10_000 руб
         */
//        for (Product product: products) {
//            if (product.getCategory().equals("Electronics") && product.getCost() < 10_000) {
//                System.out.println(product);
//            }
//        }

        // С помощью стримов
        // Полная запись. Нет смысла заводить в переменные, потому что их нельзя повторно переиспользовать
//        Stream<Product> originalStream = products.stream();
//        Stream<Product> electronicsStream = originalStream
//                .filter(product -> product.getCategory().equals("Electronics"));
//        Stream<Product> lowCostElectronics = electronicsStream.filter(it -> it.getCost() < 10_000);
//        lowCostElectronics.forEach(product -> System.out.println(product));

        // Сокращенная запись (нормальная, классический пример)
//        products.stream()
//                .filter(it -> it.getCategory().equals("Electronics"))
//                .filter(it -> it.getCost() < 10_000)
//                .forEach(System.out::println);

        // Оптимизированная запись
//        products.stream()
//                .filter(it -> it.getCategory().equals("Electronics") && it.getCost() < 10_000)
//                .forEach(System.out::println);

        /**
         * Всем продуктам из категории Продукты повысить стоимость на %5
         */
        // Полная запись.
//        products.stream()
//                .filter(it -> it.getCategory().equals("Products"))
//                .forEach(it -> {
//                    double oldCost = it.getCost();
//                    it.setCost(oldCost * 1.05);
//                });
//        System.out.println(products);

        // Оптимизированная
//        products.stream()
//                .filter(it -> it.getCategory().equals("Products"))
//                .forEach(it -> it.setCost(it.getCost() * 1.05);
//        System.out.println(products);

        /**
         * все продукты, начинающиеся на M собрать в список
         */
        //если есть лист, в который нужно добавить
        List<Product> existCollection = new ArrayList<>();                  // 2

//        List<Product> m = products.stream()                               // 1
//        List<Product> m = products.stream()                               // 2
        Optional<Product> product = products.stream()                       // 3
                .filter(it -> it.getName().startsWith("M"))
//                .collect(Collectors.toCollection(ArrayList::new));        // 1
//                .collect(Collectors.toCollection(() -> existCollection)); // 2
                .parallel()     // параллельное выполнение стрима
                .sequential()   // отключение параллельного выполнения стрима
                .findFirst();                                               // 3

//        System.out.println(existCollection);                              // 2

        product.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("Product not found"));     // 3
        // либо то же самое
//        if (product.isPresent()) {
//            Product productValue = product.get();
//            System.out.println(productValue);
//        } else {
//            System.out.println("Product not found");
//        }
    }

    private static List<Product> generateRandomProducts() {
        return List.of(
                new Product("Milk", 70, "Products"),
                new Product("Bread", 53, "Products"),
                new Product("Water", 50, "Products"),
                new Product("Cheese", 600, "Products"),
                new Product("Pasta", 100, "Products"),

                new Product("Computer", 70_000, "Electronics"),
                new Product("Headphones", 7_000, "Electronics"),
                new Product("Keyboard", 3_500, "Electronics"),

                new Product("Glycine", 100, "Pharmacy"),
                new Product("Paracetamol", 60, "Pharmacy"),
                new Product("Bandage", 15, "Pharmacy"),
                new Product("Mask", 30, "Pharmacy")
        );
    }

    static class Product {
        private final String name;
        private double cost;
        private String category;


        Product(String name, double cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("[%s] (cost = %s, category = %s)", name, cost, category);
        }
    }
}
