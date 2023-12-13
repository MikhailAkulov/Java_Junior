package ru.gb.examples.Example_3.Lecture;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Сериализуем объект
 * записываем в файл
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String str = "Всем привет!";                                                        // создаем простую строку (ссылочный тип данных)
        FileOutputStream fileOutputStream = new FileOutputStream("ser");              // создаем поток для записи в файл (указывается имя файла)
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);   // создаем поток для записи объекта файла (указывается сам объект)
        objectOutputStream.writeObject(str);                                                // производим саму запись
        objectOutputStream.close();                                                         // закрываем поток чтобы файл стал читабельным
    }
}
