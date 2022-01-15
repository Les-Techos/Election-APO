package Scrutin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Alternatif extends Scrutin {
   
    public scr_Alternatif(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public List<Candidat> getClassementCandidat(){

        List<Candidat> candidates_res = new ArrayList<Candidat>(); //Résultat de l'élection
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); //Candidats restants à chaque étape
        
        while(candidates_disponibles.size() > 0){ //Tant qu'il reste plus d'un candidats potentiel
            for(Electeur e : electeurs){ //On laisse les électeurs voter
                Candidat c = e.votePour(candidates_disponibles);
                c.setNbVoies(c.getNbVoies() + 1);
            }

            Candidat dernier_candidat = Collections.min(candidates_disponibles);

            candidates_res.add(dernier_candidat);
            candidates_disponibles.remove(dernier_candidat);
        }
        
        return candidates_res;
    }   
}
