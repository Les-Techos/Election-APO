package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Simulation.Simulation;

public class ResetListenner implements ActionListener{

    private Simulation Monde;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JList list;
    private JLabel label_res;


    public ResetListenner(JPanel panel, JPanel panel2, JPanel panel3, JPanel panel4,JList liste_candidat, JLabel liste_candidat_res){
        this.panel = panel;
        this.panel2 = panel2;
        this.panel3 = panel3;
        this.panel4 = panel4;
        this.list = liste_candidat;
        this.label_res = liste_candidat_res;
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Monde = null;

                // TODO Auto-generated method stub
                    panel.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                    
                        DefaultListModel listModel = (DefaultListModel) list.getModel();
                        listModel.removeAllElements();

        label_res.setText(" ------- ICI SERONT LES RESULTATS --------");                    
                
        
    }
    

    public void setMonde(Simulation M) {
        this.Monde = M;
    }
}
