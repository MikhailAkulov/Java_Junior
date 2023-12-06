package ru.gb.examples.Example_2.Seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson2MainTest {
    @Test
    void testToString() {
        Lesson2Main.Person person = new Lesson2Main.Person("Igor", 20);

        Assertions.assertEquals(person.toString(), "Igor - [20]");
    }
}