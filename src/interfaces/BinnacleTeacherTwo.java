package interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BinnacleTeacherTwo extends JPanel {
    private JLabel lblQuestionOne;
    private JLabel lblQuestionTwo;
    
	
	public BinnacleTeacherTwo() {
		this.setBounds(0, 0, 340, 280);	
		
		lblQuestionOne = new JLabel("");
		lblQuestionOne.setText("1. Dé cuenta del proceso que hubo en su institucion\n"
				+ "para conformar el grupo de investigación");		
		lblQuestionOne.setBounds(5, 35, 320, 40);
		
		lblQuestionTwo = new JLabel(""); 
		lblQuestionTwo.setText("2. Explique cuales fueron los motivos que lo llevaron\n"
				+ "a particimar en Ondas");
		lblQuestionTwo.setBounds(5, 100, 320, 40);
		
		
		setLayout(null);
		this.add(lblQuestionOne);
		this.add(lblQuestionTwo);

	}

}
