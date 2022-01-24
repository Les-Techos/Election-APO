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
    modeSondage ms = modeSondage.Simple;
    
    public HashSet<Candidat> getC() {
        return c;
    }
    public void setC(HashSet<Candidat> c) {
        this.c = c;
    }
    public HashSet<Electeur> getE() {
        return e;
    }
    public void setE(HashSet<Electeur> e) {
        this.e = e;
    }

    private Scrutin sa;
    private InteractionDynamique interraction;
    
    
    public Simulation(){
        this.c = new HashSet<Candidat>();
        this.e = new HashSet<Electeur>();
        HashSet<Electeur> e = new HashSet<Electeur>();

        for(int i = 0; i < 10; i++){
            try{
                this.c.add(new Candidat(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
            
            try{
                this.e.add(new Electeur(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
        }
        
        System.out.println("Liste candidat"+c);
        System.out.println("Liste Electeur"+e);
    }
    @Override
    public String toString() {
        return "Simulation [c=" + c.size() + ", e=" + e.size() + ", interraction=" + interraction + ", sa=" + sa + "]";
    }
    public Simulation(HashSet<Candidat> c,HashSet<Electeur> e){
        this.c = c;
        this.e = e;
    }
    
    // choix du mode scrutin
    public Scrutin choixScrutin(int choix){    
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
            case 5:
                
                break;
        }  
        return sa;
    }
        // choix du mode de sondage
    public modeSondage choix_mode(int choixsondage){    
        switch(choixsondage){
            case 0:
                ms = modeSondage.Simple; 
            break;
            case 1:
                ms = modeSondage.utilite;
            break;
            case 2:
                ms = modeSondage.utilite_multiple;
            break;
        }
        return ms;
    }
// creer l'interraction social 
    public void interraction_social(Double seuilAttractionCandidats, Double seuilRepulsionCandidats,
    Double seuilAttractionElecteurs, Double distanceParcourue) throws Exception{
        interraction = new interDyn_SocioPolitique( seuilAttractionCandidats, seuilRepulsionCandidats,
        seuilAttractionElecteurs, distanceParcourue);
    }

    public void interraction_sondage(int nbsonde) throws Exception {
        interraction = new interDyn_Sondage(sa.getClass(), ms,this.c.size(),nbsonde);
        interraction.influencer(this.e,this.c);
    }

// influencer sur n_jour
    public void influencer_sur_n(int n) throws Exception{
        for(int i=0; i<n; i++){
            interraction.influencer(this.e, this.c);
        }
    }
    public void sauvegarde(String path) throws Exception{
        SaveManager.saveIterableTo(this.e, path);
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
