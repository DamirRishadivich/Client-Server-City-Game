import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 8787;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String city = reader.readLine();
            System.out.println(city);
            writer.println("Москва");

            if (!city.equalsIgnoreCase("???")) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
