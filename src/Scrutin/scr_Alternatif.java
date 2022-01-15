package Scrutin;

import java.util.ArrayList;
import java.util.List;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Alternatif extends Scrutin {

    @Override
    public List<Candidat> getClassementCandidat(final List<Electeur> electeurs, final List<Candidat> candidats) throws Exception {
        try{ verifieTableaux(electeurs, candidats); } catch(Exception e){ throw e;} //Vérifie si les List sont vides

        List<Candidat> candidates_res = new ArrayList<Candidat>(); //Résultat de l'élection
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); //Candidats restants à chaque étape
        
        while(candidates_disponibles.size() > 0){ //Tant qu'il reste plus d'un candidats potentiel
            for(Electeur e : electeurs){ //On laisse les électeurs voter
                Candidat c = e.votePour(candidates_disponibles);
                c.setNbVoies(c.getNbVoies() + 1);
            }

            int classement_candidat = candidates_disponibles.size() - 1;
            Candidat dernier_candidat = candidates_disponibles.get(classement_candidat);

            candidates_res.set(classement_candidat, dernier_candidat);
            candidates_disponibles.remove(dernier_candidat);
        }
        
        return candidates_res;
    }    
}
