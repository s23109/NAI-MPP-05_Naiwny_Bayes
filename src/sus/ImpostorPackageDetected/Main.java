package sus.ImpostorPackageDetected;

import klasy.Element;
import klasy.FileOperations;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String treningDataPath = "Pliki zadania\\agaricus-lepiota.data.txt";
        String testDataPath = "Pliki zadania\\agaricus-lepiota.test.data.txt";
        final List<Element> treningData = FileOperations.create_list(treningDataPath);
        final List<Element> testData = FileOperations.create_list(testDataPath);
        System.out.println("Trening data size : "+ treningData.size());
        System.out.println("Test data size : "+ testData.size());
        System.out.println("=====================================");
        //==========================================================

        //szerokość słowa + ile jest różnych kombinacji typu słowa



    }
}
