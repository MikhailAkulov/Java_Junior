package ru.gb.examples.Example_1.Seminar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

  public static void main(String[] args) {
    /**
     * Создаем список
     */
    List<String> strings = new ArrayList<>(List.of("java", "c#", "c++", "python", "perl", "pascal"));
    System.out.println("Source list:");
    System.out.println(strings);
    System.out.println();

    /**
     * Вариант 1
     * Сортировка с помощью создания класса StringLengthComparator
     */
    strings.sort(new StringLengthComparator());
    System.out.println("Example 1. Sorting by creating a class StringLengthComparator:");
    System.out.println(strings);
    System.out.println();

    /**
     * Вариант 2
     * С помощью анонимного класса
     */
    strings.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
          return -1;
        } else if (o1.length() > o2.length()) {
          return 1;
        }
        return 0;
      }
    });
    System.out.println("Example 2. Sorting by anonymous class:");
    System.out.println(strings);
    System.out.println();

    /**
     * Вариант 3
     * Сортировка с помощью лямбда-выражения
     */
//    strings.sort((o1, o2) -> o1.length() - o2.length());
    strings.sort(Main::myComparator); // method reference (ссылка на метод)
    System.out.println("Example 3. Sorting by lambda expression:");
    System.out.println(strings);
    System.out.println();

    /**
     * Примеры лямбда-выражений
     */
    System.out.println("Example Consumer:");
    MyInterface myInterface = it -> System.out.print(it);
    myInterface.foo("abcdef");
    myInterface.foo("abcdef");
    myInterface.foo("abcdef");
    System.out.println();


    // void run() -> Runnable
    // T get();   -> Supplier
    // void accept(T value); -> Consumer
    // R apply(T value);     -> Function

    /**
     * Пример Runnable. Печатает рандомные числа
     */

    System.out.println("Example Runnable:");
//    Runnable runnable = () -> System.out.println(ThreadLocalRandom.current().nextInt(100));
    Runnable runnable = Main::printRandomNumberLessThan100;
    for (int i = 0; i < 10; i++) {
      runnable.run();
    }
    System.out.println();

    /**
     * Пример Function
     */
    System.out.println("Example Function:");
//    Function<String, Integer> stringLengthExtractor = arg -> arg.length();
//    Function<String, Integer> stringLengthExtractor = Main::extractStringLength;  // method reference (ссылка на метод)
    Function<String, Integer> stringLengthExtractor = String::length; // string -> integer
    System.out.printf("abcde = " + stringLengthExtractor.apply("abcde") + "\n");
    System.out.printf("java = " + stringLengthExtractor.apply("java") + "\n");
    System.out.printf("kotlin = " + stringLengthExtractor.apply("kotlin") + "\n");

    System.out.println();
    // или можно вообще так:
    Supplier<Integer> javaLengthGetter = "java"::length;
    System.out.println(javaLengthGetter.get());
    System.out.println(javaLengthGetter.get());

    System.out.println();
    // string -> boolean
    Predicate<String> isBestLanguage = "java"::equals;
    System.out.println(isBestLanguage.test("java"));
    System.out.println(isBestLanguage.test("c++"));
    System.out.println(isBestLanguage.test("python"));


    Function<String, String> f = it -> "Hello, " + it + "!";
    System.out.println();
    System.out.println(f.apply("Igor"));

    Function<String, String> g = it -> it.trim();
    System.out.println();
    System.out.println(g.apply("           Ivan             "));

    UnaryOperator<String> h = it -> it.toUpperCase();
    System.out.println();
    System.out.println("Example UnaryOperator:");
    System.out.println(h.apply("           Sergei             "));


    Supplier<Person> personGenerator = Person::new; // Через Supplier и первый конструктор
    Person person = personGenerator.get();
    System.out.println(person);

    person = personGenerator.get();
    System.out.println(person);

    Function<String, Person> personFunction = Person::new;  // Через Function и второй конструктор
    person = personFunction.apply("Gena");
    System.out.println(person);

    person = personFunction.apply("Tolik");
    System.out.println(person);
  }


  public static class Person {
    private static long counter = 1L;
    private String name;
    private Supplier<String> wordGenerator;

    public Person() {     // конструктор для Supplier
      name = "Person #" + counter++;
    }

    public Person(String name) {    // конструктор для Function
      this.name = name;
      this.wordGenerator = this::generateNextWord;
    }

    public void saySomething() {
      System.out.println(wordGenerator.get());
    }

    private String generateNextWord() {
      return "EFFECTIVE RANDOM WORD";
    }

    @Override
    public String toString() {
      return name;
    }
  }

  /**
   * Класс для Варианта №1
   */
  static class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      if (o1.length() < o2.length()) {
        return -1;
      } else if (o1.length() > o2.length()) {
        return 1;
      }
      return 0;
    }
  }

  /**
   * Пример Supplier
   */
  interface Interface<T> {
    T get();
  }

  /**
   * Пример Consumer
   */
  interface MyInterface {
    void foo(String arg);
  }

  /**
   * для Function<String, Integer>
   */
  static Integer extractStringLength(String arg) {
    return arg.length();
  }

  /**
   * для Runnable
   */
  static void printRandomNumberLessThan100() {
    System.out.println(ThreadLocalRandom.current().nextInt(100));
  }

  /**
   * Comparator<String>
   */
  static int myComparator(String a, String b) {
    return a.length() - b.length();
  }
}