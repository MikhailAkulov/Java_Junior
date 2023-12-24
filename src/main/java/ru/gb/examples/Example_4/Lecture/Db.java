package ru.gb.examples.Example_4.Lecture;

//import java.sql.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void con(){
        /**
         * к таблице table
         */
//        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            Statement statement = con.createStatement();    //  создали пустой statement - объект, который используется для запуска SQL-запросов и получения результатов работы этого запроса
//            statement.execute("DROP SCHEMA `test`");    //  удалили БД
//            statement.execute("CREATE SCHEMA `test`");  //  создали БД
//            statement.execute("CREATE TABLE `test`.`table` (`id` INT NOT NULL, `firstname` VARCHAR(45) NULL, `lastname` VARCHAR(45) NULL, PRIMARY KEY(`id`));");
//            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
//                    "VALUES (1, 'Иванов','Иван');");
//            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
//                    "VALUES (2, 'Петров','Петр');");
//
//            ResultSet set = statement.executeQuery("SELECT * FROM test.table;");
//            while (set.next()) {
//                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }

        /**
         * к таблице magic
         */
        Connector connector = new Connector();

//        Session session = connector.getSession();
//        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
//        session.beginTransaction(); session.save(magic);
//        magic = new Magic("Молния", 25, 0, 0);
//        session.save(magic);
//        magic = new Magic("Каменная кожа", 0, 0, 6);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Проклятие", 0, -3, 0);
//        session.save(magic);
//        magic = new Magic("Лечение", -30, 0, 0);
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();

        try (Session session = connector.getSession()) {

//            List<Magic> books = session.createQuery("FROM Magic", Magic.class).getResultList();
//            books.forEach(System.out::println);

//            String hql = "from Magic where id = :id";
//            Query<Magic> query = session.createQuery( hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic = query.getSingleResult();
//            System.out.println(magic);
//            magic.setAttBonus(100);
//            magic.setName("Ярость");
//            session.beginTransaction();
//            session.update(magic);
//            session.getTransaction().commit();

            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic", Magic.class).getResultList();
            magics.forEach(m -> {
                session.delete(m);
            });
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
