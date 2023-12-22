package ru.gb.examples.Example_4.Lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void con(){
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();    //  создали пустой statement - объект который используется для запуска SQL-запросов и получения результатов работы этого запроса
            statement.execute("DROP SCHEMA `test`");    //  удалили БД
            statement.execute("CREATE SCHEMA `test`");  //  создали БД
            statement.execute("CREATE TABLE `test`.`table` (`id` INT NOT NULL, `firstname` VARCHAR(45) NULL, `lastname` VARCHAR(45) NULL, PRIMARY KEY(`id`));");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
