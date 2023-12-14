package ru.gb.examples.Example_3.Tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class DataService<T extends Serializable> {

    public void saveData(T data) {
        String fileName = data.getClass().getName() + "_" + UUID.randomUUID();
        Path path = Path.of("src/main/java/ru/gb/examples/Example_3/Tasks", fileName);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public T loadData(String fileName) {
        T data;
        Path path = Path.of("src/main/java/ru/gb/examples/Example_3/Tasks/" + fileName);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            data = (T) objectInputStream.readObject();
            File file = new File("src/main/java/ru/gb/examples/Example_3/Tasks/" + fileName);
            boolean deleteStat = file.delete();
            if (deleteStat) {
                System.out.println("File: " + fileName + " - deleted successfully");
            }
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
