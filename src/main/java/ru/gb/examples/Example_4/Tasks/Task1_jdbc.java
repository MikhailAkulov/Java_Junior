package ru.gb.examples.Example_4.Tasks;

import java.sql.*;

/**
 * Задание 1.
 * Выполнить с помощью JDBC
 */

public class Task1_jdbc {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database.db");

        /**
         * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
         */
        prepareTables(connection);

        /**
         * 1.2 Добавить в таблицу 10 книг
         */
        insertData(connection);

        /**
         * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
         */
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from book where author = 'Author #2'");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String yearOfPub = resultSet.getString("yearOfPub");

                System.out.println("book_id: " + id + ", book_name: " + name + ", author: " + author +
                        ", publication_year: " + yearOfPub);
            }
        }
        connection.close();
    }

    private static void prepareTables(Connection connection) throws SQLException{
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table if not exists book (
                    id bigint,
                    name varchar(255),
                    author varchar(255),
                    yearOfPub varchar(255)
                    )
                    """);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    insert into book(id, name, author, yearOfPub)
                    values
                    (1, 'Book_1', 'Author #1', 'Some_year'),
                    (2, 'Book_2', 'Author #2', 'Some_year'),
                    (3, 'Book_3', 'Author #3', 'Some_year'),
                    (4, 'Book_4', 'Author #4', 'Some_year'),
                    (5, 'Book_5', 'Author #1', 'Some_year'),
                    (6, 'Book_6', 'Author #3', 'Some_year'),
                    (7, 'Book_7', 'Author #2', 'Some_year'),
                    (8, 'Book_8', 'Author #1', 'Some_year'),
                    (9, 'Book_9', 'Author #4', 'Some_year'),
                    (10, 'Book_10', 'Author #2', 'Some_year')
                    """);
        }
    }
}
