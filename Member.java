import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class Member {
    private String id;
    private String ipAddress;
    private int port;
    private Socket socket;
    private PrintWriter writer;

    public Member(String id, String ipAddress, int port) throws IOException {
        this.id = id;
        this.ipAddress = ipAddress;
        this.port = port;
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(),true);
    }
    public Member(String id, Socket socket) throws IOException {
        this.id = id;
        this.socket = socket;
        this.writer = new PrintWriter(this.socket.getOutputStream(), true);
    }
    public Socket getSocket() {
        return this.socket;
    }
    public void sendMessage(String message) {
        writer.println(message);
    }
    public void disconnect() throws IOException {
        socket.close();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
// over-ride function
    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }
}
