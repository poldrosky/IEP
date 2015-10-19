package interfaces;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BinnacleTeacherTwo extends JPanel {
    private static final long serialVersionUID = 1L;
	private JLabel lblQuestionOne;
    private JLabel lblQuestionTwo;
    private JLabel lblQuestionThree;
    private JTextArea textAnswerOne;
    private JScrollPane sPAnswerOne;
    private JTextArea textAnswerTwo;
    private JScrollPane sPAnswerTwo;
    private JTextArea textAnswerThree;
    private JScrollPane sPAnswerThree;
    private JScrollPane scrollCenter;

    
	public BinnacleTeacherTwo() {
		this.setBounds(0, 0, 420, 340);
		scrollCenter = new JScrollPane();
		scrollCenter.setBounds(0, 0, 420, 530);
		scrollCenter.setViewportView(this);
		scrollCenter.getViewport().setView(this);		
		
		lblQuestionOne = new JLabel("");
		lblQuestionOne.setText("<html>1 Dé cuenta del proceso que hubo en su institucion<br>"
				+ "para conformar el grupo de investigación<br></html>");		
		lblQuestionOne.setBounds(2, 5, 390, 40);
		lblQuestionOne.setVisible(true);
		
		textAnswerOne = new JTextArea();
		sPAnswerOne = new JScrollPane(textAnswerOne);
		textAnswerOne.setBounds(2, 45, 390, 100);
		sPAnswerOne.setBounds(2, 45, 390, 100);
		
		lblQuestionTwo = new JLabel(""); 
		lblQuestionTwo.setText("<html>2 Explique cuales fueron los motivos  que lo llevaron<br>"
				+ "a participar en Ondas");
		lblQuestionTwo.setBounds(2, 150, 390, 40);
		
		textAnswerTwo = new JTextArea();
		sPAnswerTwo = new JScrollPane(textAnswerTwo);
		textAnswerTwo.setBounds(2, 195, 390, 100);
		sPAnswerTwo.setBounds(2, 195, 390, 100);
		
		lblQuestionThree = new JLabel(""); 
		lblQuestionThree.setText("<html>3 Breve reflexión sobre el grupo de investigación, <br>"
				+ "por parte del Maesto/Coinvestigador</html>");
		lblQuestionThree.setBounds(2, 300, 390, 100);
		
		textAnswerThree = new JTextArea();
		sPAnswerThree = new JScrollPane(textAnswerThree);
		textAnswerThree.setBounds(2, 405, 390, 100);
		sPAnswerThree.setBounds(2, 405, 390, 100);
	
		setLayout(null);
		//this.setPreferredSize(new Dimension(420,530));
		this.add(lblQuestionOne);	
		this.add(sPAnswerOne);				
		this.add(lblQuestionTwo);
		this.add(sPAnswerTwo);
		this.add(lblQuestionThree);
		this.add(sPAnswerThree);
	
	}
	
}
