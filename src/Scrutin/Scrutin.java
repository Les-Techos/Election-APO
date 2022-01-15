package Scrutin;

import java.util.List;

import Personne.*;

public abstract class Scrutin {

    private List<Electeur> electeurs = null;
    private List<Candidat> candidats = null;

    public Scrutin(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception{
            this.electeurs = electeurs;
            this.candidats = candidats;
            try {
                verifieTableaux(electeurs, candidats);
            } catch (Exception e) {
                throw e;
            } // Vérifie si les List sont vides

    }

    
    public void verifieTableaux(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception{
        if(electeurs.size() == 0) throw new Exception("Tableau d'électeurs vide");
        if(candidats.size() == 0) throw new Exception("Tableau de candidats vide");
    }

    public abstract List<Candidat> getClassementCandidat();
   
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
