package ru.gb.examples.Example_4.Tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


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

        Author author_5 = new Author();
        author_5.setName("Author #5");

        Author author_6 = new Author();
        author_6.setName("Author #6");

        Author author_7 = new Author();
        author_7.setName("Author #7");

        Author author_8 = new Author();
        author_8.setName("Author #8");

        Author author_9 = new Author();
        author_9.setName("Author #9");

        Author author_10 = new Author();
        author_10.setName("Author #10");

        try(final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory()) {

            /**
             * 3.*
             */
            try(Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                session.persist(author_1);
                session.persist(author_2);
                session.persist(author_3);
                session.persist(author_4);
                session.persist(author_5);
                session.persist(author_6);
                session.persist(author_7);
                session.persist(author_8);
                session.persist(author_9);
                session.persist(author_10);

                session.getTransaction().commit();
            }

            /**
             * 2.2 Создать Session и сохранить в таблицу 10 книг
             */
            try(Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                Book book_1 = new Book();
                book_1.setName("Book_1");
                book_1.setAuthor(author_1);
                book_1.setYearOfPub("Some_year");
                session.persist(book_1);

                Book book_2 = new Book();
                book_2.setName("Book_2");
                book_2.setAuthor(author_2);
                book_2.setYearOfPub("Some_year");
                session.persist(book_2);

                Book book_3 = new Book();
                book_3.setName("Book_3");
                book_3.setAuthor(author_3);
                book_3.setYearOfPub("Some_year");
                session.persist(book_3);

                Book book_4 = new Book();
                book_4.setName("Book_4");
                book_4.setAuthor(author_4);
                book_4.setYearOfPub("Some_year");
                session.persist(book_4);

                Book book_5 = new Book();
                book_5.setName("Book_5");
                book_5.setAuthor(author_5);
                book_5.setYearOfPub("Some_year");
                session.persist(book_5);

                Book book_6 = new Book();
                book_6.setName("Book_6");
                book_6.setAuthor(author_6);
                book_6.setYearOfPub("Some_year");
                session.persist(book_6);

                Book book_7 = new Book();
                book_7.setName("Book_7");
                book_7.setAuthor(author_7);
                book_7.setYearOfPub("Some_year");
                session.persist(book_7);

                Book book_8 = new Book();
                book_8.setName("Book_8");
                book_8.setAuthor(author_8);
                book_8.setYearOfPub("Some_year");
                session.persist(book_8);

                Book book_9 = new Book();
                book_9.setName("Book_9");
                book_9.setAuthor(author_9);
                book_9.setYearOfPub("Some_year");
                session.persist(book_9);

                Book book_10 = new Book();
                book_10.setName("Book_10");
                book_10.setAuthor(author_10);
                book_10.setYearOfPub("Some_year");
                session.persist(book_10);

                session.getTransaction().commit();
            }

            /**
             * 2.3 Выгрузить список книг какого-то автора
             */
            try(Session session = sessionFactory.openSession()) {
                List<Book> findingBooksByAuthor = session.createQuery("select u from Book u where author.name = 'Author #8'",
                        Book.class).getResultList();
                System.out.println(findingBooksByAuthor + "\n");
            }

            /**
             * 3.1 * Выгрузить Список книг и убедиться, что поле author заполнено
             */
            try(Session session = sessionFactory.openSession()) {
                List<Book> findingBooks = session.createQuery("select u from Book u",
                        Book.class).getResultList();
                System.out.println(findingBooks);
            }
        }
    }
}
