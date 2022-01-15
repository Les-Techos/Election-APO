package Personne;

import java.util.Comparator;
import java.util.List;

import Personne.Axe.*;

public class Candidat extends Electeur implements Comparable{
    int nbVoies = 0;

    @Override
    public int compareTo(Object c) {
        // TODO Auto-generated method stub
        if(c instanceof Candidat){
            return nbVoies - ((Candidat)c).nbVoies;
        }
        return 0;
    }

    public Candidat(double p_a, double eco) throws Exception {
        super(p_a, eco);
    }

    public int getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(int nbVoies) {
        this.nbVoies = nbVoies;
    }

    public static void resetNbVoies(List<Candidat> candidats){
        for(Candidat c : candidats) c.setNbVoies(0);
    }
}
