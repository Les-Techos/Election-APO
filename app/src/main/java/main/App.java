package main;

import java.util.HashSet;
import java.util.List;

import InteractionDynamique.interDyn_SocioPolitique;
import InteractionDynamique.interDyn_Sondage;
import InteractionDynamique.modeSondage;
import Interface.Interfacegraph;
import Interface.Interfacetext;
import Personne.*;
import Scrutin.*;
import Simulation.Simulation;
import utils.SaveManager;

public class App {
    public static void main(String[] args) throws Exception{
        
        Interfacegraph fenetre = new Interfacegraph();
        fenetre.setVisible(true);
        //Interfacetext i = new Interfacetext();
        //i.demarer();
        /*
       
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
        
        Scrutin sa = new scr_Alternatif(e, c); 
        List<Candidat> res = sa.getClassementCandidat();
        try{
            SaveManager.saveIterableTo(res, "ressources/rezultat_1.txt");
            SaveManager.saveIterableTo(c, "ressources/cand_1.txt");
            SaveManager.saveIterableTo(e, "ressources/elect_1.txt");
        }catch(Exception err){

        }
        
        interDyn_Sondage<scr_Alternatif> infl = new interDyn_Sondage<>(scr_Alternatif.class ,modeSondage.Simple, c.size(), e.size()/2);
        try{
            infl.influencer(e, c);
        }catch(Exception err){
            System.out.println("Err le constructeur du scrutin n'existe pas !");
        }

        sa = new scr_Alternatif(e, c); 
        res = sa.getClassementCandidat();
        try{
            SaveManager.saveIterableTo(res, "ressources/rezultat_2.txt");
            SaveManager.saveIterableTo(c, "ressources/cand_2.txt");
            SaveManager.saveIterableTo(e, "ressources/elect_2.txt");
        }catch(Exception err){

        }
        
        System.out.println(res);
    }*/
}
}
