import java.util.ArrayList;

import Personne.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Candidat> c = new ArrayList<Candidat>();
        ArrayList<Electeur> e = new ArrayList<Electeur>();
        try{
            for(int i = 0; i < 10; i++){
                c.add(new Candidat(Math.random(),Math.random()));
                e.add(new Electeur(Math.random(),Math.random()));
            }
            for(Electeur elect : e){
                System.out.println(elect);System.out.println(elect.votePour(c));
            }
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}
