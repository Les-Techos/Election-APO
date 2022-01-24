package InteractionDynamique;

import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

public interface InteractionDynamique{
    public void influencer(HashSet<Electeur> e, HashSet<Candidat> c) throws Exception;
}