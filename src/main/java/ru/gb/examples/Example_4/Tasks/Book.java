package ru.gb.examples.Example_4.Tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    //3.* Создать сущность Автор (id bigint, name varchar), и в сущности Book сделать поле типа Author (OneToOne)
    @OneToOne
    @JoinColumn(name = "author")
    private Author author;

    @Column(name = "yearOfPub")
    private String yearOfPub;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getYearOfPub() {
        return yearOfPub;
    }

    public void setYearOfPub(String yearOfPub) {
        this.yearOfPub = yearOfPub;
    }

    @Override
    public String toString() {
        return String.format("[Book_id: %s, title: %s, author_name: %s, year: %s]", id, name, author,yearOfPub);
    }
}
