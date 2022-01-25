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
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        

        // initialisation des panels de base
        JPanel menu = new JPanel();
        menu.setLayout(null);
        setContentPane(menu);
        
        
       
    

      
        

        // création composant
        JLabel label = new JLabel("Listes des Candidats");
        JButton btn_demarer_data = new JButton("Simulation depuis un fichier");
        JButton btn_demarer_rand = new JButton("Simulation aléatoire");
        JList list = new JList(test); 
        // ne comprends âs pourquoi ce truc ne marche pas ^^
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        
        
        // positionnement sur le menu 
        label.setBounds(250, 25, 300, 40);
        list.setBounds(250, 75, 500, 200);
        btn_demarer_rand.setBounds(10, 100,200, 40 );
        btn_demarer_data.setBounds(10, 25, 200, 40);
        // paramétres du composant e.g taille police
        btn_demarer_rand.setFont(new Font("Arial", Font.BOLD,11));
        btn_demarer_data.setFont(new Font("Arial", Font.BOLD,11));
        label.setFont(new Font("Arial", Font.BOLD,25));
        
        // ajout au menu 
       
        menu.add(btn_demarer_rand);
        menu.add(btn_demarer_data);
        menu.add(label);
        menu.add(list);
        menu.add(scrollPane);
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
        btn_demarer_rand.addActionListener(new demarageListenner(Monde, list));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}