import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Friend {
    private String name;
    private Collection<Friend> friends;

    public Friend(String name) {
        this.name = name;
        this.friends = new ArrayList<Friend>();
    }

    public String getName() {
        return name;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        LinkedList<Friend> visited = new LinkedList<Friend>();
        visited.add(this);
        return checkFriendConnection(friend, visited);
    }

    public boolean checkFriendConnection(Friend friend, LinkedList<Friend> visited) {
        if(friends.contains(friend))
            return true;

        Iterator<Friend> it = friends.iterator();
        while(it.hasNext()) {
            Friend curr = it.next();

            if(visited.contains(curr))
                continue;
            else {
                visited.add(curr);
                if(curr.checkFriendConnection(friend, visited));
                    return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Friend alice = new Friend("Alice");
        Friend bob = new Friend("Bob");
        Friend candice = new Friend("Candice");

        alice.addFriendship(bob);
        bob.addFriendship(candice);

        System.out.println(alice.canBeConnected(candice));
    }
}