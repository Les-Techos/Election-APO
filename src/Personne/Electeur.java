package Personne;

import Personne.Axe.Axe;

public class Electeur implements Personne {
    private static double appetance = 0.5;
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
        return getDistanceA(p) < appetance;
    }

    public static double getAppetance() {
        return appetance;
    }

    public static void setAppetance(double appetance) {
        Electeur.appetance = appetance;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass() + "[\n"+
            "   ecologie=" + ecologie + "\n" + 
            "   pouvoir_achat=" + pouvoir_achat + 
            "\n]";
    }
}
