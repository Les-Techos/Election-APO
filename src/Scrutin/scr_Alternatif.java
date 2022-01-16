package Scrutin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Alternatif extends Scrutin {
   
    public scr_Alternatif(List<Electeur> electeurs, List<Candidat> candidats) throws Exception {
        super(electeurs, candidats);
    }

    @Override
    public List<Candidat> getClassementCandidat(){

        List<Candidat> candidates_res = new ArrayList<Candidat>(); //Résultat de l'élection
        List<Candidat> candidates_disponibles = new ArrayList<Candidat>(candidats); //Candidats restants à chaque étape
        TreeMap<Candidat, List<Electeur>> candidatToElecteur = new TreeMap<Candidat, List<Electeur>>(); //Arbre Associant un candidat à ses électeurs

 

        Collections.sort(candidates_res, Collections.reverseOrder()); //Renverse la liste pour obtenir un classement par décroissance
        return candidates_res;
    }   
}
