package Personne;

import java.util.HashSet;

public class Candidat extends Electeur implements Comparable<Candidat> {
    int nbVoies = 0;
    static double poidsCandidats = 0.00;

    @Override
    public int compareTo(Candidat c) {
        if (c instanceof Candidat) {
            return nbVoies - ((Candidat) c).nbVoies;
        }
        return 0;
    }

    

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Candidat)) return false;
        Candidat other = (Candidat) obj;
        return super.equals((Electeur)obj) && nbVoies == other.nbVoies;
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
        for (Candidat c : ls){
            res.add((Candidat) c.clone());
        }
            
            
        return res;
    }

    @Override
    public Object clone(){
        try {
            Candidat c = new Candidat(pouvoir_achat.getValeur(), ecologie.getValeur());
            c.setNbVoies(getNbVoies());
            c.setCustom_hashCode(getCustom_hashCode());
            return c;
        } catch (Exception err) { return null;}
    }

    @Override
    public String toString() {
        return super.toString()  +
                "   NbVoies : " + nbVoies + "\n\n";
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + nbVoies;
    }

    public static double getPoidsCandidats() {
        return poidsCandidats;
    }

    public static void setPoidsCandidats(double poidsCandidats) throws IllegalArgumentException{
        if(poidsCandidats < 0 || poidsCandidats > 1) throw new IllegalArgumentException("Poids candidats hors limites");
        Candidat.poidsCandidats = poidsCandidats;
    }

}
