package InteractionDynamique;

import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;
import Scrutin.Scrutin;

enum modeSondage{
    Simple,
    utilite,
    utilite_multiple
}

public class interDyn_Sondage implements InteractionDynamique{
    Class<Scrutin> scr = null;
    modeSondage ms = modeSondage.Simple;
    int nbCandidsModeSimple = -1;

    public interDyn_Sondage(Class<Scrutin> s, modeSondage mode, int nombreCandidatsModeSimple, int maxCandidatsSondage) {
        scr = s;
        ms = mode;
        nbCandidsModeSimple = maxCandidatsSondage;
    }

    @Override
    public void influencer(HashSet<Electeur> e, HashSet<Candidat> c) throws Exception{
        Scrutin s = scr.getDeclaredConstructor(HashSet.class, HashSet.class).newInstance(e,c);

        ArrayList<Candidat> candids = s.getClassementCandidat();

        for(Electeur elect : e){ 
            switch (ms) {
                case Simple:
                    deplacementSimple(elect,candids);
                    break;
                case utilite:
                    deplacementUtilite(elect,candids);
                break;
                case utilite_multiple:
                    deplacementUtiliteMultiple(elect,candids);
                break;
            
                default:
                    throw new Exception("Mode de Sondage incorrect");
            }
        }
    }

    private void deplacementSimple(Electeur e, ArrayList<Candidat> c){
        
    }

    private void deplacementUtilite(Electeur e, ArrayList<Candidat> c){
        
    }

    private void deplacementUtiliteMultiple(Electeur e, ArrayList<Candidat> c){
        
    }
    
}