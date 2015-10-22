package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connection.ConnectionJdbcOffline;

public class PanelHeader extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblIEP23;
	private JLabel lblNameGroup;
	private JLabel lblMunicipality;
	private JLabel lblTeacher;
	private JLabel lblResearchLine;
	private JLabel lblNameInstitution;
	private JLabel lblNameGroup1;
	private JLabel lblMunicipality1;
	private JLabel lblTeacher1;
	private JLabel lblResearchLine1;
	private JLabel lblNameInstitution1;
	private String nameGroup;
	
	private int id;
	
	public PanelHeader(int id) {
		this.id=id;
		
		ConnectionJdbcOffline connectOffline = new ConnectionJdbcOffline();
		boolean correctConnection = connectOffline.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		ResultSet rs = connectOffline.resultSet("SELECT * FROM tblGrupoInvestigacion WHERE id="+id);
		
		try {
			while(rs.next()){
				nameGroup = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setBounds(0, 0, 670, 77);
		
		lblIEP23 = new JLabel("");
		lblIEP23.setBackground(new Color(0,0,0,0));
		lblIEP23.setBounds(0, 0, 670, 77);
		lblIEP23.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP23.png")));
		
		lblNameGroup = new JLabel("Nombre del Grupo: ");
		lblNameGroup.setBounds(15, 5, 140, 15);
		
		lblMunicipality = new JLabel("Municipio: ");
		lblMunicipality.setBounds(15, 30, 80, 15);
		
		lblTeacher = new JLabel("Maestro: ");
		lblTeacher.setBounds(15, 55, 80, 15);
		
		lblResearchLine = new JLabel("Línea de Investigación: ");
		lblResearchLine.setBounds(325, 5, 200, 15);
		
		lblNameInstitution = new JLabel("Sede Educativa: ");
		lblNameInstitution.setBounds(325, 30, 130, 15);
		
		lblNameGroup1 = new JLabel(""+nameGroup);
		lblNameGroup1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNameGroup1.setBounds(155, 5, 150, 15);
		
		lblMunicipality1 = new JLabel("Pasto ");
		lblMunicipality1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMunicipality1.setBounds(95, 30, 150, 15);
		
		lblTeacher1 = new JLabel("Omar Ernesto Cabrera Rosero ");
		lblTeacher1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTeacher1.setBounds(95, 55, 200, 15);
		
		lblResearchLine1 = new JLabel("Línea de ");
		lblResearchLine1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblResearchLine1.setBounds(495, 5, 200, 15);
		
		lblNameInstitution1 = new JLabel("Liceo ");
		lblNameInstitution1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNameInstitution1.setBounds(455, 30, 150, 15);
		
		setLayout(null);
		this.add(lblNameGroup);
		this.add(lblMunicipality);
		this.add(lblTeacher);
		this.add(lblResearchLine);
		this.add(lblNameInstitution);
		this.add(lblNameGroup1);
		this.add(lblMunicipality1);
		this.add(lblTeacher1);
		this.add(lblResearchLine1);
		this.add(lblNameInstitution1);
		this.add(lblIEP23);

	}

}
