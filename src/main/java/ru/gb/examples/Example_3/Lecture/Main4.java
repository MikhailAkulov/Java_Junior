package ru.gb.examples.Example_3.Lecture;

import java.io.*;
import java.util.ArrayList;

/**
 * Здесть десериализуем файл записанный в Main3
 */
public class Main4 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = null;
        list = (ArrayList<String>) deSerialObj("ser");
        System.out.println(list);
    }

    private static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    private static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}