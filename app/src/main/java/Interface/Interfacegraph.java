package Interface;

import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class Interfacegraph extends JFrame {
    public Interfacegraph() {
        super();
        build();
    }

    private void  build() {
        setTitle("ELECTION-TIM-FARES");
		setSize(1200,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
    }
    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Résultat: pas encore calculé ");
		JButton bouton = new JButton("Calculer");
		JTextField textField = new JTextField("écrire la");
		textField.setColumns(10);
		panel.add(textField);
		panel.add(bouton);
		panel.add(label);
	 
		return panel;
    }
}
