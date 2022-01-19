package Scrutin;

import java.util.ArrayList;
import Personne.Candidat;
import Personne.Electeur;
import java.util.Collections;
import java.util.HashSet;

public class scr_Majoritaire_1tour extends Scrutin {

   

    public scr_Majoritaire_1tour(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException{
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat() {
        HashSet<Candidat> candidates_disponibles = Candidat.cloneList(candidats);

        for (Electeur e : electeurs) {// for each des electeurs
            Candidat c = e.votePour(candidates_disponibles);
            c.setNbVoies(c.getNbVoies() + 1);
        }
        // trouve le candidat avec le plus de voies par ordre croissant et le trie par ordre décroissant avec reverse order
        ArrayList<Candidat> candidates_res = new ArrayList<Candidat>(candidates_disponibles); // Résultat de la fonction
        Collections.sort(candidates_res,Collections.reverseOrder());  
       
        return candidates_res;
    }

}
