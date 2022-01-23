package InteractionDynamique;

import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;
import Scrutin.Scrutin;
import Scrutin.scr_Alternatif;
import Scrutin.scr_Sondage;


public class interDyn_Sondage<Scrutin_Type extends Scrutin> implements InteractionDynamique {
    Class<Scrutin_Type> scr;
    modeSondage ms = modeSondage.Simple;
    int nbCandidatsChoixElecteur;
    int nbSondes;

    public interDyn_Sondage(Class<Scrutin_Type> scr, modeSondage ms, int nbCandidatsChoixElecteur, int nbSondes) {
        this.scr = scr;
        this.ms = ms;
        this.nbCandidatsChoixElecteur = nbCandidatsChoixElecteur;
        this.nbSondes = nbSondes;
    }

    @Override
    public void influencer(HashSet<Electeur> e, HashSet<Candidat> c) throws Exception {

        scr_Sondage<Scrutin_Type> sondage = new scr_Sondage<>(e,c,scr,nbSondes);

        ArrayList<Candidat> candids = sondage.getClassementCandidat(); // Récupère le classement des candidats par les sondés
        candids = new ArrayList<Candidat>(candids.subList(0, nbCandidatsChoixElecteur - 1)); // Récupère la tête de liste

        for (Electeur elect : e) { // On influence les électeurs
            Candidat choisi = elect.votePour(new HashSet<Candidat>(candids));
            switch (ms) { // Suivant le mode selectionné
                case Simple:
                    deplacementSimple(elect, choisi);
                    break;
                case utilite:
                    deplacementUtilite(elect, candids, e.size());
                    break;
                case utilite_multiple:
                    deplacementUtiliteMultiple(elect, candids, e.size());
                    break;

                default:
                    throw new Exception("Mode de Sondage incorrect");
            }
        }
    }

    private void deplacementSimple(Electeur e, Candidat choisi) {
        e.seDeplacerVers(choisi, e.getDistanceA(choisi) / 4);
    }

    private void deplacementUtilite(Electeur e, ArrayList<Candidat> candids, int nbElecteurs) {
        Double utilite = 0.00;
        Candidat choisi = getCandidatAvecUtilite(e, candids, nbElecteurs, utilite);
        e.seDeplacerVers(choisi, e.getDistanceA(choisi) / 4);
    }

    private void deplacementUtiliteMultiple(Electeur e, ArrayList<Candidat> candids, int nbElecteurs) {
        Double utilite = 0.00;
        Candidat choisi = getCandidatAvecUtilite(e, candids, nbElecteurs, utilite);
        e.seDeplacerVers(choisi, utilite * e.getDistanceA(choisi));
    }

    private Candidat getCandidatAvecUtilite(Electeur e, ArrayList<Candidat> candids, int nbElecteurs, Double utilieMax){
        Candidat res = null;

        for(Candidat c : candids){
            Double utilite = c.getNbVoies() / (nbElecteurs * e.getDistanceA(c));
            if(utilite > utilieMax){
                res = c;
                utilieMax = utilite;
            }
        }
        return res;
    }

    public modeSondage getMs() {
        return ms;
    }

    public void setMs(modeSondage ms) {
        this.ms = ms;
    }

    public int getNbCandidsModeSimple() {
        return nbCandidatsChoixElecteur;
    }

    public void setNbCandidsModeSimple(int nbCandidsModeSimple) {
        this.nbCandidatsChoixElecteur = nbCandidsModeSimple;
    }

    public int getNbSondes() {
        return nbSondes;
    }

    public void setNbSondes(int nbSondes) {
        this.nbSondes = nbSondes;
    }

}