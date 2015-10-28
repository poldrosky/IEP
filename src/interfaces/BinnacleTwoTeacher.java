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
	private JTextArea textInformationOne;
	private JScrollPane sPInformationOne;
	private JTextArea textInformationTwo;
	private JScrollPane sPInformationTwo;
	private JTextArea textInformationThree;
	private JScrollPane sPInformationThree;
	private JTextArea textReflection;
	private JScrollPane sPReflection;
	private JTextArea textConcept;
	private JScrollPane sPConcept;
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
	private Integer revision;
	private JLabel lblSourceOne;
	private JLabel lblSourceTwo;
	private JLabel lblSourceThree;
	private JLabel lblReflection;
	private JLabel lblConceptAdvisor;
	private JTextField textSourceOne;
	private JTextField textSourceTwo;
	private JTextField textSourceThree;

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
				revision = (int) rs.getObject("Revision");
				conceptAdvisor = (String) rs.getObject("ConceptoAsesor");
				reflection = (String) rs.getObject("Reflexion");
			}
		} catch (SQLException e1) {
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

				String query = "UPDATE tblPreguntaProyectoInvestigacion set "
						+ "InformacionUno='"+textInformationOne.getText()+"',"
						+ "FuenteUno='"+textSourceOne.getText()+"',"
						+ "InformacionDos='"+textInformationTwo.getText()+"',"
						+ "FuenteDos='"+textSourceTwo.getText()+"',"
						+ "InformacionTres='"+textInformationThree.getText()+"',"
						+ "FuenteTres='"+textSourceThree.getText()+"',"
						+ "Reflexion='"+textReflection.getText()+"'"
						+ " WHERE idGrupoInvestigacion="+id;
							
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

		textInformationOne = new JTextArea();
		sPInformationOne = new JScrollPane(textInformationOne);
		textInformationOne.setBounds(2, 45, 390, 70);
		sPInformationOne.setBounds(2, 45, 390, 70);
		textInformationOne.setText(informationOne);

		lblSourceOne = new JLabel("Fuente Uno: ");
		lblSourceOne.setBounds(2, 120, 95, 30);

		textSourceOne = new JTextField();
		textSourceOne.setBounds(100, 120, 290, 30);
		textSourceOne.setText(sourceOne);
		
		textInformationTwo = new JTextArea();
		sPInformationTwo = new JScrollPane(textInformationTwo);
		textInformationTwo.setBounds(2, 155, 370, 70);
		sPInformationTwo.setBounds(2, 155, 370, 70);
		textInformationTwo.setText(informationTwo);
		
		lblSourceTwo = new JLabel("Fuente Dos: ");
		lblSourceTwo.setBounds(2, 230, 95, 30);

		textSourceTwo = new JTextField();
		textSourceTwo.setBounds(100, 230, 290, 30);
		textSourceTwo.setText(sourceTwo);

		textInformationThree = new JTextArea();
		sPInformationThree = new JScrollPane(textInformationThree);
		textInformationThree.setBounds(2, 265, 390, 70);
		sPInformationThree.setBounds(2, 265, 390, 70);
		textInformationThree.setText(informationThree);
		
		lblSourceThree = new JLabel("Fuente Tres: ");
		lblSourceThree.setBounds(2, 340, 95, 30);

		textSourceThree = new JTextField();
		textSourceThree.setBounds(100, 340, 290, 30);
		textSourceThree.setText(sourceThree);

		lblReflection = new JLabel("<html>Breve reflexión sobre el desarollo de la bitácora # 2<br>"
				+ " por parte del Maestro/co-investigador</html>");
		lblReflection.setBounds(15, 380, 370, 40);		
		
		textReflection = new JTextArea();
		sPReflection = new JScrollPane(textReflection);
		textReflection.setBounds(2, 375, 390, 70);
		sPReflection.setBounds(2, 425, 390, 70);
		textReflection.setText(reflection);
		
		lblConceptAdvisor = new JLabel("Seguimiento perturbación de la ONDA");
		lblConceptAdvisor.setBounds(15, 500, 370, 40);

		textConcept = new JTextArea();
		sPConcept = new JScrollPane(textConcept);
		textConcept.setBounds(2, 545, 390, 70);
		sPConcept.setBounds(2, 545, 390, 70);
		textConcept.setText(conceptAdvisor);
		textConcept.setEditable(false);

		setLayout(null);
		panel.setLayout(null);
		panel.add(lblForTeacher);
		panel.add(sPInformationOne);
		panel.add(lblSourceOne);
		panel.add(textSourceOne);
		panel.add(sPInformationTwo);
		panel.add(lblSourceTwo);
		panel.add(textSourceTwo);
		panel.add(lblSourceThree);
		panel.add(textSourceThree);
		panel.add(sPInformationThree);
		panel.add(lblReflection);
		panel.add(sPReflection);
		panel.add(lblReflection);
		panel.add(lblConceptAdvisor);
		panel.add(sPConcept);
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
