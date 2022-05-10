package klasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bayes {
    List<Map<String,Integer>> mozliweStany = new ArrayList<>();
    double elementAmount;
    public Bayes( List<Element> treningData) {

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

        elementAmount = treningData.size();
    }

    public void wypiszWagi(){

        System.out.println("Poszczególne warianty wartości danych z ich ilością:");
        for (int i = 0; i < mozliweStany.size(); i++) {
            System.out.print(i+1 + " | ");
            for (Map.Entry<String, Integer> entry : mozliweStany.get(i).entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + "(" +String.valueOf(entry.getValue()*100/elementAmount).substring(0,5) +"%) / ");
            }
            System.out.println();

        }
    }

}
