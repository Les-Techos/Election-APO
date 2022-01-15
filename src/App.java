import java.util.ArrayList;

import Personne.*;
import Scrutin.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Candidat> c = new ArrayList<Candidat>();
        ArrayList<Electeur> e = new ArrayList<Electeur>();
        try{
            for(int i = 0; i < 10; i++){
                c.add(new Candidat(Math.random(),Math.random()));
                e.add(new Electeur(Math.random(),Math.random()));
            }
            scr_Alternatif sa = new scr_Alternatif();
            
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}
