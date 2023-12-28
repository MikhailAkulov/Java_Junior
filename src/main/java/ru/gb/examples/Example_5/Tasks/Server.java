package ru.gb.examples.Example_5.Tasks;

import lombok.Getter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Server {

  public static final int PORT = 8181;
  private static long clientIdCounter = 1L;
  private static Map<Long, SocketWrapper> clients = new HashMap<>();

  public static void main(String[] args) throws IOException {
    try (ServerSocket server = new ServerSocket(PORT)) {
      System.out.println("Сервер запущен на порту: " + PORT);
      while (true) {
        final Socket client = server.accept();
        final long clientId = clientIdCounter++;

        SocketWrapper wrapper = new SocketWrapper(clientId, client);
        System.out.println("Подключился новый клиент " + wrapper);
        clients.values().stream()
                .filter(it -> it.getId() != wrapper.getId())
                .forEach(it -> it.getOutput().println("Пользователь: " + wrapper + " вошёл в чат"));
        clients.put(clientId, wrapper);

        new Thread(() -> {
          try (Scanner input = wrapper.getInput(); PrintWriter output = wrapper.getOutput()) {
            output.println("Подключение успешно. Список всех клиентов: " + clients + "\n" +
                    "Для отправки сообщения введите: @id пользователя текст сообщения\n" +
                    "Для выхода отправьте: q");
            boolean isAdmin = false;

            while (true) {
              String clientInput = input.nextLine();

              if (Objects.equals("admin", clientInput)) {
                isAdmin = true;
                System.out.println("Пользователь: " + wrapper + " - админ");
                continue;
              }

              if (clientInput.length() >= 5 && Objects.equals("kick", clientInput.substring(0, 4)) && isAdmin) {
                Long ejectedUser = Long.parseLong(clientInput.substring(clientInput.indexOf(" ") + 1));
                clients.values().forEach(it -> it.getOutput().println("Клиент: " + ejectedUser + " принудительно покинул чат усилиями админа"));
                System.out.println("Пользователь: " + ejectedUser + " предан анафеме и изгнан ссаными тряпками");
                clients.get(ejectedUser).close();
                clients.remove(ejectedUser);
                continue;
              }

              if (Objects.equals("q", clientInput)) {
                clients.remove(clientId);
                clients.values().forEach(it -> it.getOutput().println("Клиент: [" + clientId + "] отключился"));
                System.out.println("Пользователь: " + wrapper + " вышел из чата");
                break;
              }

              // формат личного сообщения: "@id пользователя текст сообщения"
              if (Objects.equals("@", clientInput.substring(0, 1))) {
                long destinationId = Long.parseLong(clientInput.substring(1, clientInput.indexOf(" ")));
                SocketWrapper destination = clients.get(destinationId);
                destination.getOutput().println("To " + clientId + ": " +
                        clientInput.substring(clientInput.indexOf(" ") + 1));
              } else {
                clients.values().stream()
                        .filter(it -> it.getId() != clientId)
                        .forEach(it -> it.getOutput().println("To " + clientId + ": " + clientInput));
              }
            }
          } catch (Exception e) {
            System.out.println("Завершение работы потока: " + Thread.currentThread().getName());
          }
        }).start();
      }
    }
  }
}

@Getter
class SocketWrapper implements AutoCloseable {

  private final long id;
  private final Socket socket;
  private final Scanner input;
  private final PrintWriter output;

  SocketWrapper(long id, Socket socket) throws IOException {
    this.id = id;
    this.socket = socket;
    this.input = new Scanner(socket.getInputStream());
    this.output = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void close() throws Exception {
    socket.close();
  }

  @Override
  public String toString() {
    return String.format("[id: %s, ip: %s, port: %s]", id, socket.getInetAddress(), socket.getPort());
  }
}
