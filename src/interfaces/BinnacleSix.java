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

public class BinnacleSix extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private JButton btnNext;
    private JButton btnBack;
    private JButton btnForTeacher;
	private JButton btnForResearchGroup;
	private JLabel lblTitle;
    
	public BinnacleSix(EditorProject editor){
		this.editor=editor;	
		
		lblTitle = new JLabel("Reflexión de la Onda");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 20, 370, 30);
		
		btnForTeacher = new JButton("");
		btnForTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnForTeacher.setBackground(new Color(0,0,0,0));
		btnForTeacher.setBorder(null);
		btnForTeacher.setIcon(new ImageIcon(BinnacleTeacherOne.class.getResource("/imgs/forTeacher.png")));
		btnForTeacher.setBounds(100, 140, 198, 70);
		
		btnForResearchGroup = new JButton("");
		btnForResearchGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickForResearchGroup();
			}
		});
		btnForResearchGroup.setBackground(new Color(0,0,0,0));
		btnForResearchGroup.setBorder(null);
		btnForResearchGroup.setIcon(new ImageIcon(BinnacleTeacherOne.class.getResource("/imgs/forResearchGroup.png")));
		btnForResearchGroup.setBounds(100, 50, 194, 70);
		
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
		
		setLayout(null);
		this.add(lblTitle);
		this.add(btnForTeacher);
		this.add(btnForResearchGroup);
		this.add(btnNext);
		this.add(btnBack);
	}
	
	public void clickForResearchGroup() {
		BinnacleTwoGroup binnacleTwoGroup = new BinnacleTwoGroup(editor);
		this.editor.reloadPanel(binnacleTwoGroup);
	}
	
	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickSeven();
	}
	
	public void clickBack() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickFive();
	}
	
	
	
}