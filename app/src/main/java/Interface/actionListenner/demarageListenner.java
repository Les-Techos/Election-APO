package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import Interface.Interfacegraph;
import Interface.CustomComponent.DoubleSpinner;
import Personne.Candidat;
import Simulation.Simulation;

public class demarageListenner implements ActionListener{

    private Simulation Monde;
    private JList liste_candidat;
    private JPanel panel_dbt0;
    private JPanel panel_dbt1;
    private Interfacegraph graph;
    private JSpinner ds_electeur;
    private JSpinner ds_candidat;
    

    
    public demarageListenner(Interfacegraph graph, JList liste_candidat, JPanel panel_dbt0, JSpinner ds_electeur, JSpinner ds_candidat) {
        this.graph = graph;
        this.liste_candidat = liste_candidat;
        this.panel_dbt0 = panel_dbt0;
        this.ds_candidat = ds_candidat;
        this.ds_electeur = ds_electeur;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          int int_candidat = (int)ds_candidat.getValue();
          int int_electeur = (int)ds_electeur.getValue(); 
        System.out.println(int_candidat);
        System.out.println(int_electeur);
        if(int_candidat == 0 && int_electeur ==0 || int_candidat > int_electeur || int_candidat < 0 || int_electeur < 0){
            JOptionPane.showMessageDialog(null, "erreur valeurs de base");
        }
       else{
        Monde = new Simulation(int_candidat,int_electeur);
     
        graph.setMonde(Monde);
        panel_dbt0.setVisible(true);
        Monde.setSa(Monde.choixScrutin(0));

        DefaultListModel listmodel = new DefaultListModel<>(); 
        listmodel.addElement("------Candidat de départ------");
        for ( Candidat c : Monde.getC()) {
            String res = "";
            res = "Candidat n° "+c.getCustom_hashCode()+" Axe \n ecologique " + c.getEcologie().getValeur() 
            + " pouvoire d'achat " +c.getPouvoir_achat().getValeur() ;
            listmodel.addElement(res);
        }
        liste_candidat.setModel(listmodel);
        
    }}
    
}
