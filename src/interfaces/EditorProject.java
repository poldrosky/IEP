package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditorProject extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblIEP11;
	private IEP iep;
	private int id;
	private PanelHeader panelHeader;
	private LeftPanel leftPanel;
    private JPanel centerPanel;
	
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
		
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 720, 458);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP11.png")));	
		BinnacleTeacherOne binnacleTeacherOne=new BinnacleTeacherOne(this);
		reloadPanel(binnacleTeacherOne);
	
		
		setLayout(null);
		this.add(centerPanel);
		this.add(panelHeader);
		this.add(leftPanel);
		this.add(lblIEP11);		
	}
	
	public IEP getIEP(){
		return this.iep;
	}
	
	public void  reloadPanel(JPanel panel) {
		this.centerPanel.removeAll();
		panel.setSize(this.centerPanel.getSize());
		this.centerPanel.add(panel);
		this.centerPanel.repaint();
	}
	

}
