package Scrutin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Personne.*;

public abstract class Scrutin {

    protected HashSet<Electeur> electeurs = null;
    protected HashSet<Candidat> candidats = null;

    public Scrutin(final HashSet<Electeur> electeurs, final HashSet<Candidat> candidats) throws Exception{
        try {
            verifieTableaux(electeurs, candidats);
        } catch (Exception e) {
            throw e;
        } // Vérifie si les List sont vides
        this.electeurs = new HashSet<Electeur>(electeurs);
        this.candidats = new HashSet<Candidat>(candidats);
    }

    /**
     * Vérifie que les listes d'électeurs et de candidats ne sont pas vides
     * @param electeurs : electeurs
     * @param candidats : candidats
     * @throws Exception : Un des tableau est vide
     */
    public void verifieTableaux(final HashSet<Electeur> electeurs, final HashSet<Candidat> candidats) throws Exception{
        if(electeurs.size() == 0) throw new Exception("Tableau d'électeurs vide");
        if(candidats.size() == 0) throw new Exception("Tableau de candidats vide");
    }

    /**
     * @return Les electeurs
     */
    public abstract ArrayList<Candidat> getClassementCandidat();
   
    public HashSet<Electeur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(HashSet<Electeur> electeurs) {
        this.electeurs = electeurs;
    }

    public HashSet<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(HashSet<Candidat> candidats) {
        this.candidats = candidats;
    }
}
