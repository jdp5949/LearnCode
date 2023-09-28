package ChatApplication;

import java.io.*;
import java.net.*;
import java.util.*;

public class SingleServer {
    private static final int PORT = 12345;
    private static Map<PrintWriter, String> clientNames = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            // Prompt the client for a name
            out.println("Enter your name:");
            String clientName = in.readLine();

            synchronized (clientNames) {
                clientNames.put(out, clientName);
            }

            // Notify all clients about the new user
            broadcast(clientName + " has joined the chat.", out);

            String message;
            while ((message = in.readLine()) != null) {
                // Broadcast the message to all clients except the sender
                broadcast(clientName + ": " + message, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcast(String message, PrintWriter sender) {
        synchronized (clientNames) {
            for (PrintWriter writer : clientNames.keySet()) {
                if (writer != sender) {
                    writer.println(message);
                }
            }
        }
    }
}
