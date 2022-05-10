package klasy;

import java.util.ArrayList;
import java.util.List;

public class Element {

    String name;
    List<String> params = new ArrayList<>();


    public Element(String line) {
        String [] table = line.split(",");
        this.name= table[0];
        for (int i = 1; i < table.length; i++) {
            params.add(table[i]);
        }

    }
}
