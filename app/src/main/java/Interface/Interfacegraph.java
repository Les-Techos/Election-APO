package Interface;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;

import Interface.actionListenner.demarageListenner;
import Interface.actionListenner.interragirListenner;
import Interface.actionListenner.testListenner;
import Personne.Candidat;
import Simulation.Simulation;


public class Interfacegraph extends JFrame {

    private Simulation Monde;
    private boolean stay;
    private boolean monde_init;
    private String Scrutin[] = { "Majoritaire 1 tour", "Majoritaire 2 tour", "Alternatif", "Approbation", "Borda" };
    private String test[] = { "NAN", "NAN", "NAN", "NAN", "NAN" };

    public Interfacegraph() {

        // initialistaion de la FRAME
        setTitle("ELECTION-TIM-FARES");
        setSize(1200, 975);
        setResizable(false);
        setLocationRelativeTo(null);
        

        // initialisation des panels de base
        JPanel fenetreprincipal = new JPanel();
        JPanel affichage_liste = new JPanel();
        JPanel affichageGraph  = new JPanel();
        JPanel menu_interraction  = new JPanel();
        affichage_liste.setBorder(BorderFactory.createLineBorder( Color.BLACK));
        menu_interraction.setBorder(BorderFactory.createLineBorder( Color.RED));
        affichageGraph.setBorder(BorderFactory.createLineBorder( Color.GREEN));
        fenetreprincipal.setLayout(null);
        setContentPane(fenetreprincipal);
        

        // création composant
        
        JButton btn_demarer_data = new JButton("Simulation depuis un fichier");
        JButton btn_demarer_rand = new JButton("Simulation aléatoire");
        JButton btn_save = new JButton("Sauvegarde");
        JButton btn_interact = new JButton("Interagir");
        JButton btn_sondage = new JButton("Par Sondage");
        JButton btn_social = new JButton("Par rencontre");
        JButton btn_lancer = new JButton("Lancer");

        JList list_1 = new JList(test); 
        JList list_2 = new JList(test);
        // ne comprends âs pourquoi ce truc ne marche pas ^^
        //JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setViewportView(list_1);
        
        
        // positionnement sur le fenetreprincipal 
        
        affichage_liste.setBounds(225,20,550,900);
        menu_interraction.setBounds(5,210,210,110);
        affichageGraph.setBounds(800,50,370,900);
        affichage_liste.setLayout(new GridLayout(2,1));
        menu_interraction.setLayout(null);
        //list_1.setBounds(250, 75, 500, 200);
        //list_2.setBounds(250, 350, 500, 200);
        btn_demarer_rand.setBounds(10, 50,200, 40);
        btn_demarer_data.setBounds(10, 100, 200, 40);
        btn_interact.setBounds(10, 150,200, 40);
        btn_social.setBounds(5,10,200,40);
        btn_sondage.setBounds(5,60,200,40);
        btn_save.setBounds(10, 850, 200, 40);
        btn_lancer.setBounds(10, 900, 200, 40);
        // paramétres du composant e.g taille police
        btn_demarer_rand.setFont(new Font("Arial", Font.BOLD,11));
        btn_demarer_data.setFont(new Font("Arial", Font.BOLD,11));
        
        
        // ajout au fenetreprincipal 
        fenetreprincipal.add(affichage_liste);
        fenetreprincipal.add(menu_interraction);
        fenetreprincipal.add(affichageGraph);
        fenetreprincipal.add(btn_demarer_rand);
        fenetreprincipal.add(btn_demarer_data);
        fenetreprincipal.add(btn_interact);
        fenetreprincipal.add(btn_lancer);
        fenetreprincipal.add(btn_save);
        affichage_liste.add(list_1);
        affichage_liste.add(list_2);
        menu_interraction.add(btn_sondage);
        menu_interraction.add(btn_social);

        
        /*
        JList list = new JList(test); 
        JButton btn_demarer_rand = new JButton("creer une simulation sans données");
        JButton btn_demarer_data = new JButton("creer une simulation depuis mon fichier");
        JButton btn_inter = new JButton("Interraction fenetreprincipal");
        JComboBox cbb_scrutin = new JComboBox(Scrutin);
        
        
        //FileChooser fc = new JFileChooser();
        
        fenetreprincipal.add(cbb_scrutin);
        this.add(list,BorderLayout.CENTER); 
        this.add(list,BorderLayout.CENTER); 
        fenetreprincipal.add(btn_demarer_rand);
        fenetreprincipal.add(btn_demarer_data);
    



        //listener 
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list));
        */
        //listener 
        menu_interraction.setVisible(false);
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list_1));
        btn_interact.addActionListener(new interragirListenner(menu_interraction));
        btn_social.addActionListener(new testListenner());
        btn_sondage.addActionListener(new testListenner());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}