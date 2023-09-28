package ChatApplication;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Map<PrintWriter, String> clientNames = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {// Create a server socket
            // Accept client connections
            while (true) {
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
                clientHandler.start();
                //new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;// The client socket
        private PrintWriter out;// The output stream at terminal
        private BufferedReader in;// The input stream from terminal
        private String clientName;// The client name
        public ClientHandler(Socket socket) {// Constructor
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Prompt the client for a name
                out.println("Enter your messages now:");
                clientName = in.readLine();
                // Add the client's name and output stream to the map
                synchronized (clientWriters) {
                    clientWriters.add(out);
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
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                    clientNames.remove(out);
                }
                // Notify all clients about the user leaving and close the output stream
                //remove the client's name and output stream from the map
                broadcast(clientName + " has left the chat.", out);
            }
        }
    }

    private static void broadcast(String message, PrintWriter sender) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                if (writer != sender) {
                    writer.println(message);
                }
            }
        }
    }
}
