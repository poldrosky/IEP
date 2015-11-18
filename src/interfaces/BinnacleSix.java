package interfaces;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import connection.ConnectionJdbcOffline;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BinnacleSix extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private JButton btnNext;
    private JButton btnBack;
	private JLabel lblTitle;
	private JScrollPane scrollCenter;
	private JPanel panel;
	private JLabel lblQuestionOne;
    private JLabel lblQuestionTwo;
    private JLabel lblQuestionThree;
    private JLabel lblQuestionFour;
    private JLabel lblQuestionFive;
    private JLabel lblQuestionSix;
    private JLabel lblQuestionSeven;
    private JTextArea textAnswerOne;
    private JScrollPane sPAnswerOne;
    private JTextArea textAnswerTwo;
    private JScrollPane sPAnswerTwo;
    private JTextArea textAnswerThree;
    private JScrollPane sPAnswerThree;
    private JTextArea textAnswerFour;
    private JScrollPane sPAnswerFour;
    private JTextArea textAnswerFive;
    private JScrollPane sPAnswerFive;
    private JTextArea textAnswerSix;
    private JScrollPane sPAnswerSix;
    private JTextArea textAnswerSeven;
    private JScrollPane sPAnswerSeven;
    private String introduction;
    private String conformationGroup;
    private String objectiveResearch;
    private String activitiesPerformed;
    private String mainConcepts;
    private String opportunitiesParticipation;
    private String conclusions;
    private JButton btnSaveInformation;
    private int id;
    
    
	public BinnacleSix(EditorProject editor){
		this.editor=editor;	
		id = this.editor.getId();
		
		lblTitle = new JLabel("Reflexión de la Onda");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 20, 370, 30);
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblReflexionOnda"
				+ " WHERE idGRupoInvestigacion="+id);
		
		try {
			while(rs.next()){
				introduction= (String) rs.getObject("Introduccion");
				conformationGroup = (String) rs.getObject("ConformacionGrupo");
				objectiveResearch = (String) rs.getObject("ObjetivoInvestigacion");
				activitiesPerformed = (String) rs.getObject("ActividadasRealizadas");
				mainConcepts = (String) rs.getObject("ConceptosPrincipales");
			    opportunitiesParticipation = (String) rs.getObject("EspaciosParticipacion");
			    conclusions = (String) rs.getObject("Conclusiones");
				
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
				
				String query="UPDATE tblReflexionOnda"
						+ " set Introduccion='"+textAnswerOne.getText()+"',"
						+ " ConformacionGrupo='"+textAnswerTwo.getText()+"',"
						+ " ObjetivoInvestigacion='"+textAnswerThree.getText()+"',"
						+ " ActividadasRealizadas='"+textAnswerFour.getText()+"',"
						+ " ConceptosPrincipales='"+textAnswerFive.getText()+"',"
						+ " EspaciosParticipacion='"+textAnswerSix.getText()+"',"
						+ " Conclusiones='"+textAnswerSeven.getText()+"'" 
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
				clickBack();
			}
		});
		btnBack.setBounds(10, 280, 86, 36);
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setIcon(new ImageIcon(Header.class.getResource("/imgs/back.png")));
		btnBack.setBorder(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 420, 260);
		panel.setPreferredSize(new Dimension(420,1050));	
		
		scrollCenter = new JScrollPane();
		scrollCenter.setBorder(null);
		scrollCenter.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCenter.setBounds(0, 0, 420, 260);
		scrollCenter.setViewportView(panel);
		scrollCenter.getViewport().setView(panel);
		
		lblQuestionOne = new JLabel("");
		lblQuestionOne.setText("<html>1. Escribe la Introducción</html>");		
		lblQuestionOne.setBounds(2, 5, 390, 40);
		lblQuestionOne.setVisible(true);
		
		textAnswerOne = new JTextArea();
		sPAnswerOne = new JScrollPane(textAnswerOne);
		textAnswerOne.setBounds(2, 45, 390, 100);
		sPAnswerOne.setBounds(2, 45, 390, 100);
		textAnswerOne.setText(introduction);
		
		lblQuestionTwo = new JLabel(""); 
		lblQuestionTwo.setText("<html> 2. Estar en la onda de Ondas <br>"
				+ "2.1. Como se conformó el grupo? ");
		lblQuestionTwo.setBounds(2, 150, 390, 40);
		
		textAnswerTwo = new JTextArea();
		sPAnswerTwo = new JScrollPane(textAnswerTwo);
		textAnswerTwo.setBounds(2, 195, 390, 100);
		sPAnswerTwo.setBounds(2, 195, 390, 100);
		textAnswerTwo.setText(conformationGroup);
		
		
		lblQuestionThree = new JLabel(""); 
		lblQuestionThree.setText("<html> 2.2. Diseño de la trayectoria de la indagación <br>"
				+ "Escriba el objetivo de la investigación </html>");
		lblQuestionThree.setBounds(2, 300, 390, 40);
		
		textAnswerThree = new JTextArea();
		sPAnswerThree = new JScrollPane(textAnswerThree);
		textAnswerThree.setBounds(2, 345, 390, 100);
		sPAnswerThree.setBounds(2, 345, 390, 100);
		textAnswerThree.setText(objectiveResearch);
		
		lblQuestionFour = new JLabel(""); 
		lblQuestionFour.setText("<html> 2.3. Recorrido de las trayectorias <br>"
				+ "Escriba las actividades realizadas </html>");
		lblQuestionFour.setBounds(2, 450, 390, 40);
		
		textAnswerFour = new JTextArea();
		sPAnswerFour = new JScrollPane(textAnswerFour);
		textAnswerFour.setBounds(2, 495, 390, 100);
		sPAnswerFour.setBounds(2, 495, 390, 100);
		textAnswerFour.setText(activitiesPerformed);
	
		lblQuestionFive = new JLabel(""); 
		lblQuestionFive.setText("<html> 3. Reflexión de la Onda<br> "
				+ "Escriba los conceptos principales </html>");
		lblQuestionFive.setBounds(2, 600, 390, 40);
		
		textAnswerFive = new JTextArea();
		sPAnswerFive = new JScrollPane(textAnswerFive);
		textAnswerFive.setBounds(2, 645, 390, 100);
		sPAnswerFive.setBounds(2, 645, 390, 100);
		textAnswerFive.setText(mainConcepts);
	
		lblQuestionSix = new JLabel(""); 
		lblQuestionSix.setText("<html> 3.1. Reflexión de la Onda<br>"
				+ "Escriba los espacios de participación </html>");
		lblQuestionSix.setBounds(2, 750, 390, 40);
		
		textAnswerSix = new JTextArea();
		sPAnswerSix = new JScrollPane(textAnswerSix);
		textAnswerSix.setBounds(2, 795, 390, 100);
		sPAnswerSix.setBounds(2, 795, 390, 100);
		textAnswerSix.setText(opportunitiesParticipation);
	
		lblQuestionSeven = new JLabel(""); 
		lblQuestionSeven.setText("<html>4. Conclusiones</html>");
		lblQuestionSeven.setBounds(2, 900, 390, 40);
		
		textAnswerSeven = new JTextArea();
		sPAnswerSeven = new JScrollPane(textAnswerSeven);
		textAnswerSeven.setBounds(2, 945, 390, 100);
		sPAnswerSeven.setBounds(2, 945, 390, 100);
		textAnswerSeven.setText(conclusions);
	
		setLayout(null);
		panel.setLayout(null);
		panel.add(lblQuestionOne);
		panel.add(sPAnswerOne);
		panel.add(lblQuestionTwo);
		panel.add(sPAnswerTwo);
		panel.add(lblQuestionThree);
		panel.add(sPAnswerThree);
		panel.add(lblQuestionFour);
		panel.add(sPAnswerFour);
		panel.add(lblQuestionFive);
		panel.add(sPAnswerFive);
		panel.add(lblQuestionSix);
		panel.add(sPAnswerSix);
		panel.add(lblQuestionSeven);
		panel.add(sPAnswerSeven);
		panel.setSize(editor.getIEP().getSize());
		this.add(scrollCenter);
		this.add(btnSaveInformation);
		this.add(lblTitle);
		this.add(btnNext);
		this.add(btnBack);		
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