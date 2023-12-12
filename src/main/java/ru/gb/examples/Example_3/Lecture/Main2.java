package ru.gb.examples.Example_3.Lecture;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Десериализуем объект
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String s = (String) objectInputStream.readObject();
        System.out.println(s);
    }
}
