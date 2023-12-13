package ru.gb.examples.Example_3.Seminar;

import java.io.Serial;
import java.io.Serializable;

public class SerializablePerson implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private int age;
    private transient Department department;

    public SerializablePerson(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public SerializablePerson(String name, Department department) {
        this(name, 20, department);
    }

    public SerializablePerson(String name) {
        this(name, 20, null);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "SerializablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
