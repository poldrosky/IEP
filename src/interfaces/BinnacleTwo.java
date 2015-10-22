package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BinnacleTwo extends JPanel {
	
	public BinnacleTwo(IEP iep){
		
		setLayout(null);      
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(95, 70, 117, 25);
		add(btnNewButton);
	}
}