package Interface;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

import Interface.actionListenner.demarageListenner;
import Personne.Candidat;
import Simulation.Simulation;
import javafx.scene.paint.Color;

public class Interfacegraph extends JFrame {

    private Simulation Monde;
    private boolean stay;
    private boolean monde_init;
    private String Scrutin[] = { "Majoritaire 1 tour", "Majoritaire 2 tour", "Alternatif", "Approbation", "Borda" };
    private String test[] = { "Majoritaire 1 tour", "Majoritaire 2 tour", "Alternatif", "Approbation", "Borda" };

    public Interfacegraph() {

        // initialistaion de la FRAME
        setTitle("ELECTION-TIM-FARES");
        setSize(1280, 1024);
        setResizable(false);
        setLocationRelativeTo(null);
        

        // initialisation des panels de base
        JPanel menu = new JPanel();
        menu.setLayout(null);
        setContentPane(menu);
        
        
       
    

      
        

        // création composant
        JLabel label_list1 = new JLabel("Listes des Candidats");
        JLabel label_list2 = new JLabel("Resultat des Elections");
        JButton btn_demarer_data = new JButton("Simulation depuis un fichier");
        JButton btn_demarer_rand = new JButton("Simulation aléatoire");
        JList list_1 = new JList(test); 
        JList list_2 = new JList(test);
        // ne comprends âs pourquoi ce truc ne marche pas ^^
        //JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setViewportView(list_1);
        
        
        // positionnement sur le menu 
        label_list1.setBounds(250, 25, 300, 40);
        label_list2.setBounds(250, 300, 300, 40);
        list_1.setBounds(250, 75, 500, 200);
        list_2.setBounds(250, 350, 500, 200);
        btn_demarer_rand.setBounds(10, 100,200, 40 );
        btn_demarer_data.setBounds(10, 25, 200, 40);
        // paramétres du composant e.g taille police
        btn_demarer_rand.setFont(new Font("Arial", Font.BOLD,11));
        btn_demarer_data.setFont(new Font("Arial", Font.BOLD,11));
        label_list1.setFont(new Font("Arial", Font.BOLD,25));
        label_list2.setFont(new Font("Arial", Font.BOLD,25));
        
        // ajout au menu 
       
        menu.add(btn_demarer_rand);
        menu.add(btn_demarer_data);
        menu.add(label_list1);
        menu.add(label_list2);
        menu.add(list_1);
        menu.add(list_2);
        /*
        JList list = new JList(test); 
        JButton btn_demarer_rand = new JButton("creer une simulation sans données");
        JButton btn_demarer_data = new JButton("creer une simulation depuis mon fichier");
        JButton btn_inter = new JButton("Interraction menu");
        JComboBox cbb_scrutin = new JComboBox(Scrutin);
        
        
        //FileChooser fc = new JFileChooser();
        
        menu.add(cbb_scrutin);
        this.add(list,BorderLayout.CENTER); 
        this.add(list,BorderLayout.CENTER); 
        menu.add(btn_demarer_rand);
        menu.add(btn_demarer_data);
    



        //listener 
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list));
        */
        //listener 
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list_1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}