package InteractionDynamique;

import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

public class interDyn_SocioPolitique implements InteractionDynamique{
    Double SeuilAttractionCandidats,
            SeuilRepulsionCandidats,
            SeuilAttractionElecteurs,
            DistanceParcourue;

    public interDyn_SocioPolitique(Double seuilAttractionCandidats, Double seuilRepulsionCandidats,
            Double seuilAttractionElecteurs, Double distanceParcourue) {
        SeuilAttractionCandidats = seuilAttractionCandidats;
        SeuilRepulsionCandidats = seuilRepulsionCandidats;
        SeuilAttractionElecteurs = seuilAttractionElecteurs;
        DistanceParcourue = distanceParcourue;
    }

    /**
     * Permet d'infulencer les électeurs selon le modèle Iznogoud
     * 
     * @param elects
     * @param cands
     */
    public void influencer(HashSet<Electeur> elects, HashSet<Candidat> cands) {
        for (Electeur e : elects) {
            Electeur cible = null;

            do {
                int randomRank = (int) (Math.random() * Double.valueOf(cands.size()) );                 
                if (Math.random() < Candidat.getPoidsCandidats()) // Si influencer par un Candidat
                    cible = (new ArrayList<Candidat>(cands)).get(randomRank);
                else // Si influencer par un autre Electeur
                    cible = (new ArrayList<Electeur>(elects)).get(randomRank);
            } while (cible == e);

            Double distanceToCible = e.getDistanceA(cible);
            if (cible instanceof Candidat) {
                if(distanceToCible < SeuilAttractionCandidats){
                    e.seDeplacerVers(cible, DistanceParcourue);
                }else if(distanceToCible > SeuilRepulsionCandidats){
                    e.seDeplacerVers(cible, -DistanceParcourue);
                }
            } else if (cible instanceof Electeur) {
                if(distanceToCible < SeuilAttractionElecteurs){
                    e.seDeplacerVers(cible, DistanceParcourue);
                }
            }
        }
    }
}
