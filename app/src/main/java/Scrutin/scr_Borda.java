package Scrutin;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Borda extends Scrutin{

    public scr_Borda(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
        //TODO Auto-generated constructor stu
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat(){
        // TODO Auto-generated method stub
        ArrayList<Candidat> candidates_res = new ArrayList<Candidat>(); // Résultat de la fonction
        return candidates_res;
    }

    
}
