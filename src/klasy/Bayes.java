package klasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bayes {
    List<Map<String,Integer>> mozliweStany = new ArrayList<>();
    List<Map<String,Integer>> stanyZIlosciaTrujacych = new ArrayList<>();
    double elementAmount;
    public Bayes( List<Element> treningData) {

        for (int i = 0; i < treningData.get(0).params.size(); i++) {
            mozliweStany.add(new HashMap<>());
            stanyZIlosciaTrujacych.add(new HashMap<>());
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

            if (element.name.equals("p")){
                for (int i = 0; i < element.params.size(); i++) {
                    if (stanyZIlosciaTrujacych.get(i).containsKey(element.params.get(i))){
                        //ma już typ , zmień jej wartość na +1
                        stanyZIlosciaTrujacych.get(i).put(element.params.get(i),stanyZIlosciaTrujacych.get(i).get(element.params.get(i))+1);
                    }
                    else {
                        //dodaj typ , ustaw ilość na 1
                        stanyZIlosciaTrujacych.get(i).put(element.params.get(i),1);
                    }
                }
            }

        }

        elementAmount = treningData.size();
    }

    public void wypiszWagi(){

        System.out.println("Poszczególne warianty wartości danych z ich ilością dla wszystkich:");
        for (int i = 0; i < mozliweStany.size(); i++) {
            System.out.print(i+1 + " | ");
            for (Map.Entry<String, Integer> entry : mozliweStany.get(i).entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + "(" +String.valueOf(entry.getValue()*100/elementAmount).substring(0,5) +"%) / ");
            }
            System.out.println();

        }
    }

    public void wypiszWagiTrujacych(){

        System.out.println("Poszczególne warianty wartości danych z ich ilością wyłącznie dla trujących:");
        for (int i = 0; i < stanyZIlosciaTrujacych.size(); i++) {
            System.out.print(i+1 + " | ");
            for (Map.Entry<String, Integer> entry : stanyZIlosciaTrujacych.get(i).entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + "(" +String.valueOf(entry.getValue()*100/elementAmount).substring(0,5) +"%) / ");
            }
            System.out.println();

        }
    }

    public boolean wyznaczCzyTrujacy(Element element){

        double trujacy = PrawdopodobieństwoZdarzenia(element,"p");
        double jadalny = PrawdopodobieństwoZdarzenia(element,"e");

        if (trujacy>jadalny) return true;
        else return false;

    }


    private double PrawdopodobieństwoZdarzenia (Element element , String oczekiwanaWartosc){

        double doRet = 1;

        for (int i = 0; i < element.params.size(); i++) {
            doRet*=PrawdoPodobieństwoElementu(i,element.params.get(i),oczekiwanaWartosc);
        }

        return doRet;
    }

    private double PrawdoPodobieństwoElementu ( int koordynatDanych, String wartoscParametru, String oczekiwanaWartosc){

        if (mozliweStany.get(koordynatDanych).containsKey(wartoscParametru)){
            //ma klucz, licz normalnie

            //prawdopodobieństwo fałszu? => z tablicy, ; prawdy => wylicz odwrotność

            if (oczekiwanaWartosc.equals("p")){
                //jeśli wyliczany trujący
                if (stanyZIlosciaTrujacych.get(koordynatDanych).containsKey(wartoscParametru)){
                    //fałsze istnieją -> z tablicy i gites
                    return (double)(stanyZIlosciaTrujacych.get(koordynatDanych).get(wartoscParametru)/elementAmount);
                }
                else {
                    //fałsze nie istnieją -> normalizacja
                    return (double) (1/mozliweStany.get(koordynatDanych).size()+2.0);
                }

            }
            //----------------------------------------------------------------
            else {
                // p normalne z wyliczonego (może nie być fałszy)
                try {
                    return (double)((mozliweStany.get(koordynatDanych).get(wartoscParametru)-stanyZIlosciaTrujacych.get(koordynatDanych).get(wartoscParametru))/elementAmount);
                }
                catch (NullPointerException e){
                    //jeśli nie ma fałszu -> to jest równy 0 -> można go ,,olać''
                    return (double)(mozliweStany.get(koordynatDanych).get(wartoscParametru)/elementAmount);
                }
            }



        }
        else {
            // nie ma elementu ogólnie, normalizacja?
            return (double) (1/mozliweStany.get(koordynatDanych).size()+2.0);
        }


    }






}
