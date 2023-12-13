package ru.gb.examples.Example_3.Lecture;

import java.io.*;
import java.util.ArrayList;

/**
 * Усложняем дальше
 */
public class Main5 {
    public static void main(String[] args) throws Exception {
//         Сериализуем файл
//        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
//        serialObj(myFCs, "ser");

        // Затем десериализуем
        MyFCs myFCs = (MyFCs) deSerialObj("ser");   // т.к. возвращается Object, необходимо выполнить преобразование типов
        System.out.println(myFCs);                      // выводим на экран Object

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

    static class MyFCs implements Serializable{
//        public String lName;
//        public String fName;
//        public String patronymic;

        // если делаем поля приватными, то повторно десериализовать объект не получится, получим Exception
        // поскольку используется доступ к переменным
        private String lName;
        private String fName;
        private String patronymic;

        // Когда меняем структуру класса, следует указывать версию того класса, который мы сейчас имеем
        // т.е. если мы как-то изменили свой класс, то нужно указывать следующее поле:
        private static final long serialVersionUID = 1L;

        public MyFCs(String fName, String lName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }
}
