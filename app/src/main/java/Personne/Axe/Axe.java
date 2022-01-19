package Personne.Axe;

import Personne.CSVReady;

public class Axe extends CSVReady{
    private String nom;
    private double valeur;


    /*
        Constructeur de l'axe 
        
    */
    public Axe(String nom, double valeur) throws IllegalArgumentException{
        this.nom = nom;
        this.setValeur(valeur);
    }

    public Axe(String nom, String valeur){
        super(valeur);
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) throws IllegalArgumentException{
        if(valeur < 0.0 || valeur > 1.0) throw new IllegalArgumentException("Valeur hors des bornes");
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Axe [nom=" + nom + ", valeur=" + valeur + "]";
    }

    @Override
    public String toCSVString() {
        return String.valueOf(valeur);
    }

    
}