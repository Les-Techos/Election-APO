package Personne;

import Personne.Axe.Axe;

import java.util.ArrayList;
import java.util.List;

public class Electeur implements Personne, Cloneable {
    private static double distanceMax = 0.5;
    Axe pouvoir_achat, ecologie;
    

    public Electeur(double p_a, double eco) throws Exception {
        try{
            this.pouvoir_achat = new Axe("pouvoir d'achat", p_a);
            this.ecologie = new Axe("ecologie", eco);
        }catch(Exception e){
            throw e;
        }
    }

    public double getDistanceA(final Electeur p){
        return Math.sqrt( 
            Math.pow(pouvoir_achat.getValeur() - p.pouvoir_achat.getValeur(), 2) 
        +   Math.pow(ecologie.getValeur() - p.ecologie.getValeur(), 2));
    }

    public boolean isNearBy(final Electeur p){
        return getDistanceA(p) < distanceMax;
    }

    public Candidat votePour(List<Candidat> candidats){ /* A compléter !*/
        Candidat choisi = null;
        double distanceMin = Double.POSITIVE_INFINITY;

        for(Candidat c : candidats){
            double currDistance = getDistanceA(c);
            if(isNearBy(c) && currDistance < distanceMin){
                choisi = c;
                distanceMin = currDistance;
            }
        }

        return choisi;
    }
    
    public static double getDistanceMax() {
        return distanceMax;
    }

    public static void setDistanceMax(double distanceMax) {
        Electeur.distanceMax = distanceMax;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        try{
            Electeur e = new Electeur(pouvoir_achat.getValeur(), ecologie.getValeur());
            return e;
        }catch(Exception err) {throw new CloneNotSupportedException(err.getMessage());}
    }

    @Override
    public String toString() {
        return "\n" + this.getClass() + "\n"+
            "   ecologie=" + ecologie + "\n" + 
            "   pouvoir_achat=" + pouvoir_achat;
    }
}
