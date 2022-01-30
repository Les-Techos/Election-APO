package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Simulation.Simulation;
import javafx.scene.control.Spinner;

public class SondageListenner implements ActionListener {

    private JSlider jour_influence;
    private JSpinner nbsonde;
    private JLabel liste_candidat_res;
    private Simulation Monde;

    public SondageListenner(JSpinner nbsonde, JSlider nb_jour, JLabel liste_candidat) {
        this.jour_influence = nb_jour;
        this.liste_candidat_res = liste_candidat;
        this.nbsonde = (JSpinner) nbsonde;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            System.out.println("on a creer l'influence par sondage");
            Monde.setJourDinfluence(jour_influence.getValue());
            System.out.println(Monde.getJourDinfluence());
            if ((int) nbsonde.getValue() <= Monde.getE().size()) {
                Monde.interraction_sondage((int) nbsonde.getValue());
                // TODO Auto-generated method stub
                try {
                    String res = "<html>" + Monde.LancerElection().replace("\n", "<br/>") + "</html>";

                    liste_candidat_res.setText(res);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "? probleme affichage ?");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rentrer des paramétres corrects !!!");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Rentrer des paramétres !!!");
        }

    }

    public void setMonde(Simulation M) {
        this.Monde = M;
    }
}
