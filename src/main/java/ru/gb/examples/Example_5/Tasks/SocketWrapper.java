package ru.gb.examples.Example_5.Tasks;

import lombok.Getter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
