package InteractionDynamique;

import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

/**
 * Interacation Dynamique par relation Sociopolitique
 */
public class interDyn_SocioPolitique implements InteractionDynamique{
    Double SeuilAttractionCandidats,
            SeuilRepulsionCandidats,
            SeuilAttractionElecteurs,
            DistanceParcourue;
    /**
     * 
     * @param seuilAttractionCandidats : Distance jusqu'auquel les électeurs seront attiré par le candidat considéré
     * @param seuilRepulsionCandidats   : Distance à partir duquel les électeurs seront repoussés par le candidat
     * @param seuilAttractionElecteurs  : Distance jusqu'auquel les électeurs seront attiré par le électeurs considéré
     * @param distanceParcourue : La distance à parcourir lors d'un déplacement
     */
    public interDyn_SocioPolitique(Double seuilAttractionCandidats, Double seuilRepulsionCandidats,
            Double seuilAttractionElecteurs, Double distanceParcourue) {
        //TODO Utiliser des setters
        SeuilAttractionCandidats = seuilAttractionCandidats;
        SeuilRepulsionCandidats = seuilRepulsionCandidats;
        SeuilAttractionElecteurs = seuilAttractionElecteurs;
        DistanceParcourue = distanceParcourue;
    }

    /**
     * Permet d'infulencer les électeurs selon le modèle Iznogoud
     * 
     * @param elects : Electeurs à influencer
     * @param cands : Candidats depuis lesquels influencer les électeurs
     */
    @Override
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
