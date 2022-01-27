package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Personne.Candidat;
import Simulation.Simulation;

public class demarageListenner implements ActionListener{

    private Simulation Monde;
    private JList liste_candidat;
    private JPanel panel_dbt0;
    private JPanel panel_dbt1;

    
    public demarageListenner(Simulation Monde, JList liste_candidat, JPanel panel_dbt0) {
        this.Monde = null;
        this.liste_candidat = liste_candidat;
        this.panel_dbt0 = panel_dbt0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        Monde = new Simulation();
        panel_dbt0.setVisible(true);

        DefaultListModel listmodel = new DefaultListModel<>(); 
        listmodel.addElement("------Candidat de départ------");
        for ( Candidat c : Monde.getC()) {
            String res = "";
            res = "Candidat n° "+c.getCustom_hashCode()+" Axe \n ecologique " + c.getEcologie().getValeur() 
            + " pouvoire d'achat " +c.getPouvoir_achat().getValeur() ;
            listmodel.addElement(res);
        }
        liste_candidat.setModel(listmodel);
        
    }
    
}
