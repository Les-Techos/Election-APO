package Scrutin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

/**
 * Scrutin par approbation
 */

public class scr_Approbation extends Scrutin{

    public scr_Approbation(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException{
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat(){
        HashSet<Candidat> candidats_res = Candidat.cloneList(candidats); //Résultat de l'élection

        for(Electeur e : electeurs){
            HashSet<Candidat> candidates_disponibles = new HashSet<>(candidats_res);
            int nbVotes = (int) (Math.random() * (double) candidates_disponibles.size());
            for(int i = 0; i < nbVotes; i++){
                Candidat choisi = e.votePour(candidates_disponibles);
                choisi.setNbVoies(choisi.getNbVoies() + 1);
                candidates_disponibles.remove(choisi);
            }
        }
        
        ArrayList<Candidat> res = new ArrayList<Candidat>(candidats_res);
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}
