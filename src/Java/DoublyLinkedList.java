package Java;

public class DoublyLinkedList <T> {
    Node head;
    Node tail;

    public DoublyLinkedList(){}

    public DoublyLinkedList append(Album newAlbum) {
        Node toAppend = new Node(newAlbum);
        if(this.head == null){
            this.head = toAppend;
            this.head.next = tail;
            this.head.prev = null;
        } else {
            Node tempNode = this.head;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = toAppend;
            toAppend.next = tail;
        }
        return this;
    }

    public DoublyLinkedList insert(int location, Album newAlbum) {
        Node toInsert = new Node<>(newAlbum);
        if(this.head == null){
            this.head = toInsert;
            if(location > 0) System.out.println("Inserting into an Empty List");
        } else {
            int loc = 1;
            Node tempNode = this.head;
            while((loc < (location-1)) && (tempNode.next!=null)) {
                tempNode = tempNode.next;
                loc++;
            }
            toInsert.next = tempNode.next;
            tempNode.next = toInsert;
            toInsert.prev = tempNode;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("NULL <--> ");
        } else {
            Node toPrint = head;
            sb.append("NULL <--> ");
            while (toPrint != null) {
                sb = sb.append(toPrint.album);
                sb = sb.append(" <--> ");
                toPrint = toPrint.next;
            }
        }
        sb = sb.append("NULL");
        return sb.toString();
    }
}
