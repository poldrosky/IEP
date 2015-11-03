package interfaces;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BinnacleTeacherOne extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnForTeacher;
	private EditorProject editor;
	private JButton btnNext;
    private JButton btnBack;
    private JLabel lblTitle;

	public BinnacleTeacherOne(EditorProject editor) {
		this.editor=editor;
		this.setBounds(0, 0, 420, 340);	
		
		lblTitle = new JLabel("Estar en la Onda de Ondas");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 20, 370, 30);
		
		btnForTeacher = new JButton("");
		btnForTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickForTeacher();								
			}
		});
		btnForTeacher.setBackground(new Color(0,0,0,0));
		btnForTeacher.setIcon(new ImageIcon(BinnacleTeacherOne.class.getResource("/imgs/binnacleForTeacher.png")));
		btnForTeacher.setBounds(50, 72, 247, 77);
		btnForTeacher.setBorder(null);
		
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
			}
		});
		btnBack.setBounds(10, 280, 86, 36);
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setIcon(new ImageIcon(Header.class.getResource("/imgs/back.png")));
		btnBack.setBorder(null);
		btnBack.setEnabled(false);
		
		setLayout(null);
		this.add(lblTitle);
		this.add(btnForTeacher);
		this.add(btnBack);
		this.add(btnNext);
	}
	
	public void clickForTeacher() {
		BinnacleTeacherTwo binnacleTeacherTwo = new BinnacleTeacherTwo(editor);
		this.editor.reloadPanel(binnacleTeacherTwo);
	}
	
	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickTwo();
	}
}
