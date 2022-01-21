package InteractionDynamique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import Personne.Candidat;
import Personne.Electeur;

public class inter_SocioPolitique {
    Double SeuilAttractionCandidats,
            SeuilRepulsionCandidats,
            SeuilAttractionElecteurs,
            DistanceParcourue;

    public inter_SocioPolitique(Double seuilAttractionCandidats, Double seuilRepulsionCandidats,
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

            Double y1 = e.getEcologie().getValeur(), y2 = cible.getEcologie().getValeur(),
                    x1 = e.getPouvoir_achat().getValeur(), x2 = cible.getPouvoir_achat().getValeur();

            // Utilise Thales pour déterminer les rapports de longueur à aplliquer
            Double distance = e.getDistanceA(cible);
            Double coeff = DistanceParcourue / e.getDistanceA(cible);

            if (distance < SeuilAttractionCandidats) {
                x1 += coeff * (x2 - x1);
                y1 += coeff * (y2 - y1);
            } else if (distance > SeuilRepulsionCandidats) {
                x1 -= coeff * (x2 - x1);
                y1 -= coeff * (y2 - y1);
            }

            // Vérifie les bornes
            if (x1 < 0)
                x1 = 0.00;
            if (x1 > 1)
                x1 = 1.00;
            if (y1 < 0)
                y1 = 0.00;
            if (y1 > 1)
                y1 = 1.00;

            e.getPouvoir_achat().setValeur(x1);
            e.getEcologie().setValeur(y1);
        }
    }
}
