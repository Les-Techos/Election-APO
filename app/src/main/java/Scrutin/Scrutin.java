package Scrutin;

import java.util.ArrayList;
import java.util.HashSet;
import Personne.*;

public abstract class Scrutin {

    protected HashSet<Electeur> electeurs = null;
    protected HashSet<Candidat> candidats = null;

    public Scrutin(final HashSet<Electeur> electeurs, final HashSet<Candidat> candidats) throws IllegalArgumentException{

        verifieTableau(electeurs);
        verifieTableau(candidats);
        
        this.electeurs = new HashSet<Electeur>(electeurs);
        this.candidats = new HashSet<Candidat>(candidats);
    }

    /**
     * Vérifie que les listes d'électeurs et de candidats ne sont pas vides
     * @param electeurs : electeurs
     * @param candidats : candidats
     */
    public void verifieTableau(final HashSet<?> set) throws IllegalArgumentException{
        if(set.size() == 0) throw new IllegalArgumentException("Tableau de taille nulle");
    }

    /**
     * @return Les electeurs
     */
    public abstract ArrayList<Candidat> getClassementCandidat();
   
    public HashSet<Electeur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(HashSet<Electeur> electeurs) throws IllegalArgumentException{
        verifieTableau(electeurs);
        this.electeurs = electeurs;
    }

    public HashSet<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(HashSet<Candidat> candidats) throws IllegalArgumentException{
        verifieTableau(candidats);
        this.candidats = candidats;
    }

}
