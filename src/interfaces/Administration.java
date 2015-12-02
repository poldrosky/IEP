package interfaces;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JButton;

import connection.ConnectionJdbcOffline;
import connection.ConnectionJdbcOnline;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Administration extends JFrame {
	private static final long serialVersionUID = 1L;
	int id;
	private JLabel lblAdmin;
	private JLabel lblPassword;
	private JPasswordField textPassword;

	// variables binnacle one
	private List<String> nameBOne = new ArrayList<String>();
	private List<String> bOne = new ArrayList<String>();
	// variables binnacletwoGroup
	private List<String> nameBTwoGroup = new ArrayList<String>();
	private List<List<String>> bTwoGroup = new ArrayList<List<String>>();
	private List<String> bTwoList = new ArrayList<String>();
	// variables binnacleTwoTeacher
	private List<String> nameBTwoTeacher = new ArrayList<String>();
	private List<String> bTwoTeacher = new ArrayList<String>();
	// variables binnaclethreegroup
	private List<String> nameBThreeGroup = new ArrayList<String>();
	private List<String> bThreeGroup = new ArrayList<String>();
	// variables binnaclethreeTeacher
	private List<String> nameBThreeTeacher = new ArrayList<String>();
	private List<String> bThreeTeacher = new ArrayList<String>();
	// variables binnacleFour
	private List<String> nameBFour = new ArrayList<String>();
	private List<List<String>> bFour = new ArrayList<List<String>>();
	private List<String> bFourList = new ArrayList<String>();
	// variables binnacleSix
	private List<String> nameBSix = new ArrayList<String>();
	private List<List<String>> bSix = new ArrayList<List<String>>();
	private List<String> bSixList = new ArrayList<String>();

	public Administration(EditorProject editor) {
		id = editor.getId();

		setAlwaysOnTop(true);
		this.setTitle("Administración");
		this.setResizable(false);
		this.setBounds(0, 0, 327, 228);

		lblAdmin = new JLabel("Administración");
		lblAdmin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdmin.setBounds(55, 12, 202, 36);

		lblPassword = new JLabel("Contraseña: ");
		lblPassword.setBounds(20, 60, 92, 20);

		textPassword = new JPasswordField();
		textPassword.setBounds(115, 60, 130, 20);

		JButton download = new JButton("Descargar");
		download.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionJdbcOnline connectOnline = new ConnectionJdbcOnline();
				ConnectionJdbcOffline connectOffline = new ConnectionJdbcOffline();
				boolean correctConnectionOnline = connectOnline.connectToDB();
				boolean correctConnectionOffline = connectOffline.connectToDB();
				if (!correctConnectionOnline || !correctConnectionOffline) {
					JOptionPane.showMessageDialog(null,
							"No hay conexión a Internet", "Error de conexión",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				String query = "SELECT * FROM [investic].[dbo].[tblReflexionProyectoInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				ResultSet rs = connectOnline.resultSet(query);

				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBOne.add(rsmd.getColumnName(i));
					}				
					while (rs.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bOne.add(rs.getString(i));
						}
					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
					e1.printStackTrace();
				}

				query = "SELECT * FROM [investic].[dbo].[tblPreguntaInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);

				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBTwoGroup.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						bTwoList = new ArrayList<String>();
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bTwoList.add(rs.getString(i));
						}
						bTwoGroup.add(bTwoList);
					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
				}

				query = "SELECT * FROM [investic].[dbo].[tblPreguntaProyectoInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);

				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBTwoTeacher.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bTwoTeacher.add(rs.getString(i));
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				query = "SELECT * FROM [investic].[dbo].[tblProblemaInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);

				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBThreeGroup.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bThreeGroup.add(rs.getString(i));
						}

					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
					e1.printStackTrace();
				}

				query = "SELECT * FROM [investic].[dbo].[tblProblemaProyectoInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);

				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBThreeTeacher.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bThreeTeacher.add(rs.getString(i));
						}
					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
					e1.printStackTrace();
				}

				query = "SELECT * FROM [investic].[dbo].[tblPresupuestoProyectoInvestigacion] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBFour.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						bFourList = new ArrayList<String>();
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bFourList.add(rs.getString(i));
						}
						bFour.add(bFourList);
					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
				}

				query = "SELECT * FROM [investic].[dbo].[tblReflexionOnda] "
						+ "WHERE [idGrupoInvestigacion] =" + id;
				rs = connectOnline.resultSet(query);
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					for (int i = 1; i < columnCount + 1; i++ ) {
						  nameBSix.add(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						bSixList = new ArrayList<String>();
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							bSixList.add(rs.getString(i));
						}
						bSix.add(bSixList);
					}
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
				}
				
				query = "DELETE FROM tblReflexionProyectoInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblPreguntaInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblPreguntaProyectoInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblProblemaInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblProblemaProyectoInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblPresupuestoProyectoInvestigacion WHERE idGrupoInvestigacion="+id+";"
						+ "DELETE FROM tblReflexionOnda WHERE idGrupoInvestigacion="+id+";";
				
				connectOffline.executeUpdate(query);						
				
				System.out.println(nameBOne);
				System.out.println("B1"+bOne);
				System.out.println(nameBTwoGroup);
				System.out.println("B2A"+bTwoGroup);
				System.out.println(nameBTwoTeacher);
				System.out.println("B2B"+bTwoTeacher);
				System.out.println(nameBThreeGroup);
				System.out.println("B3A"+bThreeGroup);
				System.out.println(nameBThreeTeacher);
				System.out.println("B3B"+bThreeTeacher);
				System.out.println(nameBFour);
				System.out.println("B4"+bFour);
				System.out.println(nameBSix);
				System.out.println("B6"+bSix);
				
				connectOffline.close();
				connectOnline.close();
			}
		});
		
		download.setBounds(70, 90, 197, 40);

		JButton upload = new JButton("Subir");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upload.setBounds(70, 135, 197, 40);

		Container container = getContentPane();
		container.setLayout(null);
		container.add(lblAdmin);
		container.add(lblPassword);
		container.add(textPassword);
		container.add(download);
		container.add(upload);

	}
}
