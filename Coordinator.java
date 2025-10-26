import java.io.IOException;
import java.util.*;
// import statements
public class Coordinator extends Member {
    private List<Member> activeMembers;

    public Coordinator(String id, String ipAddress, int port) throws IOException {
        super(id, ipAddress, port);
        this.activeMembers = new ArrayList<>();
    }

    public void maintainState() {
        System.out.println("Active members:");
        for (Member member : activeMembers) {
            System.out.println(member.toString());
        }
    }

    public String handleDetailsRequest() {
        StringBuilder details = new StringBuilder();
        for (Member member : activeMembers) {
            details.append(member.toString()).append("\n");
        }
        return details.toString();
    }

    public void addMember(Member member) {
        activeMembers.add(member);
    }
// void functions
    public void removeMember(Member member) {
        activeMembers.remove(member);
    }
}
