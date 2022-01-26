package Interface.actionListenner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testListenner implements ActionListener{
    private int click;
    public testListenner(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("CLICK BUG");        
    }
    
}
