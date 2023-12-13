package ru.gb.examples.Example_3.Seminar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Lesson3Main {
    // Thread
    // Stream

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Java Database Connectivity
        Department department = new Department("gb");
        SerializablePerson igor = new SerializablePerson("Igor", 180, department);

        Path path = Path.of("serializable-person.txt");

//        OutputStream outputStream = Files.newOutputStream(path);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(igor);
//        objectOutputStream.close();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));
//        SerializablePerson deserializedIgor = (SerializablePerson) objectInputStream.readObject();
//        System.out.println(deserializedIgor);
//        objectInputStream.close();
//
        Path myfile = Path.of( "myfile.txt");

//        Path parent = myfile.getParent();
//        Files.createDirectory(parent);
//
//        Files.createFile(myfile);

        Files.writeString(myfile, "asdf");

        /**
         * Для примера InputStream, OutputStream прочитаем файл pom.xml
         */
//        Path path = Path.of("pom.xml");
//
//        InputStream inputStream = Files.newInputStream(path);
//        int read = inputStream.read();
//        byte[] bytes = inputStream.readAllBytes();
//        String content = new String(bytes);
//        inputStream.close();
//
//        byte[] firstSymbol = new byte[1];
//        firstSymbol[0] = (byte) read;
//
//        System.out.println(new String(firstSymbol));
//        System.out.println(content);

        /**
         * Записать в файл
         */
//        Path path = Path.of("output.txt");
//
////        OutputStream outputStream = Files.newOutputStream(path);                              // открывает и перезаписывает
//        OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.APPEND);     // открывает и дописывает в конец
//        outputStream.write("my content".getBytes());
//        outputStream.close();

        // или с помощью try with resources, чтобы не закрывать вручную
//        try (OutputStream outputStream = Files.newOutputStream(path)){
//            outputStream.write("my content".getBytes());
//        }
    }
}
