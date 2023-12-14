package ru.gb.examples.Example_3.Tasks;

import java.io.*;

public class DataService<T extends Serializable> {
    public void saveData(T data, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public T loadData(String fileName) throws RuntimeException {
        File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("File not found");
        } else if (file.length() == 0) {
            throw new RuntimeException("File is empty");
        }
        T data;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object inputObject = objectInputStream.readObject();
            data = (T) inputObject;
            objectInputStream.close();
            if (file.delete()) {
                System.out.println("File: " + file.getAbsolutePath() + " - has been deleted");
            }
            return data;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
