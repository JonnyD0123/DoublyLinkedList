package Java;

public class DoublyLinkedList <T extends Comparable<T>> {
    Node head;
    Node tail;

    public DoublyLinkedList(){}

    public Node append(Album album) {
        Node toAppend = new Node(album);
        if(this.head == null){
            this.head = toAppend;
            this.tail = toAppend;
        } else {
            toAppend.prev = tail;
            tail.next = toAppend;
            tail = tail.next;
        }
        return toAppend;
    }

    public Node insert(int location, Album album) throws IllegalArgumentException {
        Node toInsert = new Node<>(album);
        if(this.head == null){
            this.head = toInsert;
            this.tail = toInsert;
            if(location != 0) throw new IllegalArgumentException("Inserting into an Empty List");
        } else {
            if(location==0){
                toInsert.next = this.head;
                this.head = toInsert;
            } else {
                try {
                    if(location < 0) throw new IllegalArgumentException("Location is out of bounds for current list");
                } catch (IllegalArgumentException e) {
                    System.out.println("Location is Out of Bounds");
                }
                int loc = 1;
                Node tempNode = this.head;
                while((loc < (location-1)) && (tempNode.next!=null)) {
                    tempNode = tempNode.next;
                    loc++;
                }
                if(tempNode.next == null){
                    int length = this.getIndex(tempNode.album);
                    try {
                        if(location > length) throw new IllegalArgumentException("Location is out of bounds for current list");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Location is Out of Bounds");
                    }
                }
                toInsert.next = tempNode.next;
                tempNode.next = toInsert;
                toInsert.prev = tempNode;
            }
        }
        return toInsert;
    }

    public Node delete(int location) throws IllegalArgumentException {
        try{
            if(this.head==null) throw new IllegalArgumentException("Cannot delete a node from an empty list");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty List");
        }

        Node tempNode = this.head;
        if(location==0) {
            tempNode.album = null;
        }
        return tempNode;
    }

    public int getIndex(Album album) {
        int index = 1;
        if(this.head==null){
            index = -1;
            System.out.println("Empty List");
        } else {
            Node tempNode = this.head;
            while(tempNode != null){
                if(tempNode.album.compareTo(album)==0) return index;
                if(tempNode.next == null && tempNode.album.compareTo(album)!=0) {
                    System.out.println("Album not found in list");
                    return index = -1;
                } else{
                    tempNode = tempNode.next;
                    index++;
                }
            }
        }
        return index;
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
                sb = sb.append(toPrint.album.ID);
                sb = sb.append(" <--> ");
                toPrint = toPrint.next;
            }
        }
        sb = sb.append("NULL");
        return sb.toString();
    }
}
