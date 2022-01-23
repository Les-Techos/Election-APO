package InteractionDynamique;

import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

interface InteractionDynamique{
    public void influencer(HashSet<Electeur> e, HashSet<Candidat> c) throws Exception;
}