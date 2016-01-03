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
import javax.swing.ScrollPaneConstants;

import connection.ConnectionJdbcOffline;

public class BinnacleThreeTeacher extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private int id;
	private JLabel lblHow;
	private JLabel lblReflection;
	private JLabel lblConceptAdvisor;
	private JTextArea textHow;
	private JScrollPane sPHow;
	private JTextArea textReflection;
	private JScrollPane sPReflection;
	private JTextArea textConceptAdvisor;
	private JScrollPane sPConceptAdvisor;	
	private JScrollPane scrollCenter;
	private JPanel panel;
	private JButton btnSaveInformation;
    private JButton btnNext;
    private JButton btnBack;
    private String how;
    private String reflection;
    private String conceptAdvisor;
    //private Integer revision;
	
	public BinnacleThreeTeacher(EditorProject editor) {
		this.editor=editor;
		id = this.editor.getId();
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblProblemaProyectoInvestigacion"
				+ " WHERE idGRupoInvestigacion="+id);	
		
		try {
			while(rs.next()){
				how = (String) rs.getObject("Como");
				reflection = (String) rs.getObject("Reflexion");
				conceptAdvisor = (String) rs.getObject("ConceptoAsesor");
				//revision = (int) rs.getObject("Revision");
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
			
			String query="UPDATE tblProblemaProyectoInvestigacion set"
					+ " Como='"+textHow.getText()+"',"
					+ " Reflexion='"+textReflection.getText()+"',"
					+ " ConceptoAsesor='"+textConceptAdvisor.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id;
			
			//System.out.println(query);
			
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
		
	lblHow = new JLabel("<html>Relate las semejanzas y diferencias entre nuestra"
			+ " adulta de hacer preguntas y la de niñas, niños y jóvenes. (Maestro/Co-invesigador)</html>");
	lblHow.setBounds(15, 5, 370, 60);
	
	textHow = new JTextArea();
	sPHow = new JScrollPane(textHow);
	textHow.setBounds(2, 50, 390, 70);
	sPHow.setBounds(2, 70, 390, 70);
	textHow.setText(how);
	
	lblReflection = new JLabel("<html>Breve reflexión sobre el desarrollo de la bitacora"
			+ " # 3 por parte del (Maestro/co-investigador)</html>");
	lblReflection.setBounds(15, 145, 370, 40);
	
	textReflection = new JTextArea();
	sPReflection = new JScrollPane(textReflection);
	textReflection.setBounds(2, 185, 390, 70);
	sPReflection.setBounds(2, 185, 390, 70);
	textReflection.setText(reflection);
	
	lblConceptAdvisor = new JLabel("<html>Seguimiento perturbación de la ONDA</html>");
	lblConceptAdvisor.setBounds(15, 265, 370, 40);
	
	textConceptAdvisor = new JTextArea();
	sPConceptAdvisor = new JScrollPane(textConceptAdvisor);
	textConceptAdvisor.setBounds(2, 310, 390, 70);
	sPConceptAdvisor.setBounds(2, 310, 390, 70);
	textConceptAdvisor.setText(conceptAdvisor);
	textConceptAdvisor.setEnabled(false);
	
	setLayout(null);
	panel.setLayout(null);
	panel.add(lblHow);
	panel.add(lblReflection);
	panel.add(sPHow);
	panel.add(sPReflection);
	panel.add(lblConceptAdvisor);
	panel.add(sPConceptAdvisor);
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
