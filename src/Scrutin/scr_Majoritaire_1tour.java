package Scrutin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Personne.Candidat;
import Personne.Electeur;
import java.util.Collections;

public class scr_Majoritaire_1tour extends Scrutin {

   

    public scr_Majoritaire_1tour(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public List<Candidat> getClassementCandidat() {

        List<Candidat> candidates_res = new ArrayList<Candidat>(); // Résultat de la fonction
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(); // Résultat de la fCandidat au élection
        try{
            for(Candidat c : candidats) candidates_disponibles.add((Candidat)c.clone());
        }catch(CloneNotSupportedException e){}

        for (Electeur e : electeurs) {// for each des electeurs
            Candidat c = e.votePour(candidates_disponibles);
            c.setNbVoies(c.getNbVoies() + 1);
        }
        // trouve le candidat avec le plus de voies par ordre croissant et le trie par ordre décroissant avec reverse order
        Collections.sort(candidates_disponibles,Collections.reverseOrder());  
        candidates_res = candidates_disponibles;
       
        return candidates_res;
    }

}
