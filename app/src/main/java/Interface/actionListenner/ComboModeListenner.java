package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Scrutin.Scrutin;
import Simulation.Simulation;

public class ComboModeListenner implements ActionListener {
    private Simulation Monde;
    private JComboBox chx_scrt;
    

    public ComboModeListenner( JComboBox choixMode) {
        this.chx_scrt = choixMode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String res = (String) chx_scrt.getSelectedItem();

        switch (res) {
            case "simple":
                System.out.println("Vous avez choisi le mode simple");
                Monde.choix_mode(0);
                break;
            case "utilite":
                System.out.println("Vous avez choisi le mode utilite");
                Monde.choix_mode(1);
                break;
            case "utilite-multiple":
                System.out.println("Vous avez choisi le mode utilite multiple");
                Monde.choix_mode(2);
                break;
        }

    }
    public void setMonde(Simulation M){
        this.Monde = M;
    }


}
