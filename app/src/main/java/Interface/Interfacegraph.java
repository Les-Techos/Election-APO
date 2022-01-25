package Interface;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

import javafx.scene.paint.Color;

public class Interfacegraph extends JFrame {
    public Interfacegraph() {
        setTitle("ELECTION-TIM-FARES");
		setSize(1200,800);
		setResizable(false);
		setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        this.add(menu, BorderLayout.SOUTH);
		JLabel label = new JLabel("Résultat: pas encore calculé ");
		JButton bouton = new JButton("Calculer");
		JTextField textField = new JTextField("écrire la");
		textField.setColumns(10);
        
		menu.add(textField);
		menu.add(bouton);
		menu.add(label);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}