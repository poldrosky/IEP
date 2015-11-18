package interfaces;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BinnacleFive extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private JButton btnNext;
    private JButton btnBack;
	private JLabel lblTitle;
	private JLabel message;
    
	public BinnacleFive(EditorProject editor){
		this.editor=editor;		
		
		lblTitle = new JLabel("Recorrido Trayectorias");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 20, 370, 30);
		
		btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickNext();				
			}
		});
		btnNext.setBounds(100, 280, 104, 36);
		btnNext.setBackground(new Color(0,0,0,0));
		btnNext.setIcon(new ImageIcon(Header.class.getResource("/imgs/next.png")));
		btnNext.setBorder(null);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBack();
			}
		});
		btnBack.setBounds(10, 280, 86, 36);
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setIcon(new ImageIcon(Header.class.getResource("/imgs/back.png")));
		btnBack.setBorder(null);
		
		message = new JLabel("<html>Este componente unicamente puede ser<br>"
				+ " modificado en la verion Online.");
		message.setBounds(20, 62, 334, 78);
		
		setLayout(null);
		this.add(lblTitle);
		this.add(btnNext);
		this.add(btnBack);
		this.add(message);
	}
	
	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickSix();
	}
	
	public void clickBack() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickFour();
	}
	
	
	
}