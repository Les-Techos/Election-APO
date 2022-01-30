package Interface;

import java.util.Hashtable;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import org.checkerframework.checker.units.qual.s;

import Interface.CustomComponent.DoubleSpinner;
import Interface.actionListenner.ComboModeListenner;
import Interface.actionListenner.ComboScrutinListenner;
import Interface.actionListenner.InfluenceListenner;
import Interface.actionListenner.LancerListenner;
import Interface.actionListenner.LoadCListenner;
import Interface.actionListenner.ResetListenner;
import Interface.actionListenner.SaveListenner;
import Interface.actionListenner.SondageListenner;
import Interface.actionListenner.demarageListenner;
import Interface.actionListenner.fliflopListenner;
import Interface.actionListenner.interragirListenner;
import Interface.actionListenner.testListenner;
import Personne.Candidat;
import Simulation.Simulation;
import javafx.scene.control.Slider;

  /**
     * Gére l'interface graphique et l'affichage des electeurs 
     */
public class Interfacegraph extends JFrame {

    private Simulation Monde=null;
    private String[] scrutin_type = {"majoritaire 1 tour","majoritaire 2 tour","Alternatif","Approbation","Borda"};
    private String[] inter_sociale = {"simple","utilite","utilite-multiple"};
    private String test[] = { "NAN", "NAN", "NAN", "NAN", "NAN" };
    private ComboScrutinListenner comboListener;
    private LancerListenner lancerListener;
    private ComboModeListenner combomodelListener;
    private LoadCListenner loadlistenner;
    private  InfluenceListenner influencelisteners;
    private  SondageListenner sondageListeners;
    private SaveListenner savelisteners;
    private  ResetListenner resetlistener;
    
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

        // COLORISATION DES BORDURES DES JPANEL POUR LES PLACER
        affichage_liste.setBorder(BorderFactory.createLineBorder( Color.BLACK));
        sim_strt.setBorder(BorderFactory.createLineBorder( Color.YELLOW));
        menu_interraction.setBorder(BorderFactory.createLineBorder( Color.RED));
        sous_menu_sondage.setBorder(BorderFactory.createLineBorder( Color.ORANGE));
        sous_menu_social.setBorder(BorderFactory.createLineBorder( Color.MAGENTA));
        fin_comune_sous_menu.setBorder(BorderFactory.createLineBorder( Color.BLUE));
        affichageGraph.setBorder(BorderFactory.createLineBorder( Color.GREEN));

        fenetreprincipal.setLayout(null);
        setContentPane(fenetreprincipal);
        

        // création composant bouton
        
        JButton btn_demarer_data = new JButton("Simulation fichier");
        JButton btn_demarer_rand = new JButton("Simulation aléatoire");
        JButton btn_save = new JButton("Sauvegarde");
        JButton btn_interact = new JButton("Interagir");
        JButton btn_sondage = new JButton("Par Sondage");
        JButton btn_influence_sondage = new JButton("Influencer par sondage");
        JButton btn_influence_social = new JButton("Influencer par social");
        JButton btn_social = new JButton("Par rencontre");
        JButton btn_lancer = new JButton("Lancer");
        JButton btn_reset = new JButton("RESET");

        //SLIDER POUR les jours d'influence

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

    
        JSlider slider_jour_inter_1 = new JSlider(JSlider.HORIZONTAL,1,100,1);
               // Set the labels to be painted on the slider
               slider_jour_inter_1.setPaintLabels(true);
                // Add positions label in the slider
                Hashtable<Integer, JLabel> position_1 = new Hashtable<Integer, JLabel>();
                position_1.put(1, new JLabel("1"));
                position_1.put(50, new JLabel("50"));
                position_1.put(100, new JLabel("100"));
                 
                // Set the label to be drawn
                slider_jour_inter_1.setLabelTable(position_1);
                
               // Set the label to be drawn
               slider_jour_inter_1.setLabelTable(position_1);

        JLabel label_atr_c = new JLabel("Attraction candidat");
        JLabel label_candi_elec = new JLabel("candidats electeurs");
        JLabel label_rep_c = new JLabel("Répulsion candidat");
        JLabel label_atr_e = new JLabel("Attraction electeur");
        JLabel label_d = new JLabel("distance à parcourir");
        JLabel label_mode = new JLabel("Quelle type d'interraction");
        JLabel label_slider = new JLabel("Sur combien de jour on influence");
        JLabel label_slider_2 = new JLabel("Sur combien de jour on influence");
        JLabel label_sonde = new JLabel("combien de gens a sonde");
        JLabel label_res = new JLabel("-------Message console-------");
        label_res.setForeground(Color.RED);

        JSpinner nbsonde = new JSpinner(); 
        JSpinner nb_electeur = new JSpinner();
        JSpinner nb_candidat = new JSpinner();               
    
        DoubleSpinner spn_atr_c = new DoubleSpinner();
        DoubleSpinner spn_rep_c = new DoubleSpinner();
        DoubleSpinner spn_atr_e = new DoubleSpinner();
        DoubleSpinner spn_d = new DoubleSpinner();

        JList list_1 = new JList(test); 
        JLabel list_2 = new JLabel("-------- ICI SERONT LES RESULTATS --------");

        JComboBox choix_scrutin = new JComboBox(scrutin_type);
        JComboBox choix_mode = new JComboBox(inter_sociale);

        
        
        
        // positionnement sur le fenetreprincipal 
        
        affichage_liste.setBounds(225,20,750,900);
        menu_interraction.setBounds(5,250,210,110);
        sim_strt.setBounds(5,160,210,80);
        sous_menu_sondage.setBounds(5,370,210,310);
        sous_menu_social.setBounds(5,370,210,310);
        affichageGraph.setBounds(800,20,370,900);
        affichage_liste.setLayout(new GridLayout(2,1));
        menu_interraction.setLayout(null);
        sim_strt.setLayout(null);
        nb_candidat.setBounds(75, 70,40, 20);
        nb_electeur.setBounds(25, 70,40, 20);
        label_candi_elec.setBounds(5,50,120,20);
        btn_demarer_rand.setBounds(10, 10,200, 40);
        btn_demarer_data.setBounds(10, 100, 200, 40);
        choix_scrutin.setBounds(5,10,200, 20);
        btn_interact.setBounds(5,35,200, 40);
        btn_social.setBounds(5,10,200,40);
        btn_sondage.setBounds(5,60,200,40);
        label_res.setBounds(10, 800, 200, 40);
        btn_save.setBounds(10, 850, 200, 40);
        btn_lancer.setBounds(10, 900, 200, 40);
        btn_reset.setBounds(990,900,200,40);


        // paramétres du composant e.g taille police
        btn_demarer_rand.setFont(new Font("Arial", Font.BOLD,13));
        btn_demarer_data.setFont(new Font("Arial", Font.BOLD,13));
        label_res.setFont(new Font("Arial", Font.BOLD,15));
        list_2.setFont(new Font("Arial", Font.BOLD,15));
        list_2.setHorizontalAlignment(JLabel.CENTER);
        
        
        // ajout panel au fenetreprincipal 
        fenetreprincipal.add(affichage_liste);
        fenetreprincipal.add(sim_strt);
        fenetreprincipal.add(menu_interraction);
        fenetreprincipal.add(sous_menu_sondage);
        fenetreprincipal.add(sous_menu_social);
        fenetreprincipal.add(nb_candidat);
        fenetreprincipal.add(nb_electeur);
    
        
        //ajout components a la fenetre principal 
        fenetreprincipal.add(btn_demarer_rand);
        fenetreprincipal.add(btn_demarer_data);
        fenetreprincipal.add(label_res);
        fenetreprincipal.add(btn_lancer);
        fenetreprincipal.add(btn_save);
        fenetreprincipal.add(label_candi_elec);
        fenetreprincipal.add(btn_reset);
        

        //ajout sims start componnent
        sim_strt.add(choix_scrutin);
        sim_strt.add(btn_interact);

        //ajout sous panel de l'affichage des candidats
        affichage_liste.add(list_1);
        affichage_liste.add(list_2);


       
        
        //ajout panel du sous menu interraction
        menu_interraction.add(btn_sondage);
        menu_interraction.add(btn_social);

        //ajout  components au panel commun de sous menu   
        

         //ajout au panel de sondage
         sous_menu_sondage.add(label_sonde);
         sous_menu_sondage.add((Component) nbsonde);
         sous_menu_sondage.add(label_slider_2);
        sous_menu_sondage.add(slider_jour_inter_1);
        sous_menu_sondage.add(btn_influence_sondage);
        
        //ajout  components au panel interraction socialists
        sous_menu_social.add(label_atr_c);
        sous_menu_social.add(spn_atr_c);
        sous_menu_social.add(label_rep_c);
        sous_menu_social.add(spn_rep_c);
        sous_menu_social.add(label_atr_e);
        sous_menu_social.add(spn_atr_e);
        sous_menu_social.add(label_d);
        sous_menu_social.add(spn_d);
        sous_menu_social.add(label_mode);
        sous_menu_social.add(choix_mode);
        sous_menu_social.add(label_slider);
        sous_menu_social.add(slider_jour_inter);
        sous_menu_social.add(btn_influence_social);

        // Listenner de tous les boutons  de l'interface graphique 
        btn_demarer_rand.addActionListener(new demarageListenner(this, list_1,sim_strt,nb_candidat,nb_electeur));
        btn_interact.addActionListener(new interragirListenner(menu_interraction,sous_menu_sondage,sous_menu_social ,fin_comune_sous_menu));
        btn_social.addActionListener(new fliflopListenner(sous_menu_social,sous_menu_sondage,fin_comune_sous_menu));
        btn_sondage.addActionListener(new fliflopListenner(sous_menu_sondage,sous_menu_social,fin_comune_sous_menu));
        comboListener = new ComboScrutinListenner (choix_scrutin);
        choix_scrutin.addActionListener( comboListener );
        lancerListener = new LancerListenner(list_2);
        btn_lancer.addActionListener(lancerListener);
        loadlistenner = new LoadCListenner(this,list_1,affichageGraph);
        btn_demarer_data.addActionListener(loadlistenner);
        combomodelListener = new ComboModeListenner(choix_mode);
        choix_mode.addActionListener(combomodelListener);
        influencelisteners = new InfluenceListenner(slider_jour_inter,spn_atr_c,spn_rep_c,spn_atr_e,spn_d,list_2);
        btn_influence_social.addActionListener(influencelisteners);
        sondageListeners = new SondageListenner(nbsonde,slider_jour_inter_1,list_2);
        btn_influence_sondage.addActionListener(sondageListeners);
        savelisteners = new SaveListenner();
        btn_save.addActionListener(savelisteners);
        resetlistener = new ResetListenner(menu_interraction,sim_strt,sous_menu_social,sous_menu_sondage,list_1,list_2);
        btn_reset.addActionListener(resetlistener);
        
        
        
        
        ((JSpinner.DefaultEditor) nb_candidat.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) nb_electeur.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spn_atr_c.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spn_atr_e.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spn_rep_c.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spn_d.getEditor()).getTextField().setEditable(false);

        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //initialisation sous menu non visible
        menu_interraction.setVisible(false);
        sim_strt.setVisible(false);
        sous_menu_sondage.setVisible(false);
        sous_menu_social.setVisible(false);
        
        


    }

    // permet de se passer la simulation entre les listeners
    public void setMonde(Simulation M){
        this.Monde = M;
        comboListener.setMonde(M);
        lancerListener.setMonde(M);
        loadlistenner.setMonde(M);
        combomodelListener.setMonde(M);
        influencelisteners.setMonde(M);
        sondageListeners.setMonde(M);
        savelisteners.setMonde(M);
        resetlistener.setMonde(M);
    }

}