# Урок 2. Reflection API

## Описание лекции:

- Введение в Reflection API
- Получение информации о классах, полях, методах и конструкторах
- Работа с аннотациями через Reflection
- Создание объектов и вызов методов через Reflection
- Изменение доступности полей и методов
- Применение типовых параметров с помощью Reflection
- Работа с массивами через Reflection
- Применение Proxy классов
- Ограничения и осторожность при использовании Reflection
- Лучшие практики и примеры использования Reflection API

[Код лекции](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_2/Lecture)

## На семинаре:

- Получение информации о классе и его структуре с использованием Reflection API.
- Создание и вызов методов и конструкторов во время выполнения.
- Использование Reflection API для работы с приватными полями и методами.

[Код семинара](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_2/Seminar)

## Задания:

Расширить пример с запуском тестов следующими фичами:
1. Добавить аннотации BeforeEach, AfterEach,
   которые ставятся над методами void без аругментов и запускаются ДО и ПОСЛЕ всех тестов соответственно.
2. В аннотацию Test добавить параметр order() со значением 0 по умолчанию.
   Необходимо при запуске тестов фильтровать тесты по этому параметру (от меньшего к большему).
   Т.е. если есть методы @Test(order = -2) void first, @Test void second, Test(order = 5) void third,
   то порядок вызовов first -> second -> third
3. *Добавить аннотацию @Skip, которую можно ставить над тест-методами. Если она стоит - то тест не запускается.
4. *При наличии идей, реализовать их и написать об этом в комментарии при сдаче.

`Реализация:` 

[Директория](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_2/Tasks)

[Точка входа](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_2/Tasks/Homework.java)