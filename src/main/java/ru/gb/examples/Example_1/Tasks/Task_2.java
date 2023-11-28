package ru.gb.examples.Example_1.Tasks;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задание 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class Task_2 {

    public static void main(String[] args) {
        List<Employee> employees = generateRandomEmployees();

        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        List<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet())
                .stream().toList();
        System.out.println("Список отделов организации: " + departments + "\n");


        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream()
                .filter(it -> it.getSalary() < 10_000)
                .forEach(it -> it.setSalary(it.getSalary() * 1.2));
        System.out.println("Список сотрудников после повышения з/п на 20%, тем у кого з/п < 10:\n" + employees + "\n");

        // либо так:
//        System.out.println("Сотрудники с з/п < 10к после повышения ставки на 20%:");
//        employees.stream()
//                .filter(it -> it.getSalary() < 10_000)
//                .map(it -> new Employee(it.name, it.age, it.salary * 1.2, it.department))
//                .forEach(System.out::println);

        // 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> departmentEmployees = employees.stream()
                .map(it -> new AbstractMap.SimpleEntry<>(it.getDepartment(), it))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println("Список сотрудников по отделам:\n" + departmentEmployees + "\n");

        //2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .map(it -> new AbstractMap.SimpleEntry<>(it.getDepartment(), it.getSalary()))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
        System.out.println("Средняя заработная плата по отделам:\n" + averageSalaryByDepartment);
    }

    // 2.1 Создать список из 10-20 сотрудников
    private static List<Employee> generateRandomEmployees() {
        return List.of(
                new Employee("Konstantin", 43, 50000, "Финансовый"),
                new Employee("Lyubov", 38, 42000, "Финансовый"),

                new Employee("Peter", 37, 28000, "Снабжение"),
                new Employee("Ivan", 22, 9000, "Снабжение"),

                new Employee("Polina", 22, 15000, "Коммерческий"),
                new Employee("Elizabeth", 22, 8000, "Коммерческий"),

                new Employee("Sergey", 41, 37000, "Инженерно-технический"),
                new Employee("Yaroslav", 40, 35000, "Инженерно-технический"),
                new Employee("Mikhail", 35, 36000, "Инженерно-технический"),
                new Employee("Maxim", 29, 27000, "Инженерно-технический"),

                new Employee("Vyacheslav", 36, 24000, "Монтажный"),
                new Employee("Maxim", 43, 25000, "Монтажный"),
                new Employee("Eugene", 46, 25000, "Монтажный"),
                new Employee("Mikhail", 37, 24000, "Монтажный"),
                new Employee("Alexander", 39, 24000, "Монтажный"),
                new Employee("Anton", 32, 22000, "Монтажный"),
                new Employee("Alexei", 35, 23000, "Монтажный"),
                new Employee("Philip", 21, 8000, "Монтажный"),
                new Employee("Artyom", 24, 10000, "Монтажный"),
                new Employee("Denis", 23, 9000, "Монтажный")
        );
    }

    // Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
    static class Employee {
        String name;
        int age;
        double salary;
        String department;

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("[имя: %s, возраст: %s, заработная плата = %s, отдел - %s]", name, age, salary, department);
        }
    }
}
