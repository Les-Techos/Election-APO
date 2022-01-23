package Scrutin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import Personne.Candidat;
import Personne.Electeur;

/**
 * Scrutin suivant la méthode de Borda
 */
public class scr_Borda extends Scrutin{

    public scr_Borda(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException{
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat(){
        HashSet<Candidat> candidates_dispo = Candidat.cloneList(candidats);
        for (Electeur e : electeurs) {
            for (int i=candidates_dispo.size();i>0;i--){
                Candidat c = e.votePour(candidates_dispo);
                c.setNbVoies(c.getNbVoies() + i);
            }
        }
        ArrayList<Candidat> candidates_res = new ArrayList<Candidat>(candidates_dispo); // Résultat de la fonction
        Collections.sort(candidates_res,Collections.reverseOrder()); 
        
        return candidates_res;
    }    
}
