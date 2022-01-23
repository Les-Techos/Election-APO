package Personne;

import Personne.Axe.Axe;

import java.util.HashSet;

public class Electeur extends CSVReady implements Cloneable{
    private static double distanceMax = 3;
    final Axe pouvoir_achat, ecologie;

    public Electeur(double p_a, double eco) throws IllegalArgumentException {
        this.pouvoir_achat = new Axe("pouvoir d'achat", p_a);
        this.ecologie = new Axe("ecologie", eco);
    }

    public Electeur(String st) throws IllegalArgumentException {
        super(st);
        String[] value = st.split(",");
        this.pouvoir_achat = new Axe("pouvoir d'achat", Double.parseDouble(value[0]));
        this.ecologie = new Axe("ecologie", Double.parseDouble(value[1]));
    }

    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Electeur)) {return false;}
        Electeur other = (Electeur) obj;
        return (pouvoir_achat.getValeur() == other.getPouvoir_achat().getValeur() && 
                ecologie.getValeur() == other.getEcologie().getValeur());
    }

    public double getDistanceA(final Electeur p) {
        return Math.sqrt(
                Math.pow(pouvoir_achat.getValeur() - p.pouvoir_achat.getValeur(), 2)
                        + Math.pow(ecologie.getValeur() - p.ecologie.getValeur(), 2));
    }

    public boolean isNearBy(final Electeur p) {
        return getDistanceA(p) < distanceMax;
    }

    public Candidat votePour(HashSet<Candidat> candidats) { /* A compléter ! */
        Candidat choisi = null;
        double distanceMin = Double.POSITIVE_INFINITY;

        for (Candidat c : candidats) {
            double currDistance = getDistanceA(c);
            if (isNearBy(c) && currDistance < distanceMin) {
                choisi = c;
                distanceMin = currDistance;
            }
        }

        return choisi;
    }

    public void seDeplacerVers(Electeur cible, Double distanceAParcourir) {
        Double y1 = getEcologie().getValeur(), y2 = cible.getEcologie().getValeur(),
                x1 = getPouvoir_achat().getValeur(), x2 = cible.getPouvoir_achat().getValeur();

        // Utilise Thales pour déterminer les rapports de longueur à aplliquer
        Double coeff = distanceAParcourir / getDistanceA(cible);

        // TODO Traiter le seuil de répulsion électeurs

        x1 += coeff * (x2 - x1);
        y1 += coeff * (y2 - y1);

        // Vérifie les bornes
        if (x1 < 0)
            x1 = 0.00;
        if (x1 > 1)
            x1 = 1.00;
        if (y1 < 0)
            y1 = 0.00;
        if (y1 > 1)
            y1 = 1.00;

        getPouvoir_achat().setValeur(x1);
        getEcologie().setValeur(y1);
    }

    public static double getDistanceMax() {
        return distanceMax;
    }

    public static void setDistanceMax(double distanceMax) throws IllegalArgumentException {
        if (distanceMax < 0)
            throw new IllegalArgumentException("ditanceMax négative");
        Electeur.distanceMax = distanceMax;
    }

    @Override
    protected Object clone() {
        Electeur e = null;
        try {
            e = new Electeur(pouvoir_achat.getValeur(), ecologie.getValeur());
        } catch (Exception err) {
        }

        return e;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass() + "\n" +
                "   ecologie=" + ecologie + "\n" +
                "   pouvoir_achat=" + pouvoir_achat;
    }

    @Override
    public String toCSVString() {
        return pouvoir_achat.toCSVString() + "," + ecologie.toCSVString();
    }

    public Axe getPouvoir_achat() {
        return pouvoir_achat;
    }

    public Axe getEcologie() {
        return ecologie;
    }
}
