package Scrutin;

import java.util.ArrayList;
import java.util.HashSet;

import Personne.Candidat;
import Personne.Electeur;

public class scr_Sondage<Scrutin_Type extends Scrutin> extends Scrutin{
    Class<Scrutin_Type> scr;
    ArrayList<Electeur> sondes = null;
    int nbSondes = 0;

    public scr_Sondage(HashSet<Electeur> electeurs, HashSet<Candidat> candidats) throws IllegalArgumentException {
        super(electeurs, candidats);
    }

    public scr_Sondage(HashSet<Electeur> electeurs, HashSet<Candidat> candidats, Class<Scrutin_Type> scr, int nbSondes) throws IllegalArgumentException {
        this(electeurs, candidats);
        setScr(scr);
        setNbSondes(nbSondes);
    }

    @Override
    public ArrayList<Candidat> getClassementCandidat() {
        ArrayList<Electeur> electDispo = new ArrayList<Electeur>(electeurs);
        sondes = new ArrayList<Electeur>();

        for (int i = 0; i < nbSondes; i++) { // Choisi aléatoirement des sondes parmis tous les electeurs
            int index = (int) Math.random() % electDispo.size();
            sondes.add(electDispo.get(index));
            electDispo.remove(index);
        }

        Scrutin s = null;
        try{
                s = scr.getDeclaredConstructor(HashSet.class, HashSet.class).newInstance(new HashSet<Electeur>(sondes), candidats); // Crée un Scrutin avec les sondés et le candidats
        }catch(Exception e){}


        return s.getClassementCandidat();
    }

    public Class<Scrutin_Type> getScr() {
        return scr;
    }

    public void setScr(Class<Scrutin_Type> scr) throws IllegalArgumentException{
        if(scr == null) throw new IllegalArgumentException("Scrutin vide");
        this.scr = scr;
    }

    public ArrayList<Electeur> getSondes() {
        return sondes;
    }

    public void setSondes(ArrayList<Electeur> sondes) {
        if(sondes.size() < 1) throw new IllegalArgumentException("Liste de sondés incorrect");
        this.sondes = sondes;
    }

    public int getNbSondes() {
        return nbSondes;
    }

    public void setNbSondes(int nbSondes) {
        if(nbSondes < 1) throw new IllegalArgumentException("Nombre de sondés incorrect");
        this.nbSondes = nbSondes;
    }
}
