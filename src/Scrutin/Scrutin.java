package Scrutin;

import java.util.List;

import Personne.*;

public abstract class Scrutin {

    public Scrutin() {
    }
    
    public void verifieTableaux(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception{
        if(electeurs.size() == 0) throw new Exception("Tableau d'électeurs vide");
        if(candidats.size() == 0) throw new Exception("Tableau de candidats vide");
    }

    public abstract List<Candidat> getClassementCandidat(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception;
}
