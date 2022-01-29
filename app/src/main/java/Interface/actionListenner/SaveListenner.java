package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Simulation.Simulation;
import utils.SaveManager;

public class SaveListenner implements ActionListener{

    Simulation Monde;
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        try {
            SaveManager.saveIterableTo(Monde.getE(), "ressources/elect.txt");
            SaveManager.saveIterableTo(Monde.getC(), "ressources/cand.txt");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "La sauvegarde a échoué vérifier  \n que vous posséder les fichiers de save");
        }
    }
    public void setMonde(Simulation M){
        this.Monde = M;
    }
    
}
