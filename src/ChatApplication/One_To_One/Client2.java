package ChatApplication.One_To_One;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    private static final String SERVER_IP = "192.168.1.4"; // Change to the server's IP address
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. Enter your name:");
            String clientName = scanner.nextLine();
            out.println(clientName); // Send the client's name to the server

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            String input;
            while (true) {
                input = scanner.nextLine();
                if ("/exit".equalsIgnoreCase(input)) {
                    break;
                } else if (input.startsWith("/private")) {
                    // Send a private message
                    out.println("@" + input.substring(9)); // Extract recipient's name
                } else {
                    // Send a group message
                    out.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

