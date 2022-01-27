package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Scrutin.Scrutin;
import Simulation.Simulation;

public class ComboScrutinListenner implements ActionListener {
    private Simulation Monde;
    private JComboBox chx_scrt;
    private Scrutin sa;

    public ComboScrutinListenner(Simulation monde_crt, JComboBox choixScrutin) {
        this.Monde = monde_crt;
        this.chx_scrt = choixScrutin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String res = (String) chx_scrt.getSelectedItem();

        switch (res) {
            case "majoritaire 1 tour":
                System.out.println(1);
                Monde.choixScrutin(0);
                break;
            case "majoritaire 2 tour":
                System.out.println(2);
                Monde.choixScrutin(1);
                break;
            case "Alternatif":
                System.out.println(3);
                Monde.choixScrutin(2);
                break;
            case "Approbation":
                System.out.println(4);
                Monde.choixScrutin(3);
                break;
            case "Borda":
                System.out.println(5);
                Monde.choixScrutin(4);
                break;
        }

    }

}
