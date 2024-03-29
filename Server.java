import java.io.*;
import java.net.*;
import java.util.*;
//creating server class
public class Server {
    private int port;
    private ServerSocket serverSocket;
    private List<Member> members;

    public Server(int port) {
        this.port = port;
        this.members = new ArrayList<>();
    }

    public void start() throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New member connected");

            // Assign a unique ID to the new member
            String id = UUID.randomUUID().toString();

            // Create a new Member object for the new member
            Member member = new Member(id, socket);

            // Add the new member to the list of active members
            this.members.add(member);

            // Start a new thread for handling communication with the new member
            new Thread(new MemberHandler(member)).start();
        }
    }

    public void broadcast(String message) {
        for (Member member : members) {
            member.sendMessage(message);
        }
    }

    public void removeMember(Member member) {
        members.remove(member);
        System.out.println("Member " + member.getId() + " has disconnected");
    }

    private class MemberHandler implements Runnable {
        private Member member;

        public MemberHandler(Member member) {
            this.member = member;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(member.getSocket().getInputStream()));
                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message from " + member.getId() + ": " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                removeMember(member);
            }
        }
    }
    public static void main(String[] args) {
        int port = 1234;
        Server server = new Server(port);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}