package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connection.ConnectionJdbcOffline;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorProject extends JPanel {
	private JLabel lblIEP11;
	private IEP iep;
	private int id;
	private PanelHeader panelHeader;
	private LeftPanel leftPanel;
    private JPanel centerPanel;
	
	public EditorProject(int id,IEP iep) {
		this.iep=iep;
		this.id=id;		
				
		this.setBounds(50, 130, 700, 406);
		
		panelHeader=new PanelHeader(id);
		panelHeader.setBounds(25, 25, 650, 77);
		
		leftPanel = new LeftPanel();
		leftPanel.setBounds(50, 110, 257, 300);
		
		centerPanel = new JPanel();
		centerPanel.setBounds(330,110, 340, 280);
		
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 700, 406);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP11.png")));	
		
		
		setLayout(null);
		this.add(centerPanel);
		this.add(panelHeader);
		this.add(leftPanel);
		this.add(lblIEP11);	
	}
	public void next(){
		BinnacleTwo binnnacleTwo=new BinnacleTwo(this.id);
    	iep.reloadPanel(binnnacleTwo);
	}
}
