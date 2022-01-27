package Interface.actionListenner;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFileChooser;
import javax.swing.JPanel;

import Simulation.Simulation;

public class LoadListenner implements ActionListener{

    private Simulation Monde;
    private JPanel mPanel;

    public LoadListenner(JPanel explorateur){
        this.mPanel = explorateur;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(mPanel);
    }

    public void setMonde(Simulation M){
        this.Monde = M;
    }
}
