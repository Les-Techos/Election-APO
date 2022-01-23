package Simulation;
import Personne.*;
import Scrutin.*;
import InteractionDynamique.*;
import utils.SaveManager;

import java.util.ArrayList;
import java.util.HashSet;

public class Simulation {
    private HashSet<Candidat> c;
    private HashSet<Electeur> e;
    private Scrutin sa;
    private InteractionDynamique ID;
    
    public Simulation(){
        this.c = new HashSet<Candidat>();
        this.e = new HashSet<Electeur>();
        HashSet<Electeur> e = new HashSet<Electeur>();

        for(int i = 0; i < 10; i++){
            try{
                c.add(new Candidat(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
            
            try{
                e.add(new Electeur(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
        }
        
        System.out.println("Liste candidat"+c);
        System.out.println("Liste Electeur"+e);
    }
    public Simulation(HashSet<Candidat> c,HashSet<Electeur> e){
        this.c = c;
        this.e = e;
    }
    
    // choix du mode scrutin
    public void choixScrutin(int choix){    
        switch (choix){
            case 0:
                sa = new scr_Majoritaire_1tour(this.e,this.c);
                break;
            case 1:
                sa = new scr_Majoritaire_2tour(this.e,this.c);
                break;
            case 2:
                sa = new scr_Alternatif(this.e,this.c);
                break;
            case 3:
                sa = new scr_Approbation(this.e,this.c);
                break;
            case 4:
                sa = new scr_Borda(this.e,this.c);
                break;   
        }  
    }

    public void interraction_social(){
        
    }

    public ArrayList<Candidat> Lancerelection(){ 
        ArrayList<Candidat> res = null;
        try{
            res = sa.getClassementCandidat();   
        }catch(Exception e){
            System.out.println("Scrutin  non choisie");
        }
        return res;
    }
}
