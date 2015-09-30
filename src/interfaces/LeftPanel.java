package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {
	
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnAdministration;
	
	public LeftPanel() {
		
		this.setBounds(0, 0, 257, 300);
		
		btnOne = new JButton("");
		btnOne.setBackground(new Color(0,0,0,0));
		btnOne.setBounds(0, 0, 257, 30);
		btnOne.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton1a.png")));
		
		btnTwo = new JButton("");
		btnTwo.setBackground(new Color(0,0,0,0));
		btnTwo.setBounds(0, 35, 257, 30);
		btnTwo.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton2a.png")));
		
		btnThree = new JButton("");
		btnThree.setBackground(new Color(0,0,0,0));
		btnThree.setBounds(0, 70, 257, 30);
		btnThree.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton3a.png")));
		
		btnFour = new JButton("");
		btnFour.setBackground(new Color(0,0,0,0));
		btnFour.setBounds(0, 105, 257, 30);
		btnFour.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton4a.png")));
		
		btnFive = new JButton("");
		btnFive.setBackground(new Color(0,0,0,0));
		btnFive.setBounds(0, 140, 257, 30);
		btnFive.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton5a.png")));
		
		btnSix = new JButton("");
		btnSix.setBackground(new Color(0,0,0,0));
		btnSix.setBounds(0, 175, 257, 30);
		btnSix.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton6a.png")));
		
		btnSeven = new JButton("");
		btnSeven.setBackground(new Color(0,0,0,0));
		btnSeven.setBounds(0, 210, 257, 30);
		btnSeven.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton7a.png")));
		
		btnAdministration = new JButton("");
		btnAdministration.setBackground(new Color(0,0,0,0));
		btnAdministration.setBounds(70, 245, 157, 40);
		btnAdministration.setIcon(new ImageIcon(IEP.class.getResource("/imgs/admon.png")));
		
		
		setLayout(null);
		this.add(btnOne);
		this.add(btnTwo);
		this.add(btnThree);
		this.add(btnFour);
		this.add(btnFive);
		this.add(btnSix);
		this.add(btnSeven);
		this.add(btnAdministration);
	}

}
