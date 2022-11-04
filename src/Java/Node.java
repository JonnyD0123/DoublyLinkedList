package Java;

public class Node <T> {
    Album album;
    Node prev;
    Node next;

    public Node(Album album){
        this.prev = null;
        this.next = null;
        this.album = album;
    }

    @Override
    public String toString() {
        return album.toString();
    }
}