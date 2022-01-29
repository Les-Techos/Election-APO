package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Personne.Candidat;
import Simulation.Simulation;

public class LancerListenner implements ActionListener{

    private Simulation Monde;
    private JLabel liste_candidat_res;

    public LancerListenner(JLabel liste_candidat){
        this.liste_candidat_res = liste_candidat;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try{
            String res = "<html>" +Monde.LancerElection().replace("\n", "<br/>")+"</html>"; 
            liste_candidat_res.setText(res);
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "crée une simulation avant de vouloir lancer");
        }
    }
    

    public void setMonde(Simulation M){
        this.Monde = M;
    }
}
