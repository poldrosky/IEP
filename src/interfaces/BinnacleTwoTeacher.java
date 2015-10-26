package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import connection.ConnectionJdbcOffline;

public class BinnacleTwoTeacher extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private int id;
	private JLabel lblForTeacher;
	private JTextArea textAnswerOne;
	private JScrollPane sPAnswerOne;
	private JTextArea textAnswerTwo;
	private JScrollPane sPAnswerTwo;
	private JTextArea textAnswerThree;
	private JScrollPane sPAnswerThree;
	private JTextArea textAnswerReflection;
	private JScrollPane sPAnswerReflection;
	private JTextArea textAnswerConcept;
	private JScrollPane sPAnswerConcept;
	private JScrollPane scrollCenter;
	private JPanel panel;
	private JButton btnSaveInformation;
	private JButton btnNext;
	private JButton btnBack;
	private String informationOne;
	private String sourceOne;
	private String informationTwo;
	private String sourceTwo;
	private String informationThree;
	private String sourceThree;
	private String reflection;
	private String conceptAdvisor;
	private String revision;
	private JLabel lblSourceOne;
	private JLabel lblSourceTwo;
	private JLabel lblSourceThree;
	private JLabel lblReflection;
	private JLabel lblConceptAdvisor;
	private JTextField txtSourceOne;
	private JTextField txtSourceTwo;
	private JTextField txtSourceThree;

	public BinnacleTwoTeacher(EditorProject editor) {
		this.editor = editor;
		id = this.editor.getId();

		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}

		ResultSet rs = connect
				.resultSet("SELECT * FROM tblPreguntaProyectoInvestigacion"
						+ " WHERE idGRupoInvestigacion=" + id);

		try {
			while (rs.next()) {
				informationOne = (String) rs.getObject("InformacionUno");
				sourceOne = (String) rs.getObject("FuenteUno");
				informationTwo = (String) rs.getObject("InformacionDos");
				sourceTwo = (String) rs.getObject("FuenteDos");
				informationThree = (String) rs.getObject("InformacionTres");
				sourceThree = (String) rs.getObject("FuenteTres");
				revision = (String) rs.getObject("Revision");
				conceptAdvisor = (String) rs.getObject("ConceptoAsesor");
				reflection = (String) rs.getObject("Reflexion");
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

				String query = "Aqui va el Query";
				System.out.println(query);

				connect.executeUpdate(query);
			}
		});
		btnSaveInformation.setBounds(220, 280, 197, 40);
		btnSaveInformation.setBackground(new Color(0, 0, 0, 0));
		btnSaveInformation.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/saveInformation.png")));
		btnSaveInformation.setBorder(null);

		btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickNext();
			}
		});
		btnNext.setBounds(100, 280, 104, 36);
		btnNext.setBackground(new Color(0, 0, 0, 0));
		btnNext.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/next.png")));
		btnNext.setBorder(null);

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBack();
			}
		});
		btnBack.setBounds(10, 280, 86, 36);
		btnBack.setBackground(new Color(0, 0, 0, 0));
		btnBack.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/back.png")));
		btnBack.setBorder(null);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 420, 260);
		panel.setPreferredSize(new Dimension(420, 630));

		scrollCenter = new JScrollPane();
		scrollCenter.setBorder(null);
		scrollCenter.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCenter.setBounds(0, 0, 420, 260);
		scrollCenter.setViewportView(panel);
		scrollCenter.getViewport().setView(panel);

		lblForTeacher = new JLabel(
				"<html>¿Qué información consultada les permitió cambiar,<br>"
						+ " ampliar o reformular las preguntas iniciales?</html>");
		lblForTeacher.setBounds(15, 5, 370, 40);

		textAnswerOne = new JTextArea();
		sPAnswerOne = new JScrollPane(textAnswerOne);
		textAnswerOne.setBounds(2, 45, 390, 70);
		sPAnswerOne.setBounds(2, 45, 390, 70);
		textAnswerOne.setText(informationOne);

		lblSourceOne = new JLabel("Fuente Uno: ");
		lblSourceOne.setBounds(2, 120, 95, 30);

		txtSourceOne = new JTextField();
		txtSourceOne.setBounds(100, 120, 290, 30);
		
		textAnswerTwo = new JTextArea();
		sPAnswerTwo = new JScrollPane(textAnswerTwo);
		textAnswerTwo.setBounds(2, 155, 370, 70);
		sPAnswerTwo.setBounds(2, 155, 370, 70);
		textAnswerTwo.setText(informationTwo);
		
		lblSourceTwo = new JLabel("Fuente Dos: ");
		lblSourceTwo.setBounds(2, 230, 95, 30);

		txtSourceTwo = new JTextField();
		txtSourceTwo.setBounds(100, 230, 290, 30);

		textAnswerThree = new JTextArea();
		sPAnswerThree = new JScrollPane(textAnswerThree);
		textAnswerThree.setBounds(2, 265, 390, 70);
		sPAnswerThree.setBounds(2, 265, 390, 70);
		textAnswerThree.setText(informationThree);
		
		lblSourceThree = new JLabel("Fuente Tres: ");
		lblSourceThree.setBounds(2, 340, 95, 30);

		txtSourceThree = new JTextField();
		txtSourceThree.setBounds(100, 340, 290, 30);

		lblReflection = new JLabel("<html>Breve reflexión sobre el desarollo de la bitácora # 2<br>"
				+ " por parte del Maestro/co-investigador</html>");
		lblReflection.setBounds(15, 380, 370, 40);		
		
		textAnswerReflection = new JTextArea();
		sPAnswerReflection = new JScrollPane(textAnswerReflection);
		textAnswerReflection.setBounds(2, 375, 390, 70);
		sPAnswerReflection.setBounds(2, 425, 390, 70);
		textAnswerReflection.setText(reflection);
		
		lblConceptAdvisor = new JLabel("Seguimiento perturbación de la ONDA");
		lblConceptAdvisor.setBounds(15, 500, 370, 40);

		textAnswerConcept = new JTextArea();
		sPAnswerConcept = new JScrollPane(textAnswerConcept);
		textAnswerConcept.setBounds(2, 545, 390, 70);
		sPAnswerConcept.setBounds(2, 545, 390, 70);
		textAnswerConcept.setText(conceptAdvisor);
		textAnswerConcept.setEditable(false);

		setLayout(null);
		panel.setLayout(null);
		panel.add(lblForTeacher);
		panel.add(sPAnswerOne);
		panel.add(lblSourceOne);
		panel.add(txtSourceOne);
		panel.add(sPAnswerTwo);
		panel.add(lblSourceTwo);
		panel.add(txtSourceTwo);
		panel.add(lblSourceThree);
		panel.add(txtSourceThree);
		panel.add(sPAnswerThree);
		panel.add(lblReflection);
		panel.add(sPAnswerReflection);
		panel.add(lblReflection);
		panel.add(lblConceptAdvisor);
		panel.add(sPAnswerConcept);
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
