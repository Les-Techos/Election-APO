package Scrutin;

import java.util.List;

import Personne.*;

public abstract class Scrutin {

    private List<Electeur> electeurs = null;
    private List<Candidat> candidats = null;

    public Scrutin(final List<Electeur> electeurs, final List<Candidat> candidats) {

    }

    public Scrutin() {
    }
    
    public void verifieTableaux(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception{
        if(electeurs.size() == 0) throw new Exception("Tableau d'électeurs vide");
        if(candidats.size() == 0) throw new Exception("Tableau de candidats vide");
    }

    public abstract List<Candidat> getClassementCandidat();
    public abstract List<Candidat> getClassementCandidat(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception;

    public List<Electeur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(List<Electeur> electeurs) {
        this.electeurs = electeurs;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }
}
