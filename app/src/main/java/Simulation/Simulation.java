package Simulation;

import Personne.*;
import Scrutin.*;
import InteractionDynamique.*;
import utils.SaveManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Simulation {
    private InteractionDynamique interraction = null;
    private int jourDinfluence = 0;
    private HashSet<Candidat> c;
    private HashSet<Electeur> e;
    private Scrutin sa;

    modeSondage ms = modeSondage.Simple;

      /**
     * Getter et Setter des listes candidats et electeurs
     */

    public HashSet<Candidat> getC() {
        return c;
    }

    public void setC(HashSet<Candidat> c) {
        this.c = c;
    }

    public HashSet<Electeur> getE() {
        return e;
    }

    public void setE(HashSet<Electeur> e) {
        this.e = e;
    }

    public int getJourDinfluence() {
        return jourDinfluence;
    }

    public void setJourDinfluence(int jourDinfluence) {
        this.jourDinfluence = jourDinfluence;
    }


   

    public void setSa(Scrutin sa) {
        this.sa = sa;
    }
// simulation sans paramétre permet de générer les 10 candidats aléatoirement comme les 100 electeurs
    public Simulation() {
        this.c = new HashSet<Candidat>();
        this.e = new HashSet<Electeur>();

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                try {
                    this.c.add(new Candidat(Math.random(), Math.random()));
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
            try {
                this.e.add(new Electeur(Math.random(), Math.random()));
            } catch (Exception err) {
                err.printStackTrace();
            }
        }

        System.out.println("---Liste candidat--- \n");
        int i = 0;
        for (Candidat c_res : c) {
            i++;
            System.out.println("Candidat " + i);
            System.out.println(c_res.toString());
            System.out.println("-------------------------");
        }

    }



    // simulation quand en rentrant des paramétres
    public Simulation(HashSet<Candidat> c, HashSet<Electeur> e) {
        this.c = c;
        this.e = e;
    }

    // choix du mode scrutin
    public Scrutin choixScrutin(int choix) {
        switch (choix) {
            case 0:
                sa = new scr_Majoritaire_1tour(this.e, this.c);
                System.out.println("Vous avez choisi le scrutin majoritaire 1 tour \n");
                break;
            case 1:
                sa = new scr_Majoritaire_2tour(this.e, this.c);
                System.out.println("Vous avez choisi le scrutin majoritaire 2 tour \n");
                break;
            case 2:
                sa = new scr_Alternatif(this.e, this.c);
                System.out.println("Vous avez choisi le scrutin Alternatif \n");
                break;
            case 3:
                sa = new scr_Approbation(this.e, this.c);
                System.out.println("Vous avez choisi le scrutin par Approbation \n");
                break;
            case 4:
                sa = new scr_Borda(this.e, this.c);
                System.out.println("Vous avez choisi le scrutin par méthode de borda \n");
                break;
            case 5:

                break;
        }
        return sa;
    }

    // choix du mode de sondage
    public modeSondage choix_mode(int choixsondage) {
        switch (choixsondage) {
            case 0:
                ms = modeSondage.Simple;
                break;
            case 1:
                ms = modeSondage.utilite;
                break;
            case 2:
                ms = modeSondage.utilite_multiple;
                break;
        }
        return ms;
    }

    // creer l'interraction social
    public void interraction_social(Double seuilAttractionCandidats, Double seuilRepulsionCandidats,
            Double seuilAttractionElecteurs, Double distanceParcourue) throws Exception {
        interraction = new interDyn_SocioPolitique(seuilAttractionCandidats, seuilRepulsionCandidats,
                seuilAttractionElecteurs, distanceParcourue);
    }

    // creer l'interraction par sondage
    public void interraction_sondage(int nbsonde) throws Exception {
        interraction = new interDyn_Sondage(sa.getClass(), ms, this.c.size(), nbsonde);
    }

    // influencer sur n_jour
    public void influencer_sur_n(int n) throws Exception {
        for (int i = 0; i < n; i++) {
            interraction.influencer(this.e, this.c);
        }
    }

    public void sauvegarde(String path) throws Exception {
        SaveManager.saveIterableTo(this.e, path);
    }

      /**
     * Permet depuis la Simulation de lancer une election et renvoyer le String qui sera afficher dans les deux intefaces différentes
     */
    public String LancerElection() {
        String res = "---Resultat de l'election--- \n";
        ArrayList<Candidat> liste_res = null;
        try {

            if (interraction != null) {
                HashMap<Integer, ArrayList<Integer>> resElection = new HashMap<Integer, ArrayList<Integer>>();

                for (Candidat candid_avant_influence : sa.getClassementCandidat()) {
                    ArrayList<Integer> nbVoies_avant_influence = new ArrayList<>();
                    nbVoies_avant_influence.add(candid_avant_influence.getNbVoies());
                    resElection.put(candid_avant_influence.getCustom_hashCode(), nbVoies_avant_influence);
                }

                influencer_sur_n(jourDinfluence);

                for (Candidat candid_avant_influence : (sa.getClassementCandidat())) {
                    ArrayList<Integer> nombreDeVoies_candidat = resElection
                            .get(candid_avant_influence.getCustom_hashCode());
                    nombreDeVoies_candidat.add(candid_avant_influence.getNbVoies());
                }

                for (Integer candids_finis : resElection.keySet()) {
                    res += "n°" + candids_finis + " Candidat " + " avec (avant/après) : ("
                            + resElection.get(candids_finis).get(0) + "/" + resElection.get(candids_finis).get(1)
                            + ") de voies \n";
                }
            } else {
                for (Candidat r : sa.getClassementCandidat()) {
                    res += "n°" + r.getCustom_hashCode() + " Candidat avec " + r.getNbVoies() + "\n";
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }





    // Les méthodes ToString  permette les test  et le débugage 
    @Override
    public String toString() {
        return "Simulation [c=" + c.size() + ", e=" + e.size() + ", interraction=" + interraction + ", Type de scrutin="
                + sa + "]";
    }
    public String getSa() {
        return sa.toString();
    }
}
