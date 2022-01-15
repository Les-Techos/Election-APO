package Scrutin;

import java.util.ArrayList;
import java.util.List;

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
        List<Candidat> candidates_res = new ArrayList<Candidat>(); // Résultat de la fonction
        return candidates_res;
    }
    
}
