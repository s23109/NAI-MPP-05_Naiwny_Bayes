package sus.ImpostorPackageDetected;

import klasy.Element;
import klasy.FileOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Dane wstępne

        String treningDataPath = "Pliki zadania\\agaricus-lepiota.data.txt";
        String testDataPath = "Pliki zadania\\agaricus-lepiota.test.data.txt";


        //==========================================================
        // Listy + czytanie z pliku
        final List<Element> treningData = FileOperations.create_list(treningDataPath);
        final List<Element> testData = FileOperations.create_list(testDataPath);
        System.out.println("Trening data size : "+ treningData.size());
        System.out.println("Test data size : "+ testData.size());
        System.out.println("=====================================");
        //==========================================================

        //szerokość słowa + ile jest różnych kombinacji typu słowa

        List<Map<String,Integer>> mozliweStany = new ArrayList<>();

        for (int i = 0; i < treningData.get(0).params.size(); i++) {
            mozliweStany.add(new HashMap<>());
        }


        for (Element element : treningData) {


            for (int i = 0; i < element.params.size(); i++) {

                if (mozliweStany.get(i).containsKey(element.params.get(i))){
                    //ma już typ , zmień jej wartość na +1
                    mozliweStany.get(i).put(element.params.get(i),mozliweStany.get(i).get(element.params.get(i))+1);
                }
                else {
                    //dodaj typ , ustaw ilość na 1
                    mozliweStany.get(i).put(element.params.get(i),1);
                }

            }


        }

        System.out.println("Poszczególne warianty wartości danych z ich ilością:");

        for (int i = 0; i < mozliweStany.size(); i++) {
            System.out.print(i+1 + " | ");
            for (Map.Entry<String, Integer> entry : mozliweStany.get(i).entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
            }
            System.out.println();

        }

        System.out.println("=====================================");
        //==========================================================

    }
}
