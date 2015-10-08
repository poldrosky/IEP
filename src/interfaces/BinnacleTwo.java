package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connection.ConnectionJdbcOffline;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BinnacleTwo extends JPanel {
	JButton btnNewButton;

	public BinnacleTwo() {
		
		this.setBounds(0, 0, 340, 280);		
		
		btnNewButton = new JButton("Esta es otra");
		btnNewButton.setBounds(116, 118, 117, 25);
		
		setLayout(null);
		this.add(btnNewButton);
	}
}
