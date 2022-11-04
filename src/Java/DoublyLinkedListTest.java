package Java;

import Java.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testToString() {
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println(dll.toString());
    }

    @Test
    void testAppend() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        assertEquals(1, dll.append(a1).album.ID);
        System.out.println(dll.toString());

        Album a2 = new Album(2, artistNames, "album 2", 2);
        assertEquals(2, dll.append(a2).album.ID);
        System.out.println(dll.toString());

        Album a3 = new Album(3, artistNames, "album 3", 3);
        assertEquals(3, dll.append(a3).album.ID);
        System.out.println(dll.toString());

        assertEquals(1, dll.head.album.ID);
        assertEquals("NULL <--> 1 <--> 2 <--> 3 <--> NULL", dll.toString());
    }

    @Test
    void testGetIndex() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        //APPENDING 2 ALBUMS TO DLL
        Album a1 = new Album(1, artistNames, "album 1", 1);
        assertEquals(1, dll.append(a1).album.ID);
        System.out.println(dll.toString());

        Album a2 = new Album(2, artistNames, "album 2", 2);
        assertEquals(2, dll.append(a2).album.ID);
        System.out.println(dll.toString());

        //INITIALIZING 3rd ALBUM BUT NOT APPENDING TO DLL
        Album a3 = new Album(3, artistNames, "album 3", 3);

        int a3Index = dll.getIndex(a3);
        assertEquals(-1, a3Index);
        System.out.println(a3Index);
        assertEquals(1, dll.getIndex(a1));
        System.out.println(dll.getIndex(a1));
        assertEquals(2, dll.getIndex(a2));
        System.out.println(dll.getIndex(a2));
    }

    @Test
    void testInsert() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        //EMPTY LIST
        Album a1 = new Album(1, artistNames, "album 1", 5);
        dll.insert(0, a1);
        System.out.println(dll.toString());
        assertEquals("NULL <--> 1 <--> NULL", dll.toString());

        //SMALL LIST
        Album a2 = new Album(2, artistNames, "album 2", 12);
        dll.insert(1, a2);
        System.out.println(dll.toString());
        assertEquals("NULL <--> 1 <--> 2 <--> NULL", dll.toString());

        Album a3 = new Album(3, artistNames, "album 3", 12);
        dll.insert(0, a3);
        System.out.println(dll.toString());
        assertEquals("NULL <--> 3 <--> 1 <--> 2 <--> NULL", dll.toString());

        Album a4 = new Album(4, artistNames, "album 4", 12);
        dll.insert(1, a4);
        System.out.println(dll.toString());
        assertEquals("NULL <--> 3 <--> 4 <--> 1 <--> 2 <--> NULL", dll.toString());

        //throws an exception because location 21 is out of bounds for current list
        Album a5 = new Album(4, artistNames, "album 5", 12);
        dll.insert(21, a5);
    }
}
