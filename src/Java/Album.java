package Java;

import com.sun.jdi.LocalVariable;

import java.util.ArrayList;

public class Album implements Comparable<Album>{

protected int ID;
protected ArrayList<String> artistNames;
protected String title;
protected Integer numSongs;

public Album(int ID, ArrayList<String> artistNames, String title, Integer numSongs) {
        this.ID = ID;
        this.artistNames = artistNames;
        this.title = title;
        this.numSongs = numSongs;
}

public Album(int ID, String title, Integer numSongs){
        this.ID = ID;
        this.title = title;
        this.numSongs = numSongs;
}


@Override
public int compareTo(Album a) {
    int result = -2;
    if(this.numSongs == a.numSongs) result = 0;
    if(this.numSongs < a.numSongs) result = -1;
    if(this.numSongs > a.numSongs) result = 1;
    return result;
}

@Override
public String toString() {
        StringBuilder stb = new StringBuilder();
        stb = stb.append("ID: " + this.ID);
        stb = stb.append(" NUM_SONGS: " + this.numSongs);
        stb = stb.append(" -- ARTIST NAMES: ");
        if(artistNames != null) stb = stb.append(artistNames.toString());
        else stb = stb.append("Artist Names Not Added");
        return stb.toString();
}

}
