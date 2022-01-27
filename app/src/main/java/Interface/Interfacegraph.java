package Interface;

import java.awt.LayoutManager;
import java.util.Hashtable;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import org.checkerframework.checker.units.qual.s;

import Interface.actionListenner.ComboScrutinListenner;
import Interface.actionListenner.demarageListenner;
import Interface.actionListenner.fliflopListenner;
import Interface.actionListenner.interragirListenner;
import Interface.actionListenner.testListenner;
import Personne.Candidat;
import Simulation.Simulation;
import javafx.scene.control.Slider;


public class Interfacegraph extends JFrame {

    private Simulation Monde;
    private String[] scrutin_type = {"majoritaire 1 tour","majoritaire 2 tour","Alternatif","Approbation","Borda"};
    private String test[] = { "NAN", "NAN", "NAN", "NAN", "NAN" };

    public Interfacegraph() {

        // initialistaion de la FRAME
        setTitle("ELECTION-TIM-FARES");
        setSize(1200, 975);
        setResizable(false);
        setLocationRelativeTo(null);
        

        // initialisation des panels de base
        JPanel fenetreprincipal = new JPanel();
        JPanel sim_strt  = new JPanel();
        JPanel affichage_liste = new JPanel();
        JPanel affichageGraph  = new JPanel();
        JPanel menu_interraction  = new JPanel();
        JPanel sous_menu_sondage  = new JPanel();
        JPanel sous_menu_social  = new JPanel();
        JPanel fin_comune_sous_menu = new JPanel();
        affichage_liste.setBorder(BorderFactory.createLineBorder( Color.BLACK));
        sim_strt.setBorder(BorderFactory.createLineBorder( Color.YELLOW));
        menu_interraction.setBorder(BorderFactory.createLineBorder( Color.RED));
        sous_menu_sondage.setBorder(BorderFactory.createLineBorder( Color.ORANGE));
        sous_menu_social.setBorder(BorderFactory.createLineBorder( Color.MAGENTA));
        fin_comune_sous_menu.setBorder(BorderFactory.createLineBorder( Color.BLUE));
        affichageGraph.setBorder(BorderFactory.createLineBorder( Color.GREEN));
        fenetreprincipal.setLayout(null);
        setContentPane(fenetreprincipal);
        

        // création composant
        
        JButton btn_demarer_data = new JButton("Simulation depuis un fichier");
        JButton btn_demarer_rand = new JButton("Simulation aléatoire");
        JButton btn_save = new JButton("Sauvegarde");
        JButton btn_interact = new JButton("Interagir");
        JButton btn_sondage = new JButton("Par Sondage");
        JButton btn_influence = new JButton("Influencer");
        JButton btn_social = new JButton("Par rencontre");
        JButton btn_lancer = new JButton("Lancer");

        

        JSlider slider_jour_inter = new JSlider(JSlider.HORIZONTAL,1,100,1);
               // Set the labels to be painted on the slider
               slider_jour_inter.setPaintLabels(true);
         
               // Add positions label in the slider
               Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
               position.put(1, new JLabel("1"));
               position.put(50, new JLabel("50"));
               position.put(100, new JLabel("100"));
                
               // Set the label to be drawn
               slider_jour_inter.setLabelTable(position);

        JLabel label_slider = new JLabel("Sur combien de jour on influence");
        JLabel label_res = new JLabel("-------Message console-------");
        label_res.setForeground(Color.RED);
        
       

        JList list_1 = new JList(test); 
        JList list_2 = new JList(test);

        JComboBox choix_scrutin = new JComboBox(scrutin_type);

        // ne comprends âs pourquoi ce truc ne marche pas ^^
        //JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setViewportView(list_1);
        
        
        // positionnement sur le fenetreprincipal 
        
        affichage_liste.setBounds(225,20,550,900);
        menu_interraction.setBounds(5,210,210,110);
        sim_strt.setBounds(5,120,210,80);
        sous_menu_sondage.setBounds(5,330,210,310);
        sous_menu_social.setBounds(5,330,210,310);
        fin_comune_sous_menu.setBounds(5,650,210,110);
        affichageGraph.setBounds(800,20,370,900);
        affichage_liste.setLayout(new GridLayout(2,1));
        menu_interraction.setLayout(null);
        sim_strt.setLayout(null);
        btn_demarer_rand.setBounds(10, 20,200, 40);
        btn_demarer_data.setBounds(10, 70, 200, 40);
        choix_scrutin.setBounds(5,10,200, 20);
        btn_interact.setBounds(5,35,200, 40);
        btn_social.setBounds(5,10,200,40);
        btn_sondage.setBounds(5,60,200,40);
        label_res.setBounds(10, 800, 200, 40);
        btn_save.setBounds(10, 850, 200, 40);
        btn_lancer.setBounds(10, 900, 200, 40);


        // paramétres du composant e.g taille police
        btn_demarer_rand.setFont(new Font("Arial", Font.BOLD,13));
        btn_demarer_data.setFont(new Font("Arial", Font.BOLD,11));
        label_res.setFont(new Font("Arial", Font.BOLD,15));
        
        
        
        // ajout panel au fenetreprincipal 
        fenetreprincipal.add(affichage_liste);
        fenetreprincipal.add(sim_strt);
        fenetreprincipal.add(menu_interraction);
        fenetreprincipal.add(sous_menu_sondage);
        fenetreprincipal.add(sous_menu_social);
        fenetreprincipal.add(affichageGraph);
        fenetreprincipal.add(fin_comune_sous_menu);
        
        //ajout components a la fenetre principal 
        fenetreprincipal.add(btn_demarer_rand);
        fenetreprincipal.add(btn_demarer_data);
        fenetreprincipal.add(label_res);
        fenetreprincipal.add(btn_lancer);
        fenetreprincipal.add(btn_save);
        

        //ajout sims start componnent
        sim_strt.add(choix_scrutin);
        sim_strt.add(btn_interact);

        //ajout sous panel de l'affichage des candidats
        affichage_liste.add(list_1);
        affichage_liste.add(list_2);

        //ajout panel du sous menu interraction
        menu_interraction.add(btn_sondage);
        menu_interraction.add(btn_social);

        //ajout  components au panel sondage  
        fin_comune_sous_menu.add(label_slider);
        fin_comune_sous_menu.add(slider_jour_inter);
        fin_comune_sous_menu.add(btn_influence);
        

        
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list_1,sim_strt));
        btn_interact.addActionListener(new interragirListenner(menu_interraction,sous_menu_sondage,sous_menu_social ,fin_comune_sous_menu));
        btn_social.addActionListener(new fliflopListenner(sous_menu_sondage,sous_menu_social,fin_comune_sous_menu));
        btn_sondage.addActionListener(new fliflopListenner(sous_menu_social,sous_menu_sondage,fin_comune_sous_menu));
        choix_scrutin.addActionListener(new ComboScrutinListenner(Monde, choix_scrutin));
        
        


        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //initialisation sous menu non visible
        menu_interraction.setVisible(false);
        sim_strt.setVisible(false);
        sous_menu_sondage.setVisible(false);
        sous_menu_social.setVisible(false);
        fin_comune_sous_menu.setVisible(false);

        
        
        

    }

}