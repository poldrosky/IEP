package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import connection.ConnectionJdbcOffline;

public class BinnacleTwoGroup extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private int id;
	private JLabel lblQuestions;
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
	private JScrollPane scrollCenter;
	private JPanel panel;
	private JButton btnSaveInformation;
    private JButton btnNext;
    private JButton btnBack;
    private List<String> questions;
    private List<Integer> idQuestions;
	
	public BinnacleTwoGroup(EditorProject editor) {
		this.editor=editor;
		id = this.editor.getId();
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblPreguntaInvestigacion"
				+ " WHERE idGRupoInvestigacion="+id);
		
		questions = new ArrayList<String>();
		idQuestions = new ArrayList<Integer>();
		
		try {
			while(rs.next()){
				questions.add((String) rs.getObject("Pregunta"));
				idQuestions.add((int) rs.getObject("id"));
				//System.out.println(rs.getObject("Pregunta"));				
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
			
			String query="UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerOne.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(0)+";";
			
			query += "UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerTwo.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(1)+";";
			
			query += "UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerThree.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(2)+";";
			
			query += "UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerFour.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(3)+";";
			
			query += "UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerFive.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(4)+";";
			
			query += "UPDATE tblPreguntaInvestigacion"
					+ " set Pregunta='"+textAnswerSix.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id+" AND id="+idQuestions.get(5)+";";
			
			System.out.println(query);
			
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
	panel.setPreferredSize(new Dimension(420,380));	
	
	scrollCenter = new JScrollPane();
	scrollCenter.setBorder(null);
	scrollCenter.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollCenter.setBounds(0, 0, 420, 260);
	scrollCenter.setViewportView(panel);
	scrollCenter.getViewport().setView(panel);
		
	lblQuestions = new JLabel("<html>Escriba cinco de las preguntas que formularon<br>  "
			+ "los integrantes del grupo de investigación</html>");
	lblQuestions.setBounds(15, 5, 370, 40);
	
	textAnswerOne = new JTextArea();
	sPAnswerOne = new JScrollPane(textAnswerOne);
	textAnswerOne.setBounds(2, 45, 390, 50);
	sPAnswerOne.setBounds(2, 45, 390, 50);
	textAnswerOne.setText(questions.get(0));
	
	textAnswerTwo = new JTextArea();
	sPAnswerTwo = new JScrollPane(textAnswerTwo);
	textAnswerTwo.setBounds(2, 100, 390, 50);
	sPAnswerTwo.setBounds(2, 100, 390, 50);
	textAnswerTwo.setText(questions.get(1));
	
	textAnswerThree = new JTextArea();
	sPAnswerThree = new JScrollPane(textAnswerThree);
	textAnswerThree.setBounds(2, 155, 390, 50);
	sPAnswerThree.setBounds(2, 155, 390, 50);
	textAnswerThree.setText(questions.get(2));
	
	textAnswerFour = new JTextArea();
	sPAnswerFour = new JScrollPane(textAnswerFour);
	textAnswerFour.setBounds(2, 210, 390, 50);
	sPAnswerFour.setBounds(2, 210, 390, 50);
	textAnswerFour.setText(questions.get(3));
	
	textAnswerFive = new JTextArea();
	sPAnswerFive = new JScrollPane(textAnswerFive);
	textAnswerFive.setBounds(2, 265, 390, 50);
	sPAnswerFive.setBounds(2, 265, 390, 50);
	textAnswerFive.setText(questions.get(4));
	
	textAnswerSix = new JTextArea();
	sPAnswerSix = new JScrollPane(textAnswerSix);
	textAnswerSix.setBounds(2, 320, 390, 50);
	sPAnswerSix.setBounds(2, 320, 390, 50);
	textAnswerSix.setText(questions.get(5));
	
	setLayout(null);
	panel.setLayout(null);
	panel.add(lblQuestions);
	panel.add(sPAnswerOne);
	panel.add(sPAnswerTwo);
	panel.add(sPAnswerThree);
	panel.add(sPAnswerFour);
	panel.add(sPAnswerFive);
	panel.add(sPAnswerSix);
	panel.setSize(editor.getIEP().getSize());
	this.add(scrollCenter);	
	this.add(btnSaveInformation);		
	this.add(btnNext);
	this.add(btnBack);
	}
	
	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickThree();
	}
	
	public void clickBack() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickOne();
	}
	

}
