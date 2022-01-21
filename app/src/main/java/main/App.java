package main;

import java.util.HashSet;
import java.util.List;

import Personne.*;
import Scrutin.*;
import utils.SaveManager;

public class App {
    public static void main(String[] args){
        HashSet<Candidat> c = new HashSet<Candidat>();
        HashSet<Electeur> e = new HashSet<Electeur>();
      
        for (int i = 0; i < 5; i++) {
            try{
                c.add(new Candidat(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
        }
        for (int i = 0; i < 19; i++) {
            try{
                e.add(new Electeur(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
        }
        
        Scrutin sa = new scr_Borda(e, c);  

        List<Candidat> res = sa.getClassementCandidat();
        
        try{
            SaveManager.saveIterableTo(res, "ressources/rezultat.txt");
            SaveManager.saveIterableTo(c, "ressources/cand.txt");
            SaveManager.saveIterableTo(e, "ressources/elect.txt");
        }catch(Exception err){

        }
        
        System.out.println(res);
    }
}
