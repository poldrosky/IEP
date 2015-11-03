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

public class BinnacleThreeGroup extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private int id;
	private JLabel lblDescription;
	private JLabel lblJustification;
	private JTextArea textDescription;
	private JScrollPane sPDescription;
	private JTextArea textJustification;
	private JScrollPane sPJustification;
	private JScrollPane scrollCenter;
	private JPanel panel;
	private JButton btnSaveInformation;
    private JButton btnNext;
    private JButton btnBack;
    private String description;
    private String justification;
	
	public BinnacleThreeGroup(EditorProject editor) {
		this.editor=editor;
		id = this.editor.getId();
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblProblemaInvestigacion"
				+ " WHERE idGRupoInvestigacion="+id);	
		
		try {
			while(rs.next()){
				description = (String) rs.getObject("Descripcion");
				justification = (String) rs.getObject("Justificacion");
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
			
			String query="UPDATE tblProblemaInvestigacion set"
					+ " Descripcion='"+textDescription.getText()+"',"
					+ " Justificacion='"+textJustification.getText()+"'"
					+ " WHERE idGrupoInvestigacion="+id;
			
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
		
	lblDescription = new JLabel("Descripción del problema que se quiere investigar");
	lblDescription.setBounds(15, 5, 370, 40);
	
	textDescription = new JTextArea();
	sPDescription = new JScrollPane(textDescription);
	textDescription.setBounds(2, 50, 390, 70);
	sPDescription.setBounds(2, 50, 390, 70);
	textDescription.setText(description);
	
	lblJustification = new JLabel("<html>Con base en el punto anterior, justifiquen la<br>"
			+ " importancia de resolver el problema o avanzar en su solucion </html>");
	lblJustification.setBounds(15, 130, 370, 50);
	
	textJustification = new JTextArea();
	sPJustification = new JScrollPane(textJustification);
	textJustification.setBounds(2, 185, 390, 70);
	sPJustification.setBounds(2, 185, 390, 70);
	textJustification.setText(justification);
	
	setLayout(null);
	panel.setLayout(null);
	panel.add(lblDescription);
	panel.add(lblJustification);
	panel.add(sPDescription);
	panel.add(sPJustification);
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
