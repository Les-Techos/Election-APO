package Scrutin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import Personne.Candidat;
import Personne.Electeur;

/**
 * Scrutin Alternatif
 */
public class scr_Alternatif extends Scrutin {

    public scr_Alternatif(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException{
        super(electeurs, candidats);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat() {

        HashSet<Candidat> candidates_res; // Résultat de l'élection
        HashSet<Candidat> candidates_disponibles = Candidat.cloneList(candidats);
        HashMap<Candidat, HashSet<Electeur>> candidatToElecteur = new HashMap<Candidat, HashSet<Electeur>>(); // Arbre
                                                                                                        // Associant un
                                                                                                        // candidat à
                                                                                                        // ses électeurs

        candidates_res = getClassementCandidat_rec(candidates_disponibles, electeurs, candidatToElecteur);

        ArrayList<Candidat> res = new ArrayList<>(candidates_res);
        Collections.sort(res, Collections.reverseOrder()); // Renverse la liste pour obtenir un classement
                                                                      // par décroissance
        return res;
    }

    /**
     * Retourne le classement des candidats par récursivité
     * @param candidates_disponibles : Candidats disponibles au rang de récursion
     * @param electeurs : électeurs
     * @param candidatToElecteur : Map de candidats vers ses électeurs
     * @return : Le classement des candidats
     */
    public HashSet<Candidat> getClassementCandidat_rec(HashSet<Candidat> candidates_disponibles, final HashSet<Electeur> electeurs,
    HashMap<Candidat, HashSet<Electeur>> candidatToElecteur) {
        HashSet<Candidat> candidates_res = new HashSet<Candidat>();

        if (candidates_disponibles.size() == 0)
            return candidates_res;

        if (electeurs != null) {
            for (Electeur e : electeurs) { // On fait voter tout les candidats
                Candidat choisi = e.votePour(candidates_disponibles); // On récupère le choix de e
                if (choisi != null) { // Si n'est pas null
                    choisi.setNbVoies(choisi.getNbVoies() + 1); // On incrémente les voies du choisi
                    
                    HashSet<Electeur> votants;// On récupère les votants de choisi
                    if (!candidatToElecteur.containsKey(choisi)) { // Si la liste n'existe pas
                        votants = new HashSet<Electeur>(); // On la créer
                        votants.add(e); // On ajoute juste le votants
                        candidatToElecteur.put(choisi, votants); // on insère cette liste
                    } else{
                        votants = candidatToElecteur.get(choisi);
                        votants.add(e); // On ajoute juste le votants
                    }
                        
                    assert votants.size() == choisi.getNbVoies() : "Le candidats choisi a un nombre de votants différent de son nombre de voies";
                }
            }
        }

        Candidat dernier = Collections.min(candidates_disponibles);
        //dernier.setNbVoies(0);
        candidates_res.add(dernier);
        candidates_disponibles.remove(dernier);

        HashSet<Electeur> electeursDuDernier = candidatToElecteur.get(dernier);

        candidates_res.addAll(
                getClassementCandidat_rec(candidates_disponibles, electeursDuDernier, candidatToElecteur));

        return candidates_res;
    }
}
