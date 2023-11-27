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
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(10) // для ограниения до 1000 чисел
                .toList();
        System.out.println("Исходный список: \n" + list + "\n");

        // 1.1 Найти максимальное
        Integer maxNumber = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Максимальное число = " + maxNumber);

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        Integer sum = list.stream()
                .filter(it -> it > 500_000)
                .map(it -> (it * 5 - 150))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма чисел > 500_000 * 5 - 150 = " + sum);

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
    }
}
