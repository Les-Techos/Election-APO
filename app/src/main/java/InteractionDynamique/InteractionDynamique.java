package InteractionDynamique;

import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

/**
 * Interface pour interaction dynamique
 */
public interface InteractionDynamique{
    /**
     * Influence (Modifie) les électeurs en fonction d'eux mêmes et des candidats 
     * @param e : Electeurs à influencer
     * @param c : Candidats à partir desquels influencer les électeurs "e"
     * @throws Exception : Liste vide
     */
    public void influencer(HashSet<Electeur> e, HashSet<Candidat> c) throws Exception;
}