package ru.gb.examples.Example_4.Tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

//    public Book() {
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_title")
    private String name;

    @OneToOne
    @JoinColumn(name = "author_id")
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
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", yearOfPub='" + yearOfPub + '\'' +
                '}';
    }
}
