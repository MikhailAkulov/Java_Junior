package ru.gb.examples.Example_4.Tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Задание 2.
 * Выполнить с помощью JPA(Hibernate)
 */

public class Task2_jpa_hibernate {
    public static void main(String[] args) {

        Author author_1 = new Author();
        author_1.setName("Author #1");

        Author author_2 = new Author();
        author_2.setName("Author #2");

        Author author_3 = new Author();
        author_3.setName("Author #3");

        Author author_4 = new Author();
        author_4.setName("Author #4");

        try(final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory()) {

            /**
             * 2.2 Создать Session и сохранить в таблицу 10 книг
             */
            try(Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                Book book_1 = new Book();
                book_1.setName("Book_1");
                book_1.setAuthor(author_1);
                book_1.setYearOfPub("Some_year");

                Book book_2 = new Book();
                book_2.setName("Book_2");
                book_2.setAuthor(author_2);
                book_2.setYearOfPub("Some_year");

                Book book_3 = new Book();
                book_3.setName("Book_3");
                book_3.setAuthor(author_3);
                book_3.setYearOfPub("Some_year");

                Book book_4 = new Book();
                book_4.setName("Book_4");
                book_4.setAuthor(author_4);
                book_4.setYearOfPub("Some_year");

                Book book_5 = new Book();
                book_5.setName("Book_5");
                book_5.setAuthor(author_1);
                book_5.setYearOfPub("Some_year");

                Book book_6 = new Book();
                book_6.setName("Book_6");
                book_6.setAuthor(author_3);
                book_6.setYearOfPub("Some_year");

                Book book_7 = new Book();
                book_7.setName("Book_7");
                book_7.setAuthor(author_2);
                book_7.setYearOfPub("Some_year");

                Book book_8 = new Book();
                book_8.setName("Book_8");
                book_8.setAuthor(author_1);
                book_8.setYearOfPub("Some_year");

                Book book_9 = new Book();
                book_9.setName("Book_9");
                book_9.setAuthor(author_4);
                book_9.setYearOfPub("Some_year");

                Book book_10 = new Book();
                book_10.setName("Book_10");
                book_10.setAuthor(author_2);
                book_10.setYearOfPub("Some_year");

                session.getTransaction().commit();
            }

            /**
             * 2.3 Выгрузить список книг какого-то автора
             */
        }
    }
}
