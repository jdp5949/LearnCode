package ChatApplication.One_To_One;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    private static Map<String, PrintWriter> connectedClients = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Prompt the client for a name
                out.println("Enter your name:");
                clientName = in.readLine();

                synchronized (connectedClients) {
                    connectedClients.put(clientName, out);
                }

                // Notify all clients about the new user
                broadcast(clientName + " has joined the chat.", null);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("@")) {
                        // Handle private messages
                        String[] parts = message.split(" ", 2);
                        String recipient = parts[0].substring(1); // Remove "@" from recipient name
                        String privateMessage = clientName + " (private): " + parts[1];
                        sendPrivateMessage(privateMessage, recipient);
                    } else {
                        // Broadcast group messages
                        broadcast(clientName + ": " + message, null);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (connectedClients) {
                    connectedClients.remove(clientName);
                }
                // Notify all clients about the user leaving
                broadcast(clientName + " has left the chat.", null);
            }
        }
    }

    private static void broadcast(String message, String recipient) {
        synchronized (connectedClients) {
            for (Map.Entry<String, PrintWriter> entry : connectedClients.entrySet()) {
                String clientName = entry.getKey();
                PrintWriter writer = entry.getValue();
                if (recipient == null || recipient.equals(clientName)) {
                    writer.println(message);
                }
            }
        }
    }

    private static void sendPrivateMessage(String message, String recipient) {
        synchronized (connectedClients) {
            PrintWriter recipientWriter = connectedClients.get(recipient);
            if (recipientWriter != null) {
                recipientWriter.println(message);
            }
        }
    }
}
