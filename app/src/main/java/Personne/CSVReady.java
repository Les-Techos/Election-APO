package Personne;

/**
 * Prêt à être enregistrer sous CSV dans le disque
 */

public abstract class CSVReady {
    
    public CSVReady(){

    }

    public CSVReady(String st){

    }

    /**
     * Converti l'objet courant en tuple CSV
     * @return : ligne CSV
     */
    public abstract String toCSVString();
}
