package ru.gb.examples.Example_3.Seminar;

public class Department {

    public final String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
