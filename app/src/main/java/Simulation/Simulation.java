package Simulation;
import Personne.*;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Candidat> c;
    private ArrayList<Electeur> e;

    public Simulation(){
        this.c = new ArrayList<Candidat>();
        this.e = new ArrayList<Electeur>();
        ArrayList<Electeur> e = new ArrayList<Electeur>();

        for(int i = 0; i < 10; i++){
            try{
                c.add(new Candidat(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
            
            try{
                e.add(new Electeur(Math.random(),Math.random()));
            }catch(Exception err){err.printStackTrace();}
        }
        
        System.out.println("Liste candidat"+c);
        System.out.println("Liste Electeur"+c);
    }
    public Simulation(ArrayList<Candidat> c,ArrayList<Electeur> e){

    }
    
}
