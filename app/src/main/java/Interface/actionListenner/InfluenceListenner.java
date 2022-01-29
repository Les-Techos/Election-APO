package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Interface.CustomComponent.DoubleSpinner;
import Simulation.Simulation;
import javafx.scene.text.Font;

public class InfluenceListenner implements ActionListener{

    private Simulation Monde;
    private DoubleSpinner atr_c;
    private DoubleSpinner rep_c;
    private DoubleSpinner atr_e;
    private DoubleSpinner distance;
    private JSlider jour_influence;
    private JLabel liste_candidat_res;
   


 

    public InfluenceListenner(JSlider nb_jour,JSpinner spn_atr_c, JSpinner spn_rep_c, JSpinner spn_atr_e, JSpinner spn_d,JLabel liste_candidat){
        this.jour_influence = nb_jour;
        this.atr_c = ((DoubleSpinner) spn_atr_c);
        this.rep_c = ((DoubleSpinner) spn_rep_c);
        this.atr_e = ((DoubleSpinner) spn_atr_e);
        this.distance = ((DoubleSpinner) spn_d);
        this.liste_candidat_res = liste_candidat;
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            System.out.println("on a creer l'influence par interraction social");
           
            
            Monde.setJourDinfluence(jour_influence.getValue());
            System.out.println(Monde.getJourDinfluence());
            Monde.interraction_social(atr_c.getDouble(), rep_c.getDouble(), atr_e.getDouble(), distance.getDouble());
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Rentrer des paramétres !!!");
        }
        // TODO Auto-generated method stub
        try{
            String res = "<html>" +Monde.LancerElection().replace("\n", "<br/>")+"</html>"; 
            
            liste_candidat_res.setText(res);
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "? probleme affichage ?");
        }
        
    }
           
    public void setMonde(Simulation M){
        this.Monde = M;
    }
}
