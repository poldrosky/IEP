package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BinnacleTeacherOne extends JPanel {
	private JButton btnForTeacher;
	private EditorProject editor;

	public BinnacleTeacherOne(EditorProject editor) {
		this.editor=editor;
		this.setBounds(0, 0, 340, 280);		
		
		btnForTeacher = new JButton("");
		btnForTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickForTeacher();								
			}
		});
		btnForTeacher.setBackground(new Color(0,0,0,0));
		btnForTeacher.setIcon(new ImageIcon(BinnacleTeacherOne.class.getResource("/imgs/forTeacher.png")));
		btnForTeacher.setBounds(50, 72, 247, 77);
		
		setLayout(null);
		this.add(btnForTeacher);	
	}
	
	public void clickForTeacher() {
		BinnacleTeacherTwo binnacleTeacherTwo = new BinnacleTeacherTwo();
		this.editor.reloadPanel(binnacleTeacherTwo);
		}
}
