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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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
					for (int i = 1; i < columnCount + 1; i++) {
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

				query = "DELETE FROM tblReflexionProyectoInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblPreguntaInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblPreguntaProyectoInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblProblemaInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblProblemaProyectoInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblPresupuestoProyectoInvestigacion WHERE idGrupoInvestigacion="
						+ id
						+ ";\n"
						+ "DELETE FROM tblReflexionOnda WHERE idGrupoInvestigacion="
						+ id + ";\n";

				// connectOffline.executeUpdate(query);
				String query1 = "INSERT INTO tblReflexionProyectoInvestigacion"
						+ " (" + nameBOne.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bOne.toString().replaceAll("\\[|\\]", "'").replace(",", "','") + ");\n";

				String query2 = "";
				for (List<String> bt : bTwoGroup) {
					query2 = query2
							+ "INSERT INTO tblPreguntaInvestigacion"
							+ " ("
							+ nameBTwoGroup.toString()
									.replaceAll("\\[|\\]", "") + ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'").replace(",", "','") + ");\n";
				}

				String query3 = "INSERT INTO tblPreguntaProyectoInvestigacion"
						+ " ("
						+ nameBTwoTeacher.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bTwoTeacher.toString().replaceAll("\\[|\\]", "'").replace(",", "','")
						+ ");\n";

				String query4 = "INSERT INTO tblProblemaInvestigacion" + " ("
						+ nameBThreeGroup.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bThreeGroup.toString().replaceAll("\\[|\\]", "'").replace(",", "','")
						+ ");\n";

				String query5 = "INSERT INTO tblProblemaProyectoInvestigacion"
						+ " ("
						+ nameBThreeTeacher.toString()
								.replaceAll("\\[|\\]", "") + ") VALUES ("
						+ bThreeTeacher.toString().replaceAll("\\[|\\]", "'").replace(",", "','")
						+ ");\n";

				String query6 = "";
				for (List<String> bt : bFour) {
					query6 = query6
							+ "INSERT INTO tblPresupuestoProyectoInvestigacion"
							+ " ("
							+ nameBFour.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'").replace(",", "','") + ");\n";
				}

				String query7 = "";
				for (List<String> bt : bSix) {
					query7 = query7
							+ "INSERT INTO tblReflexionOnda"
							+ " ("
							+ nameBSix.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'").replace(",", "','") + ");\n";
				}

				/*System.out.println(query);
				System.out.println(query1);
				System.out.println(query2);
				System.out.println(query3);
				System.out.println(query4);
				System.out.println(query5);
				System.out.println(query6);
				System.out.println(query7);*/
				
				String queryFinal = query + query1 + query2 +query3 + query4 + query5 
						+ query6 + query7;

				//System.out.println(queryFinal);
				
				connectOffline.executeUpdate(queryFinal);
				
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
