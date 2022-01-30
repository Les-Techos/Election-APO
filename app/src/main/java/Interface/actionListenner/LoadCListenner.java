package Interface.actionListenner;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Interface.Interfacegraph;
import Personne.Candidat;
import Personne.Electeur;
import Simulation.Simulation;
import utils.SaveManager;

public class LoadCListenner implements ActionListener {

    private Simulation Monde;
    private JList liste_candidat;
    private JPanel mPanel;
    private Interfacegraph graph;

    public LoadCListenner(Interfacegraph graph, JList liste_candidat, JPanel explorateur) {
        this.graph = graph;
        this.liste_candidat = liste_candidat;
        this.mPanel = explorateur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Monde = new Simulation();
        // TODO Auto-generated method stub
        final JFileChooser fc_candidat = new JFileChooser();
        fc_candidat.showOpenDialog(mPanel);
        File file_candidat = fc_candidat.getSelectedFile();
        try {
            if (file_candidat.getAbsolutePath() == null) {
                JOptionPane.showMessageDialog(null, "choisisez un fichier");
            } else {
                SaveManager.readIterableFrom(Monde.getC(), file_candidat.getAbsolutePath(), Candidat.class);
            }
            // System.out.println("les Candidats seront" + file_candidat.getAbsolutePath());

            final JFileChooser fc_electeur = new JFileChooser();
            fc_electeur.showOpenDialog(mPanel);
            File file_electeur = fc_electeur.getSelectedFile();
            try {
                if (file_electeur.getAbsolutePath() == null) {
                    JOptionPane.showMessageDialog(null, "chosisez un fichier");
                } else {
                    SaveManager.readIterableFrom(Monde.getE(), file_electeur.getAbsolutePath(), Electeur.class);
                }
                // System.out.println("les Electeurs seront" + file_electeur.getAbsolutePath());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            graph.setMonde(Monde);
            mPanel.setVisible(true);
            Monde.setSa(Monde.choixScrutin(0));

            DefaultListModel listmodel = new DefaultListModel<>();
            listmodel.addElement("------Candidat de départ------");
            for (Candidat c : Monde.getC()) {
                String res = "";
                res = "Candidat n° " + c.getCustom_hashCode() + " Axe \n ecologique " + c.getEcologie().getValeur()
                        + " pouvoire d'achat " + c.getPouvoir_achat().getValeur();
                listmodel.addElement(res);
            }
            liste_candidat.setModel(listmodel);
        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

    }

    public void setMonde(Simulation M) {
        this.Monde = M;
    }
}
