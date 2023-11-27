package ru.gb.examples.Example_1.Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        /**
         * лямбда выражения
         */
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x+y);
//            }
//        };

//        PlainInterface plainInterface = Integer::sum;
//        System.out.println(plainInterface.action(5,3));
//
//        PlainInterface plainInterface1 = Integer::compare;
//        System.out.println(plainInterface1.action(1, 5));

        /**
         * stream api
         */
//        List<String> list = Arrays.asList("Привет", "мир", "!", "и", "всё", "!");
//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//
//        for(String item: list) {
//            System.out.println(item);
//        }

//        list.stream().filter(str -> str.length() > 4).forEach(System.out::println);

//        list.stream().filter(str -> str.length() > 4).filter(str -> str.contains("в")).forEach(System.out::println);

//        Arrays.asList(1, 10, 0, 7, 5).stream().map(chislo -> "число: " + chislo + ". квадрат числа = " + chislo * chislo).forEach(System.out::println);

//        Arrays.asList(1, 10, 0, 5, 7, 5).stream().sorted().distinct().forEach(System.out::println);

//        System.out.println(Arrays.asList(1, 10, 0, 5, 7, 5).stream().sorted().distinct().findFirst().get());

        /**
         * User task
         */
        List<User> list = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40), new User("Валера", 30));

//        list.stream().map(user -> new User(user.name, user.age - 5)).forEach(System.out::println);

        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);
    }
}
