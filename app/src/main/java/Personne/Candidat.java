package Personne;

import java.util.HashSet;

public class Candidat extends Electeur implements Comparable<Candidat> {
    int nbVoies = 0;

    @Override
    public int compareTo(Candidat c) {
        if (c instanceof Candidat) {
            return nbVoies - ((Candidat) c).nbVoies;
        }
        return 0;
    }

    public Candidat(double p_a, double eco) throws IllegalArgumentException {
        super(p_a, eco);
    }

    public Candidat(String st){
        super(st);
        String[] value = st.split(",");
        this.nbVoies = Integer.parseInt(value[2]);
    }

    public int getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(int nbVoies) throws IllegalArgumentException {
        if(nbVoies < 0) throw new IllegalArgumentException("Nombre de voies négatif");
        this.nbVoies = nbVoies;
    }

    public static void resetNbVoies(HashSet<Candidat> candidats) {
        for (Candidat c : candidats)
            try{c.setNbVoies(0);}catch(Exception e){}
    }

    public static HashSet<Candidat> cloneList(HashSet<Candidat> ls) {
        HashSet<Candidat> res = new HashSet<Candidat>(); // Résultat de la fCandidat au élection
        for (Candidat c : ls)
            res.add((Candidat) c.clone());
        return res;
    }

    @Override
    public Object clone(){
        try {
            Candidat c = new Candidat(pouvoir_achat.getValeur(), ecologie.getValeur());
            c.setNbVoies(getNbVoies());
            return c;
        } catch (Exception err) { return null;}
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "   NbVoies : " + nbVoies + "\n\n";
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + nbVoies;
    }

}
