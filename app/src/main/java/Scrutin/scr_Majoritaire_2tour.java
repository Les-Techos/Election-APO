package Scrutin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import Personne.Candidat;
import Personne.Electeur;

/**
 * Scrutin Majoritaire à 2 tours
 */
public class scr_Majoritaire_2tour extends Scrutin{

    public scr_Majoritaire_2tour(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException{ 
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat(){
        Scrutin sc1t =null;

        try {
        sc1t = new scr_Majoritaire_1tour(electeurs, candidats);
        }
        catch (Exception e) {} // on est jamais censé rentrer dedans
        
        List<Candidat> candidates_res1t = sc1t.getClassementCandidat();
        HashSet<Candidat> candidates_2best = new HashSet<Candidat>();
        
        
        candidates_2best.add(candidates_res1t.get(0));
        candidates_2best.add(candidates_res1t.get(1));

        try {
        sc1t = new scr_Majoritaire_1tour(electeurs, candidates_2best);
        }
        catch (Exception e) {} // on est jamais censé rentrer dedans
    
        return sc1t.getClassementCandidat();
    }
    
}
