package Personne;

import java.util.List;

public class Candidat extends Electeur implements Comparable<Candidat>{
    int nbVoies = 0;

    @Override
    public int compareTo(Candidat c) {
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
