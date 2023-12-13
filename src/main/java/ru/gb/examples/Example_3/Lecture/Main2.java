package ru.gb.examples.Example_3.Lecture;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Десериализуем объект
 * выводим на экран
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("ser");               // создаем поток побайтного чтения из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);     // создаем поток побайтной загрузки объекта из указанного файла
        String s = (String) objectInputStream.readObject();                               // загружаем сам объект и приводим к требуемому типу
        System.out.println(s);                                                            // выводим на экран
    }
}
