package Scrutin;

import java.util.ArrayList;
import java.util.List;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Majoritaire_1tour extends Scrutin {

   

    public scr_Majoritaire_1tour(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public List<Candidat> getClassementCandidat() {
        
     

        List<Candidat> candidates_res = new ArrayList<Candidat>(); // Résultat de la fonction
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); // Candidat au éléction

        for (Electeur e : electeurs) {// for each des electeurs
            Candidat c = e.votePour(candidates_disponibles);
            c.setNbVoies(c.getNbVoies() + 1);
        }
        // trouve le candidat avec le plus de voies
        int classement_candidat = candidates_disponibles.size() - 1;
        Candidat dernier_candidat = candidates_disponibles.get(classement_candidat);

        candidates_res.set(classement_candidat, dernier_candidat);
        return candidates_res;

        
    }

}
