import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        // Replace with your server's IP and port
        String serverIP = "127.0.0.1";
        int serverPort = 1234;

        try {
            // Create a client and connect it to the server
            Client client = new Client(serverIP, serverPort);
            client.connect();

            // Create a BufferedReader for reading user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Loop for reading user input and sending messages
            String message;
            while ((message = userInput.readLine()) != null) {
                client.sendMessage(message);
            }

            // Disconnect the client when the user stops entering input
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}