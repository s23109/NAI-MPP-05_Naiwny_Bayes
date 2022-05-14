package sus.ImpostorPackageDetected;

import klasy.Bayes;
import klasy.Element;
import klasy.FileOperations;
import klasy.Klasyfikacja;

import java.util.List;

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
        bayes.wypiszWagiTrujacych();

        System.out.println("=====================================");

        //==========================================================
        //klasyfikacja , i od razu miary strzałów
        Klasyfikacja klasyfikacja = new Klasyfikacja();

        for (Element testowy: testData) {

            //TODO: wylicz dla prawdy i fałszu

            if (!bayes.wyznaczCzyTrujacy(testowy)){
                //obstawia że jadalny

                if (testowy.name.equals("e")){
                    //zgadł
                    klasyfikacja.TP+=1;
                }
                else{
                    //obstawia że jadalny, a jest trujący
                    klasyfikacja.FP+=1;
                }

            }
            else {
                // obstawia że trujący
                if (testowy.name.equals("p")){
                    //zgadł
                    klasyfikacja.TN+=1;
                }
                else{
                    //obstawia że trujący, a jest jadalny
                    klasyfikacja.FN+=1;
                }

            }



        }

        klasyfikacja.PrintKlasyfikacja();


    }
}
