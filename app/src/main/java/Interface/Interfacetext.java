package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import InteractionDynamique.InteractionDynamique;
import InteractionDynamique.interDyn_Sondage;
import InteractionDynamique.modeSondage;
import Personne.*;
import Scrutin.Scrutin;
import Simulation.Simulation;
import utils.SaveManager;

public class Interfacetext {
    
    private Simulation Monde;
    private boolean stay;
    private boolean monde_init;

    public Interfacetext() {
        this.stay = true;
        this.monde_init = false;
        Monde = null;
        
    }

    /**
     * Lit l'entrée entière au clavier et gère les exceptions
     * 
     * @return float : réel lu au clavier
     */
    private double lecturedoubleClavier() {
        double DoubleInValue = -1;
        String inValue;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            inValue = br.readLine();
            DoubleInValue = Float.parseFloat(inValue);
            if ((DoubleInValue < 0) && (DoubleInValue > 1)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("La valeur rentrée n'est pas un réel");
        }

        return DoubleInValue;
    }

    /**
     * Lit l'entrée entière au clavier et gère les exceptions
     * 
     * @return String : chjaîne de caractères lu au clavier
     */
    private String lectureStringClavier() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inValue = "Erreur";
        try {
            inValue = br.readLine();
            if (inValue.matches("[+-]?\\d*(\\.\\d+)?")) {
                inValue = "Erreur";
                throw new Exception("Nombre Invalide");
            }
        } catch (Exception e) {
            System.out.println("Problème lors de la lecture clavier");
        }

        return inValue;
    }

    /**
     * Lit l'entrée entière au clavier et gère les exceptions
     * 
     * @return int : l'entier lu au clavier
     */
    private int lectureIntClavier() {
        int intInValue = -1;
        String inValue;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            inValue = br.readLine();
            intInValue = Integer.parseInt(inValue);

        } catch (Exception e) {
            System.out.println("La valeur rentrée n'est pas un entier");
        }

        return intInValue;
    }

    // Fonction de base du menu gére l'arrêt de la simulation 
      /**
     * Vérifie que les listes d'électeurs et de candidats ne sont pas vides
     * return void affiche dans la console 
     */
    public void demarer() throws Exception {
        int compt_t = 0; // vérification du reset d'une simulation nouvelle données 
        while (stay) {
            if(compt_t == 0){     
            System.out.println("--- Bienvenue dans le Système d'élèction de Tim et Farès ---");
            System.out.println("Comment voulez vous demarer votre simulation :");
            System.out.println("0 -> avec des données aléatoires");
            System.out.println("1 -> rentrer mes données (Sous forme)");
            int choix_0 = lectureIntClavier();
            this.menu_data(choix_0);
            compt_t = 1 ;
            }
            while (monde_init) {
                this.menu_scrutin();
                System.out.println("Voulez vous des interaction dans votre simulation ");
                System.out.println("0 -> NON");
                System.out.println("1 -> OUI");
                int choix_1 = lectureIntClavier();
                switch (choix_1) {
                    case 0:
                        System.out.println(Monde.LancerElection());
                        break;
                    case 1:
                        this.menu_interdyn();
                        break;

                }
               
                System.out.println("voulez vous QUITTER ?");
                System.out.println("0->NON //// autre entier -> OUI");
                int choix_2 = lectureIntClavier();
                if (choix_2 != 0) {
                    stay = false;
                    monde_init = false;
                }
                
                if(stay){
                    System.out.println("voulez vous conservez votre simulation ?");
                    System.out.println("0->NON //// autre entier -> OUI");
                    int simul_conserv = lectureIntClavier();
                    if (simul_conserv== 0) {
                        compt_t = 0;
                        monde_init = false;
                        System.out.println("On a supprimer votre simulation courante ");
                    }
                    else{
                        compt_t = 1;
                        monde_init = true;
                    }
                }
                
            }}
        
        System.out.println("Au Revoir de Valéry Giscard d'Estaing");

    }

    // raffiche le menu de choix de données est appelle la la fonction de menu
    // données de base 10 candidat random et 100 electeurs
    public void menu_data(int choix_data) throws Exception {

        switch (choix_data) {
            case 0:
                System.out.println("Combien de candidats ? ");
                int nb_candidat = lectureIntClavier();
                System.out.println("Combien d'electeur ?");
                int nb_electeur = lectureIntClavier();
                Monde = new Simulation(nb_candidat, nb_electeur);
                System.out.println("On a creer une monde avec " + Monde.toString());
                break;
            case 1:
                HashSet<Candidat> c = new HashSet<Candidat>();
                HashSet<Electeur> e = new HashSet<Electeur>();
                System.out.println("---Rentrer le chemin d'accés au données de type candidats ---");
                String path_candidats = lectureStringClavier();
                SaveManager.readIterableFrom(c, path_candidats, Candidat.class);
                System.out.println("---Rentrer le chemin d'accés au données de type Electeurs ---");
                String path_electeurs = lectureStringClavier();
                SaveManager.readIterableFrom(e, path_electeurs, Electeur.class);
                Monde = new Simulation(c, e);
                System.out.println("On a creer une monde avec " + Monde.toString());
                break;

        }
        monde_init = true;
    }

    // affichage des interraction dynamique et de leur menu + entrer des paramétres 
    public void menu_interdyn() throws Exception {
        System.out.println("--- Choisir comment influencer ?---");
        System.out.println("0 -> par interaction socio politique");
        System.out.println("1 -> par sondage");
        int choix_sond = lectureIntClavier();
        switch (choix_sond) {
            case 0:
                System.out.println("--- On va réaliser une interraction_social ---");
                System.out.println("Donnez le seuil d'attraction Candidats (double e.g = 2.6) ");
                double seuilAttractionCandidats = lecturedoubleClavier();
                System.out.println("Donnez le seuil de répulsion (double e.g = 2.6) ");
                double seuilRepulsionCandidats = lecturedoubleClavier();
                System.out.println("Donnez le seuil d'attraction Electeurs (double e.g = 2.6) ");
                double seuilAttractionElecteurs = lecturedoubleClavier();
                System.out.println("Donnez la distance que peut parcourir un sonde (double e.g = 2.6) "); 
                double distanceParcourue = lecturedoubleClavier();
                Monde.interraction_social(seuilAttractionCandidats, seuilRepulsionCandidats, seuilAttractionElecteurs,
                        distanceParcourue);
                System.out.println(
                        "Donnez le nombre d'ittération (int) ou nombre de jour sur lesquelles seront influencer les electeurs");
                Monde.setJourDinfluence(lectureIntClavier());
                System.out.println("----- RESULTAT POST-INFLUENCE ----- \n"+Monde.LancerElection());
                break;
            case 1:
                this.menu_modesondage();
                System.out.println("--- On va réaliser une influence par sondage ---");
                System.out.println("Donnez le nombre d'electeurs a sonde parmis " + Monde.getE().size() + " ");
                int nbsonde = lectureIntClavier();
                Monde.interraction_sondage(nbsonde);
                System.out.println("Donnez le nombre d'ittération (int) ou nombre de jour sur lesquelles seront influencer les electeurs");
                Monde.setJourDinfluence(lectureIntClavier());
                
                System.out.println("----- RESULTAT PRE-INFLUENCE ----- \n"+Monde.LancerElection());
                
                break;
        }
    }
// Affichage type de sondage et choix de ce dernier 
    public void menu_modesondage() {
        System.out.println("--- Choix du type de sondage ---");
        System.out.println("0 -> Simple");
        System.out.println("1 -> utilite");
        System.out.println("2 -> utilite_multiple");
        int choix_mode = lectureIntClavier();
        Monde.choix_mode(choix_mode);

    }


    // Permet l'affichage du menu de scrutin et de faire le choix pour la Simulation 
    public Scrutin menu_scrutin() {
        System.out.println("--- Choisir mode electorale ---");
        System.out.println("0 -> Majoritaire 1 tour");
        System.out.println("1 -> Majoritaire 2 tour");
        System.out.println("2 -> Alternatif");
        System.out.println("3 -> Approbation");
        System.out.println("4 -> Borda");
        int choix_mode = lectureIntClavier();
        Scrutin res = Monde.choixScrutin(choix_mode);
        return res;
    }
}
