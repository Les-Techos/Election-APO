package Scrutin;

import java.util.List;
import java.util.ArrayList;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Borda extends Scrutin{

    public scr_Borda(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
        //TODO Auto-generated constructor stu
    }

    @Override
    public List<Candidat> getClassementCandidat(){
        // TODO Auto-generated method stub
        List<Candidat> candidates_res = new ArrayList<Candidat>(); // Résultat de la fonction
        return candidates_res;
    }

    
}
