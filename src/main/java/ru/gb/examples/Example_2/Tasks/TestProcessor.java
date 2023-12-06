package ru.gb.examples.Example_2.Tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestProcessor {

  /**
   * Данный метод находит все void методы без аргументов в классе, и запускеет их.
   * Для запуска создается тестовый объект с помощью конструткора без аргументов.
   */
  public static void runTest(Class<?> testClass) {
    final Constructor<?> declaredConstructor;
    try {
      declaredConstructor = testClass.getDeclaredConstructor();
    } catch (NoSuchMethodException e) {
      throw new IllegalStateException("Для класса \"" + testClass.getName() + "\" не найден конструктор без аргументов");
    }

    final Object testObj;
    try {
      testObj = declaredConstructor.newInstance();
    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException("Не удалось создать объект класса \"" + testClass.getName() + "\"");
    }

    List<Method> methods = new ArrayList<>();
    Method before = null;
    Method after = null;
    for (Method method : testClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(Test.class)) {
        checkTestMethod(method);
        methods.add(method);
      } else if (method.isAnnotationPresent(BeforeEach.class)) {
        checkTestMethod(method);
        before = method;
      } else if (method.isAnnotationPresent(AfterEach.class)) {
        checkTestMethod(method);
        after = method;
      }
    }

    List<Method> sortedMethodsByOrder = methods.stream()
                    .sorted(Comparator.comparingInt(it -> it.getAnnotation(Test.class).order())).toList();

    for (Method method : sortedMethodsByOrder) {
      if (!method.isAnnotationPresent(Skip.class)) {
        assert before != null;
        runBeforeEach(before, testObj);
        runTest(method, testObj);
        assert after != null;
        runAfterEach(after, testObj);
        System.out.println();
      }
    }
  }

  private static void checkTestMethod(Method method) {
    if (!method.getReturnType().isAssignableFrom(void.class) || method.getParameterCount() != 0) {
      throw new IllegalArgumentException("Метод \"" + method.getName() + "\" должен быть void и не иметь аргументов");
    }
  }

  private static void runTest(Method testMethod, Object testObj) {
    try {
      testMethod.invoke(testObj);
    } catch (InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
    } catch (AssertionError e) {
      throw new RuntimeException("Ошибка при запуске runTest \"" + e.getMessage() + "\"");
    }
  }

  private static void runBeforeEach(Method testMethod, Object testObj) {
    try {
      testMethod.invoke(testObj);
    } catch (InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
    } catch (AssertionError e) {
      throw new RuntimeException("Ошибка при запуске runBeforeEach \"" + e.getMessage() + "\"");
    }
  }

  private static void runAfterEach(Method testMethod, Object testObj) {
    try {
      testMethod.invoke(testObj);
    } catch (InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
    } catch (AssertionError e) {
      throw new RuntimeException("Ошибка при запуске runAfterEach \"" + e.getMessage() + "\"");
    }
  }
}
