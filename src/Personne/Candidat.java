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

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        try{
            Candidat c = new Candidat(pouvoir_achat.getValeur(), ecologie.getValeur());
            c.setNbVoies(getNbVoies());
            return c;
        }catch(Exception err) {throw new CloneNotSupportedException(err.getMessage());}
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\n" + 
            "   NbVoies : " + nbVoies + "\n\n";
    }
}
