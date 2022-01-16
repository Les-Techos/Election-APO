package Scrutin;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Approbation extends Scrutin{

    public scr_Approbation(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat(){
        ArrayList<Candidat> candidats_res = new ArrayList<Candidat>(); //Résultat de l'élection

        for(Electeur e : electeurs){
            HashSet<Candidat> candidates_disponibles = Candidat.cloneList(candidats);
            int nbVotes = (int) (Math.random() * (double) candidates_disponibles.size());
            for(int i = 0; i < nbVotes; i++){
                Candidat choisi = e.votePour(candidates_disponibles);
                choisi.setNbVoies(choisi.getNbVoies() + 1);
                candidates_disponibles.remove(choisi);
            }
        }
        
        return candidats_res;
    }
}
