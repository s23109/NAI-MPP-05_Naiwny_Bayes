package klasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public static List<Element> create_list (String Path){

        BufferedReader treningdata = null;
        List <Element> returnList = new ArrayList<>();
        try {
            treningdata = new BufferedReader(new FileReader(Path));
            String line = new String();

            while ((line = treningdata.readLine()) != null){
                // System.out.println(line);
                returnList.add(new Element(line));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnList;

    }

}
