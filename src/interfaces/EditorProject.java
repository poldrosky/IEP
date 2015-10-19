package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
    private JScrollPane scrollCenter;
	
	public EditorProject(int id,IEP iep) {
		this.iep=iep;
		this.id=id;		
				
		this.setBounds(50, 100, 720, 458);
		
		panelHeader=new PanelHeader(id);
		panelHeader.setBounds(25, 25, 670, 77);
		
		leftPanel = new LeftPanel(this);
		leftPanel.setBounds(30, 110, 225, 300);
		
		centerPanel = new JPanel();
		centerPanel.setBounds(270,110, 420, 340);
		scrollCenter = new JScrollPane();
		scrollCenter.add(centerPanel);
		scrollCenter.setBounds(270,110, 420, 340);
		scrollCenter.setVisible(true);
		
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 720, 458);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP11.png")));	
		BinnacleTeacherOne binnacleTeacherOne=new BinnacleTeacherOne(this);
		reloadPanel(binnacleTeacherOne);
	
		
		setLayout(null);
		this.add(scrollCenter);
		this.add(panelHeader);
		this.add(leftPanel);
		this.add(lblIEP11);		
	}
	
	public void  reloadPanel(JPanel panel) {
		this.scrollCenter.removeAll();
		this.scrollCenter.add(panel);
		this.scrollCenter.repaint();
	}
	

}
