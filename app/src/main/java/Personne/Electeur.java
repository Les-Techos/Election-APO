package Personne;

import Personne.Axe.Axe;

import java.util.HashSet;

public class Electeur extends CSVReady implements Cloneable{
    int zoneGeographique = 0;
    private int custom_hashCode = 0;
    private static double distanceMax = 3;
    final Axe pouvoir_achat, ecologie;
    
    /**
     * 
     * @param p_a : pouvoir d'achat
     * @param eco : ecologie
     * @throws IllegalArgumentException
     */
    public Electeur(double p_a, double eco) throws IllegalArgumentException {
        custom_hashCode = hashCode();
        this.pouvoir_achat = new Axe("pouvoir d'achat", p_a);
        this.ecologie = new Axe("ecologie", eco);
    }

    public Electeur(String st) throws IllegalArgumentException {
        super(st);
        custom_hashCode = hashCode();
        String[] value = st.split(",");
        this.pouvoir_achat = new Axe("pouvoir d'achat", Double.parseDouble(value[0]));
        this.ecologie = new Axe("ecologie", Double.parseDouble(value[1]));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Electeur)) {return false;}
        Electeur other = (Electeur) obj;
        return (hashCode() == other.getCustom_hashCode());
    }

    public double getDistanceA(final Electeur p) {
        return Math.sqrt(
                Math.pow(pouvoir_achat.getValeur() - p.pouvoir_achat.getValeur(), 2)
                        + Math.pow(ecologie.getValeur() - p.ecologie.getValeur(), 2));
    }

    /**
     * Détermine si l'objet courant est près de p suivant son appétance
     * @param p : cible
     * @return : estPrêtDe ?
     */
    public boolean isNearBy(final Electeur p) {
        return getDistanceA(p) < distanceMax;
    }

    /**
     * Détermine le Candidat pour lequel l'objet courant va voter
     * @param candidats : Les candidats disponibles
     * @return : Le candidat choisi
     */
    public Candidat votePour(HashSet<Candidat> candidats) {
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

    /**
     * Déplace l'objet courant d'une distance distanceAParcourir en déterminant les déplacements correspondants sur chaque axe.
     * @param cible : Cible vers laquelle se déplacer
     * @param distanceAParcourir : Distance à parcourir
     */
    public void seDeplacerVers(Electeur cible, Double distanceAParcourir) {
        Double y1 = getEcologie().getValeur(), y2 = cible.getEcologie().getValeur(),
                x1 = getPouvoir_achat().getValeur(), x2 = cible.getPouvoir_achat().getValeur();

        // Utilise Thales pour déterminer les rapports de longueur à aplliquer
        Double coeff = distanceAParcourir / getDistanceA(cible);

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
        return "    id="+this.custom_hashCode+"\n"+
             "   ecologie=" + ecologie.getValeur() + "\n" +
                "   pouvoir_achat=" + pouvoir_achat.getValeur()+ "\n";
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

    public int getZoneGeographique() {
        return zoneGeographique;
    }

    public void setZoneGeographique(int zoneGeographique) {
        this.zoneGeographique = zoneGeographique;
    }
    public int getCustom_hashCode() {
        return custom_hashCode;
    }

    public void setCustom_hashCode(int custom_hashCode) {
        this.custom_hashCode = custom_hashCode;
    }
    
}
