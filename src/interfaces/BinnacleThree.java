package interfaces;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BinnacleThree extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private JButton btnNext;
    private JButton btnBack;
    private JButton btnForTeacher;
	private JButton btnForResearchGroup;
    
	public BinnacleThree(EditorProject editor){
		this.editor=editor;		
		
		setLayout(null);      
		
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
		leftPanel.clickFour();
	}
	
	public void clickBack() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickTwo();
	}
	
	
	
}