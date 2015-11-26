package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnAdministration;
	private EditorProject editor;
	
	public LeftPanel(EditorProject editor) {
		this.editor=editor;
		this.setBounds(0, 0, 225, 35);
		
		btnOne = new JButton("");
		btnOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOne.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton1b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOne.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton1a.png")));
			}
		});
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickOne();
			}
		});
		btnOne.setBackground(new Color(0,0,0,0));
		btnOne.setBounds(0, 0, 225, 35);
		btnOne.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton1a.png")));
		btnOne.setBorder(null);
		
		btnTwo = new JButton("");
		btnTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTwo.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton2b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTwo.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton2a.png")));
			}
		});
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickTwo();
			}
		});
		btnTwo.setBackground(new Color(0,0,0,0));
		btnTwo.setBounds(0, 36, 225, 35);
		btnTwo.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton2a.png")));
		btnTwo.setBorder(null);
		
		btnThree = new JButton("");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickThree();
			}
		});
		btnThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThree.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton3b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnThree.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton3a.png")));
			}
		});
		btnThree.setBackground(new Color(0,0,0,0));
		btnThree.setBounds(0, 72, 225, 35);
		btnThree.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton3a.png")));
		btnThree.setBorder(null);
		
		btnFour = new JButton("");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickFour();
			}
		});
		btnFour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFour.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton4b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFour.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton4a.png")));
			}
		});
		btnFour.setBackground(new Color(0,0,0,0));
		btnFour.setBounds(0, 108, 225, 35);
		btnFour.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton4a.png")));
		btnFour.setBorder(null);
		
		btnFive = new JButton("");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickFive();			
			}
		});
		btnFive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFive.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton5b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFive.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton5a.png")));
			}
		});
		btnFive.setBackground(new Color(0,0,0,0));
		btnFive.setBounds(0, 144, 225, 35);
		btnFive.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton5a.png")));
		btnFive.setBorder(null);
		
		btnSix = new JButton("");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSix();
			}
		});
		btnSix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSix.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton6b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSix.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton6a.png")));
			}
		});
		btnSix.setBackground(new Color(0,0,0,0));
		btnSix.setBounds(0, 180, 225, 35);
		btnSix.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton6a.png")));
		btnSix.setBorder(null);
		
		btnSeven = new JButton("");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSeven();
			}
		});
		btnSeven.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeven.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton7b.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeven.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton7a.png")));
			}
		});
		btnSeven.setBackground(new Color(0,0,0,0));
		btnSeven.setBounds(0, 216, 225, 35);
		btnSeven.setIcon(new ImageIcon(IEP.class.getResource("/imgs/leftButton7a.png")));
		btnSeven.setBorder(null);
		
		btnAdministration = new JButton("");
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickUpdateTotal();
			}
		});
		btnAdministration.setBackground(new Color(0,0,0,0));
		btnAdministration.setBounds(35, 255, 157, 40);
		btnAdministration.setIcon(new ImageIcon(IEP.class.getResource("/imgs/admon.png")));
		btnAdministration.setBorder(null);
		
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
	
	public void clickOne() {
		BinnacleTeacherOne binnacleTeacherOne = new BinnacleTeacherOne(this.editor);
		this.editor.reloadPanel(binnacleTeacherOne);
	}
	
	public void clickTwo() {
		BinnacleTwo binnacleTwo=new BinnacleTwo(this.editor);
		this.editor.reloadPanel(binnacleTwo);
	}
	
	public void clickThree() {
		BinnacleThree binnacleThree=new BinnacleThree(this.editor);
		this.editor.reloadPanel(binnacleThree);
	}
	
	public void clickFour() {
		BinnacleFour binnacleFour=new BinnacleFour(this.editor);
		this.editor.reloadPanel(binnacleFour);
	}
	
	public void clickFive() {
		BinnacleFive binnacleFive=new BinnacleFive(this.editor);
		this.editor.reloadPanel(binnacleFive);
	}
	
	public void clickSix() {
		BinnacleSix binnacleSix=new BinnacleSix(this.editor);
		this.editor.reloadPanel(binnacleSix);
	}
	
	public void clickSeven() {
		BinnacleSeven binnacleSeven=new BinnacleSeven(this.editor);
		this.editor.reloadPanel(binnacleSeven);
	}
	
	public void clickUpdateTotal(){
		Administration admin = new Administration(this.editor);
		admin.setVisible(true);
	}
	
}
