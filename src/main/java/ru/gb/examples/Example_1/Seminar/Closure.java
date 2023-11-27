package ru.gb.examples.Example_1.Seminar;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Захват переменной
 */

public class Closure {
    public static void main(String[] args) {
        Runnable runnable = xPrinter();
        runnable.run();
    }

    private static Runnable xPrinter() {

        // исходный вариант
//        final int x = 5;    // effectively final переменная (не должна меняться)
//        Runnable runnable = () -> {
//            System.out.println(x);
//        };
//        return runnable;

        // Хаки, если очень надо поменять значение переменной
        // 1 способ массив из одного элемента
//        final int[] xx = new int[1];
//        xx[0] = 5;
//        Runnable runnable = () -> {
//            System.out.println(xx[0]);
//        };
//        xx[0] = 7;
//        return runnable;

        // 2 способ AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger(5);
        Runnable runnable = () -> {
            System.out.println(atomicInteger.get());
        };
        atomicInteger.set(7);
        return runnable;
    }
}
