package Personne.Axe;

import java.math.*;

public class Axe {
    private String nom;
    private double valeur;


    /*
        Constructeur de l'axe 
        
    */
    public Axe(String nom, double valeur) throws Exception{
        this.nom = nom;
        try{
            this.setValeur(valeur);
        }catch(Exception e){
            throw e;
        }
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) throws Exception{
        if (valeur < 0.0 || valeur > 1.0)
            throw new Exception("Valeur fournie dans l'axe " + nom + " invalide = " + valeur);
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Axe [nom=" + nom + ", valeur=" + valeur + "]";
    }
}