package main;
import java.util.HashSet;

import Personne.*;
import Scrutin.*;

public class App {
    public static void main(String[] args) throws Exception {
        HashSet<Candidat> c = new HashSet<Candidat>();
        HashSet<Electeur> e = new HashSet<Electeur>();
        try{
            for(int i = 0; i < 5; i++){
                c.add(new Candidat(Math.random(),Math.random()));
            }
            for(int i=0; i<19;i++){
                e.add(new Electeur(Math.random(),Math.random()));
            }
            Scrutin sa = new scr_Borda(e, c);
            System.out.println(sa.getClassementCandidat());
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}
