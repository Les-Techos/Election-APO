package Scrutin;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Majoritaire_2tour extends Scrutin{

    public scr_Majoritaire_2tour(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Candidat> getClassementCandidat(){
        // TODO Auto-generated method stub
        
        List<Candidat> candidates_res2t = new ArrayList<Candidat>(); // Résultat de la fonction
        
        List<Candidat> candidates_res1t = new ArrayList<Candidat>();
        List<Candidat> candidates_2best = new ArrayList<Candidat>();
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); // Candidat au éléction

        for (Electeur e : electeurs) {// for each des electeurs
            Candidat c = e.votePour(candidates_disponibles);
            c.setNbVoies(c.getNbVoies() + 1);
        }
        // trouve le candidat avec le plus de voies
        
        int classement_candidat = candidates_disponibles.size();
        Candidat dernier_candidat = Collections.max(candidates_disponibles);  
        candidates_res1t.set(classement_candidat, dernier_candidat);
        

        for (Electeur e : electeurs) {// for each des electeurs
            Candidat c = e.votePour(candidates_res1t);
            c.setNbVoies(c.getNbVoies() + 1);
        }
        int classement_candidat_2t = candidates_disponibles.size();
        Candidat dernier_candidat_2t = Collections.max(candidates_disponibles);  
        candidates_res2t.set(classement_candidat, dernier_candidat);

        return candidates_res2t;
    }
    
}
