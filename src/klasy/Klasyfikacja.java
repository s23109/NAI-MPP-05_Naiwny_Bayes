package klasy;

public class Klasyfikacja {

    public double TP , TN , FP, FN;

    public Klasyfikacja() {
         TP=0; TN=0 ; FP=0; FN=0;
    }


    //TODO: ACCURRACY, PRECISION , RECALL , F-SCORE

    public void PrintKlasyfikacja (){
        System.out.println("Miary Klasyfikacji : ");
        System.out.println("TP: "+TP +" | "+"TN: "+TN +" | "+"FP: "+FP +" | "+"FN: "+FN);
        System.out.println("ACCURRACY : " + ACCURRACY());
        System.out.println("PRECISION : " + PRECISION());
        System.out.println("RECALL : " + RECALL());
        System.out.println("F-SCORE : " + F_SCORE());
        System.out.println("=====================================");
    }


    public double ACCURRACY(){
        return (TP+TN)/(TP+TN+FP+FN);
    }

    public double PRECISION(){
        return TP/(TP+FP);
    }

    public double RECALL(){
        return TP/(TP+FN);
    }

    public double F_SCORE(){
        return (2*PRECISION()*RECALL())/(PRECISION()+RECALL());
    }

}
