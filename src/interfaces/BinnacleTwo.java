package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BinnacleTwo extends JPanel {
	
	public BinnacleTwo(IEP iep){
		JButton btnForTeacher;
		
		setLayout(null);      
		
		btnForTeacher = new JButton("");
		btnForTeacher.setBackground(new Color(0,0,0,0));
		btnForTeacher.setIcon(new ImageIcon(BinnacleTeacherOne.class.getResource("/imgs/forTeacher.png")));
		btnForTeacher.setBounds(95, 70, 117, 25);
		
		this.add(btnForTeacher);
	}
}