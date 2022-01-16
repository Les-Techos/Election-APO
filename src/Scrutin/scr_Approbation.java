package Scrutin;

import java.util.List;
import java.util.ArrayList;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Approbation extends Scrutin{

    public scr_Approbation(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public List<Candidat> getClassementCandidat(){
        List<Candidat> candidats_res = new ArrayList<Candidat>(); //Résultat de l'élection

        for(Electeur e : electeurs){
            List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); //Candidats restants à chaque étape
            while(candidates_disponibles.size() > 0){
                //if(e.isNearBy(candidates_disponibles.get(0)))
            }
        }
        

        return candidats_res;
    }
}
