import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        int port = 8787;
        Deque<String> cityDeque = new ArrayDeque<>();
        cityDeque.add("???");
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket client = server.accept()) {
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                    writer.println(cityDeque.getLast());
                    String city = reader.readLine();
                    CheckChar checkChar = new CheckChar(cityDeque.getLast(), city); // Москва Актау
                    if (cityDeque.getLast().equalsIgnoreCase("???")) {
                        cityDeque.offerLast(city);
                        System.out.println(cityDeque.toString());
                    } else {
                        if (checkChar.check()) {
                            writer.println("OK");
                            cityDeque.offerLast(city);
                            System.out.println(cityDeque.toString());
                        } else {
                            writer.println("NOT OK");
                            System.out.println("Пользователь: " + client.getPort() + " проиграл");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
