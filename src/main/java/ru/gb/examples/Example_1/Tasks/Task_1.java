package ru.gb.examples.Example_1.Tasks;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Задание 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

public class Task_1 {
    public static void main(String[] args) {
        // Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(1_000)
                .toList();
//        System.out.println("Исходный список: \n" + list + "\n");

        // 1.1 Найти максимальное
        Integer maxNumber = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Максимальное число = " + maxNumber);

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        long sum = list.stream()
                .filter(it -> it > 500_000)
                .mapToLong(it -> (it * 5L - 150))
                .sum();
        System.out.println("Сумма чисел > 500_000 * 5 - 150 = " + sum);

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long amountOfNumbers  = list.stream()
                .mapToLong(it -> (long) it * it)
                .filter(it -> it < 100_000)
                .count();
        System.out.println("Количество чисел, квадрат которых < 100_000 = " + amountOfNumbers);
    }
}
