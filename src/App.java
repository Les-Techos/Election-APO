import Personne.*;

public class App {
    public static void main(String[] args) throws Exception {
        Candidat p;
        Electeur p2;
        try{
            p = new Candidat(0.5, 0.5);
            p2 = new Electeur(0.1, 0.1);
            if(p.isNearBy(p2)) System.out.println("Il sont tout près");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
