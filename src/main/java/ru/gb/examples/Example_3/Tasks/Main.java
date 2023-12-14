package ru.gb.examples.Example_3.Tasks;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/** Задача:
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

        String fileName = Employee.class.getName()  + "_" + UUID.randomUUID().toString();
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File: " + file.getAbsolutePath() + " - has been created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee savedEmployee = new Employee("Ivan", 25, 100.0, "IT");
        DataService<Employee> dataService = new DataService<>();
        System.out.println("Object: " + savedEmployee + " - created successfully");
        try {
            dataService.saveData(savedEmployee, fileName);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        Employee loadedEmployee;
        try {
            loadedEmployee = dataService.loadData(fileName);
            System.out.println("Object: " + loadedEmployee + " - loaded successfully");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
