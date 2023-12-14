# Урок 3. Сериализация

## Описание лекции:

- Понимание понятий потоков ввода-вывода
- Байтовые и символьные потоки
- Буферизированные потоки и работа с файлами
- Сериализация объектов
- Управление версией сериализованных объектов
- Понятие ORM и его преимущества
- Введение в JPA
- Создание сущностей и аннотации JPA
- Основы Hibernate: конфигурация и сессии

[Код лекции](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_3/Lecture)

## На семинаре:

- Создание класса с приватными полями, который реализует интерфейс Serializable.
- Запись объекта этого класса в файл с использованием ObjectOutputStream.
- Чтение объекта из файла с использованием ObjectInputStream и восстановление его состояния.
- Использование Java I/O для чтения и записи данных в файл.

[Код семинара](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_3/Seminar)

## Задания:

Написать класс с двумя методами:
1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.

* Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.

`Реализация:`

[Директория](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_3/Tasks)

[Точка входа](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_3/Tasks/Main.java)