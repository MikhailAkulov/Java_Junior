# Урок 4. Базы данных и инструменты взаимодействия с ними

## Описание лекции:

- Введение в JDBC
- Установка и подключение к базе данных MySQL
- Основы SQL: DDL, DML и DQL
- Выполнение SQL запросов с помощью JDBC
- Работа с ResultSet
- Предотвращение SQL Injection: PreparedStatement и CallableStatement
- Управление транзакциями в JDBC
- Оптимизация работы с базой данных
- Использование пулов соединений
- Лучшие практики при работе с JDBC

[Код лекции](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_4/Lecture)

## На семинаре:

- Создание базы данных MySQL и таблицы для хранения объектов определенного класса.
- Реализация доступа к базе данных с использованием JDBC и выполнение базовых операций CRUD.
- Создание сущности JPA для соответствующей таблицы базы данных.
- Использование Hibernate для работы с базой данных: чтение, запись, обновление и удаление записей.

[Код семинара](https://github.com/MikhailAkulov/Java_Junior/tree/main/src/main/java/ru/gb/examples/Example_4/Seminar)

## Задания:

Необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqlite, h2, ...)

1. С помощью JDBC выполнить:

    1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...

    1.2 Добавить в таблицу 10 книг

    1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet

    
2. С помощью JPA(Hibernate) выполнить:

    2.1 Описать сущность Book из пункта 1.1

    2.2 Создать Session и сохранить в таблицу 10 книг

    2.3 Выгрузить список книг какого-то автора


3. (со *) Создать сущность Автор (id bigint, name varchar), и в сущности Book сделать поле типа Author (OneToOne)

    3.1 * Выгрузить Список книг и убедиться, что поле author заполнено

    3.2 ** В классе Author создать поле List<Book>, которое описывает список всех книг этого автора. (OneToMany)

`Реализация:`

[Task1_jdbc](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_4/Tasks/Task1_jdbc.java)

[Task2_jpa_hibernate](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_4/Tasks/Task2_jpa_hibernate.java)

[Book](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_4/Tasks/Book.java)

[Author](https://github.com/MikhailAkulov/Java_Junior/blob/main/src/main/java/ru/gb/examples/Example_4/Tasks/Author.java)
