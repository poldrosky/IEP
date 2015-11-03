package interfaces;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import connection.ConnectionJdbcOffline;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    private JPanel panel;
    private JButton btnSaveInformation;
    private JButton btnNext;
    private JButton btnBack;
    private EditorProject editor;
    private String process;
    private String motivation;
    private String reflection;
    private String conceptAdvisor;
    private JLabel lblTracing;
    private JTextArea textConceptAdvisor;
    private JLabel lblRevision;
    private int id;
    
	public BinnacleTeacherTwo(EditorProject editor) {
		this.editor=editor;
		id = this.editor.getId();
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblReflexionProyectoInvestigacion"
				+ " WHERE idGRupoInvestigacion="+id);
		
		try {
			while(rs.next()){
				process= (String) rs.getObject("Proceso");
				motivation= (String) rs.getObject("Motivacion");
				reflection= (String) rs.getObject("Reflexion");
				conceptAdvisor= (String) rs.getObject("ConceptoAsesor");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connect.close();
		
		
		btnSaveInformation = new JButton("");
		btnSaveInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
				boolean correctConnection = connect.connectToDB();
				if (!correctConnection) {
					return;
				}				
				
				String query="UPDATE tblReflexionProyectoInvestigacion"
						+ " set Proceso='"+textAnswerOne.getText()+"',"
						+ " Motivacion='"+textAnswerTwo.getText()+"',"
						+ " Reflexion='"+textAnswerThree.getText()+"'" 
						+ " WHERE idGrupoInvestigacion="+id;
				
				connect.executeUpdate(query);
			}
		});
		btnSaveInformation.setBounds(220, 280, 197, 40);
		btnSaveInformation.setBackground(new Color(0,0,0,0));
		btnSaveInformation.setIcon(new ImageIcon(Header.class.getResource("/imgs/saveInformation.png")));
		btnSaveInformation.setBorder(null);
		
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
				
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 420, 260);
		panel.setPreferredSize(new Dimension(420,600));		
		
		scrollCenter = new JScrollPane();
		scrollCenter.setBorder(null);
		scrollCenter.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCenter.setBounds(0, 0, 420, 260);
		scrollCenter.setViewportView(panel);
		scrollCenter.getViewport().setView(panel);		
		
		lblQuestionOne = new JLabel("");
		lblQuestionOne.setText("<html>1 Dé cuenta del proceso que hubo en su institucion"
				+ "para conformar el grupo de investigación<br></html>");		
		lblQuestionOne.setBounds(2, 5, 390, 40);
		lblQuestionOne.setVisible(true);
		
		textAnswerOne = new JTextArea();
		sPAnswerOne = new JScrollPane(textAnswerOne);
		textAnswerOne.setBounds(2, 45, 390, 100);
		sPAnswerOne.setBounds(2, 45, 390, 100);
		textAnswerOne.setText(process);
		
		lblQuestionTwo = new JLabel(""); 
		lblQuestionTwo.setText("<html>2 Explique cuales fueron los motivos  que lo llevaron"
				+ "a participar en Ondas");
		lblQuestionTwo.setBounds(2, 150, 390, 40);
		
		textAnswerTwo = new JTextArea();
		sPAnswerTwo = new JScrollPane(textAnswerTwo);
		textAnswerTwo.setBounds(2, 195, 390, 100);
		sPAnswerTwo.setBounds(2, 195, 390, 100);
		textAnswerTwo.setText(motivation);
		
		
		lblQuestionThree = new JLabel(""); 
		lblQuestionThree.setText("<html>3 Breve reflexión sobre el grupo de investigación,"
				+ "por parte del Maesto/Coinvestigador</html>");
		lblQuestionThree.setBounds(2, 300, 390, 40);
		
		textAnswerThree = new JTextArea();
		sPAnswerThree = new JScrollPane(textAnswerThree);
		textAnswerThree.setBounds(2, 405, 390, 100);
		sPAnswerThree.setBounds(2, 345, 390, 100);
		textAnswerThree.setText(reflection);
		
		lblTracing = new JLabel("Seguimiento de la Onda");
		lblTracing.setBounds(2, 450, 250, 40);
		
		textConceptAdvisor = new JTextArea("");
		textConceptAdvisor.setBounds(2, 495, 250, 80);
		textConceptAdvisor.setText(conceptAdvisor);
		textConceptAdvisor.setEnabled(false);
		
		lblRevision = new JLabel("Revisión");
		lblRevision.setBounds(300, 450, 90, 40);
	
		setLayout(null);
		panel.setLayout(null);
		panel.add(lblQuestionOne);	
		panel.add(sPAnswerOne);				
		panel.add(lblQuestionTwo);
		panel.add(sPAnswerTwo);
		panel.add(lblQuestionThree);
		panel.add(sPAnswerThree);
		panel.add(lblTracing);
		panel.add(textConceptAdvisor);
		panel.add(lblRevision);
		panel.setSize(editor.getIEP().getSize());
		this.add(scrollCenter);
		this.add(btnSaveInformation);		
		this.add(btnNext);
		this.add(btnBack);	
	}
	
	
	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickTwo();
	}
	
}
