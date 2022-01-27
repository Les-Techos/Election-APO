package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Personne.Candidat;
import Simulation.Simulation;

public class LancerListenner implements ActionListener{

    private Simulation Monde;
    private JList liste_candidat_res;

    public LancerListenner(JList liste_candidat){
        this.liste_candidat_res = liste_candidat;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println(Monde.LancerElection());
        DefaultListModel listmodel = new DefaultListModel<>(); 
        listmodel.addElement("------Candidat de départ------");
        for ( Candidat c : Monde.getC()) {
            String res = "";
            res = "Candidat n° "+c.getCustom_hashCode()+" nb_voies " + c.getNbVoies() ;
            listmodel.addElement(res);
        }
        liste_candidat_res.setModel(listmodel);

    }
    

    public void setMonde(Simulation M){
        this.Monde = M;
    }
}
