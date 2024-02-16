import java.util.*;

public class Coordinator extends Member {
    private List<Member> activeMembers;

    public Coordinator(String id, Socket socket) {
        super(id, socket);
        this.activeMembers = new ArrayList<>();
    }

    public void maintainState() {
        // This method should be called periodically (e.g., every 20 seconds)
        // to check the state of active group members. You could implement this
        // using a Timer or ScheduledExecutorService.

        // For now, let's just print out the IDs of the active members
        System.out.println("Active members:");
        for (Member member : activeMembers) {
            System.out.println(member.getId());
        }
    }

    public String handleDetailsRequest() {
        // This method should return the details of all active members,
        // including their IDs, IP addresses, and ports. For now, let's just
        // return a string with their IDs.

        StringBuilder details = new StringBuilder();
        for (Member member : activeMembers) {
            details.append(member.getId()).append("\n");
        }
        return details.toString();
    }

    public void addMember(Member member) {
        activeMembers.add(member);
    }

    public void removeMember(Member member) {
        activeMembers.remove(member);
    }
}
