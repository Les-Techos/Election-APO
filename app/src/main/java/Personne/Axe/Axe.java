package Personne.Axe;

import Personne.CSVReady;

/**
 * Axe de préférence politique
 */
public class Axe extends CSVReady{
    private String nom;
    private double valeur;


    /**
     * 
     * @param nom : Nom de l'axe
     * @param valeur : Valeur de l'axe
     * @throws IllegalArgumentException : Valeur de l'axe en dehors de [0;1]
     */
    public Axe(String nom, double valeur) throws IllegalArgumentException{
        this.nom = nom;
        this.setValeur(valeur);
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