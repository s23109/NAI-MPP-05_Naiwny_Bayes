package sus.ImpostorPackageDetected;

import klasy.Bayes;
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

        Bayes bayes = new Bayes(treningData);
        bayes.wypiszWagi();

        System.out.println("=====================================");

        //==========================================================
        //klasyfikacja , i od razu miary strzałów
        double TP=0 , TN=0 , FP=0, FN=0;

        for (Element testowy: testData) {

            //TODO: wylicz dla prawdy i fałszu
            //porównaj i sprawdź czy poprawnie


        }




    }
}
