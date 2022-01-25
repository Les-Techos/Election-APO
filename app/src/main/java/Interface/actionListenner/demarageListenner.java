package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Personne.Candidat;
import Simulation.Simulation;

public class demarageListenner implements ActionListener{

    private Simulation Monde;
    private JList liste_candidat;
    
    public demarageListenner(Simulation Monde, JList liste_candidat) {
        this.Monde = null;
        this.liste_candidat = liste_candidat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        Monde = new Simulation();
        DefaultListModel listmodel = new DefaultListModel<>(); 
        for ( Candidat c : Monde.getC()) {
            String res = "";
            res = "Candidat n° "+c.getCustom_hashCode()+" Axe \n ecologique " + c.getEcologie().getValeur() 
            + " pouvoire d'achat " +c.getPouvoir_achat().getValeur() ;
            listmodel.addElement(res);
        }
        liste_candidat.setModel(listmodel);
        
    }
    
}
