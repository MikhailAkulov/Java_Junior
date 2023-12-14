package ru.gb.examples.Example_3.Tasks;

import java.io.Serializable;

/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл.
 *    Название файл - class.getName() + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString(),
 *    загружает объект из файла и удаляет этот файл.
 *
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivan", 25, 100.0, "IT");

        DataService<Employee> dataService = new DataService<>();
        dataService.saveData(emp1);

//        Employee
    }
}

