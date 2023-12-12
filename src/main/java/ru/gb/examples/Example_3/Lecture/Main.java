package ru.gb.examples.Example_3.Lecture;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Сериализуем объект
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String str = "Всем привет!";
        FileOutputStream fileOutputStream = new FileOutputStream("ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();
    }
}
