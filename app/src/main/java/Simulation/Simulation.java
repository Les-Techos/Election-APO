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
        try{
            for(int i = 0; i < 10; i++){
                c.add(new Candidat(Math.random(),Math.random()));
                e.add(new Electeur(Math.random(),Math.random()));
            }
            
            System.out.println("Liste candidat"+c);
            System.out.println("Liste Electeur"+c);
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }
     public Simulation(ArrayList<Candidat> c,ArrayList<Electeur> e){

     }
    
}
