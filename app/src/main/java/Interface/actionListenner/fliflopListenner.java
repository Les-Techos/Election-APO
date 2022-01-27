
package Interface.actionListenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class fliflopListenner implements ActionListener {

    private JPanel panel_to_open;
    private JPanel panel_to_close;
    private JPanel panel_commun;

    public fliflopListenner(JPanel panel_to_open,JPanel panel_to_close,JPanel panel_commun) {
        this.panel_to_open = panel_to_open;
        this.panel_to_close = panel_to_close;
        this.panel_commun = panel_commun;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        panel_to_open.setVisible(true);
        panel_to_close.setVisible(false);
        panel_commun.setVisible(true);
        

}}
