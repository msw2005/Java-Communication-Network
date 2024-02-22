import java.io.*;
import java.net.*;
// code
public class Client {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
// hello
    public Client(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void connect() throws IOException {
        this.socket = new Socket(serverIP, serverPort);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Connected to server at " + serverIP + ":" + serverPort);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        socket.close();
        System.out.println("Disconnected from server");
    }
}