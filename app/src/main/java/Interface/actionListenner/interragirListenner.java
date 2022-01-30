package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class interragirListenner implements ActionListener{

    private JPanel panel;
    private JPanel panel2;
    private JPanel panel_to_close1;
    private JPanel panel_to_close2;
    public interragirListenner(JPanel panel_crt,JPanel panel_to_close1,JPanel panel_to_close2,JPanel panel2) {
       this.panel = panel_crt;
       this.panel2 = panel2;
       this.panel_to_close1 = panel_to_close1;
       this.panel_to_close2 = panel_to_close2;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if( panel.isVisible() == false){
            panel.setVisible(true);
        }else{
            panel.setVisible(false);
            panel2.setVisible(false);
            panel_to_close1.setVisible(false);
            panel_to_close2.setVisible(false);
        }
        
    }

    
}
