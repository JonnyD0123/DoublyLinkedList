package Java;

import jdk.jfr.Percentage;

import java.util.ArrayList;
import java.util.Collections;

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
            try {
                if(location != 0) throw new IllegalArgumentException("Inserting into an Empty List");
            } catch (IllegalArgumentException e) {
                System.out.println("Empty List");
            }
            this.head = toInsert;
            this.tail = toInsert;
        } else {
            if(location==0){
                toInsert.next = this.head;
                this.head = toInsert;
            } else {
                if(location < 0) {
                    try {
                        throw new IllegalArgumentException("Location is out of bounds for current list");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Location Cannot Be Negative");
                    }
                }
                int loc = 1;
                Node tempNode = this.head;
                while((loc < (location)) && (tempNode.next!=null)) {
                    tempNode = tempNode.next;
                    loc++;
                }
                if(tempNode.next == null){
                    int length = this.getIndex(tempNode.album)+1;
                    if(location > length+1) {
                        try {
                            throw new IllegalArgumentException("Location is out of bounds for current list");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Location is Out of Bounds");
                        }
                    }
                    toInsert.next = tempNode.next;
                    tempNode.next = toInsert;
                }
            }
        }
        return toInsert;
    }

    public Node delete(int location) throws IllegalArgumentException {
        Node tempNode = this.head;
        if(tempNode==null) {
            try{
                throw new IllegalArgumentException("Cannot delete a node from an empty list");
            } catch (IllegalArgumentException e) {
                System.out.println("Empty List");
            }
        } else if(location < 0) {
            try {
                throw new IllegalArgumentException("Location is out of bounds for current list");
            } catch (IllegalArgumentException e) {
                System.out.println("Location Cannot Be Negative");
            }
        } else if(location==0){this.head = this.head.next;}
                else {
                int loc = 1;
                while((loc < (location)) && (tempNode.next!=null)) {
                    tempNode = tempNode.next;
                    loc++;
                }
                if(tempNode.next == null){
                    int length = this.getIndex(tempNode.album);
                    if(location > length){
                        try {
                            throw new IllegalArgumentException("Location is out of bounds for current list");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Location is Out of Bounds");
                        }
                    }
                } else {
                    tempNode.next = tempNode.next.next;
                    tempNode.next.next.prev = tempNode;
                }
            }
        return tempNode;
    }

    public Node shuffle() {
        Node tempNode = this.head;
        if (tempNode == null) {
            try {
                throw new IllegalArgumentException("Cannot shuffle nodes from an empty list");
            } catch (IllegalArgumentException e) {
                System.out.println("Empty List");
            }
        } else {
           ArrayList<Album> arr = new ArrayList<>();
           while(tempNode!=null){
               arr.add(tempNode.album);
               tempNode = tempNode.next;
           }
           int tmp = arr.size() - (arr.size()%2);
            for(int i=0; i < tmp; i=i+2){
                Collections.swap(arr, i, i+1);
            }
            tempNode = this.head;
            for(int i=0; i<arr.size(); i++){
                tempNode.album = arr.get(i);
                tempNode = tempNode.next;
            }
        }
        return this.head;
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
