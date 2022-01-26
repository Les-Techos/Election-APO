package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class interragirListenner implements ActionListener{

    private JPanel panel;
    public interragirListenner(JPanel panel_crt) {
       this.panel = panel_crt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if( panel.isVisible() == false){
            this.panel.setVisible(true);
        }else{
            this.panel.setVisible(false);
        }
        
    }

    
}
