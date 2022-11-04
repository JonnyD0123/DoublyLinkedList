package Java;

import Java.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void createNode(){
        Album album = new Album(1, "title", 12);
        Node node = new Node(album);
        assertEquals("ID: 1 NUM_SONGS: 12 -- ARTIST NAMES: Artist Names Not Added", node.toString());
    }
}
