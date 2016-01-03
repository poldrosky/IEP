package interfaces;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import connection.ConnectionJdbcOffline;
import connection.ConnectionJdbcOnline;
import credencial.Credencial;

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
	private JLabel lblUser;
	private JTextField textUser;
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

	public Administration(final EditorProject editor) {
		id = editor.getId();

		setAlwaysOnTop(true);
		this.setTitle("Administración");
		this.setResizable(false);
		this.setBounds(0, 0, 327, 250);

		lblAdmin = new JLabel("Administración");
		lblAdmin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdmin.setBounds(55, 10, 202, 36);
		
		lblUser = new JLabel("Usuario: ");
		lblUser.setBounds(30, 55, 92, 10);
		
		textUser = new JTextField();
		textUser.setBounds(125, 55, 130, 20);

		lblPassword = new JLabel("Contraseña: ");
		lblPassword.setBounds(30, 85, 92, 20);

		textPassword = new JPasswordField();
		textPassword.setBounds(125, 85, 130, 20);

		JButton download = new JButton("");
		download.setIcon(new ImageIcon(Administration.class.getResource("/imgs/download.png")));
		download.setBackground(new Color(0,0,0,0));
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
				
				Credencial credential = new Credencial();
				String passText = new String(textPassword.getPassword());
				if (!credential.login(""+editor.getId(), textUser.getText(), passText)){
					JOptionPane.showMessageDialog(null,
							"Su usuario o contraseña es incorrecta", "Error de autentificación",
							JOptionPane.ERROR_MESSAGE);
					return;							
				}
				
				int n = JOptionPane.showConfirmDialog(
			            null,
			            "Esta seguro de descargar la información?,\n los cambios en esta"
			            + " versión se sobreescribirá",
			            "Confirmación de sincronización",
			            JOptionPane.YES_NO_OPTION);
				
				if (n==1){
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
						+ " ("
						+ nameBOne.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bOne.toString().replaceAll("\\[|\\]", "'")
								.replace(",", "','") + ");\n";

				String query2 = "";
				for (List<String> bt : bTwoGroup) {
					query2 = query2
							+ "INSERT INTO tblPreguntaInvestigacion"
							+ " ("
							+ nameBTwoGroup.toString()
									.replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(",", "','") + ");\n";
				}

				String query3 = "INSERT INTO tblPreguntaProyectoInvestigacion"
						+ " ("
						+ nameBTwoTeacher.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bTwoTeacher.toString().replaceAll("\\[|\\]", "'")
								.replace(",", "','") + ");\n";

				String query4 = "INSERT INTO tblProblemaInvestigacion"
						+ " ("
						+ nameBThreeGroup.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bThreeGroup.toString().replaceAll("\\[|\\]", "'")
								.replace(",", "','") + ");\n";

				String query5 = "INSERT INTO tblProblemaProyectoInvestigacion"
						+ " ("
						+ nameBThreeTeacher.toString()
								.replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bThreeTeacher.toString().replaceAll("\\[|\\]", "'")
								.replace(",", "','") + ");\n";

				String query6 = "";
				for (List<String> bt : bFour) {
					query6 = query6
							+ "INSERT INTO tblPresupuestoProyectoInvestigacion"
							+ " ("
							+ nameBFour.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(",", "','") + ");\n";
				}

				String query7 = "";
				for (List<String> bt : bSix) {
					query7 = query7
							+ "INSERT INTO tblReflexionOnda"
							+ " ("
							+ nameBSix.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(",", "','") + ");\n";
				}

				/*
				 * System.out.println(query); System.out.println(query1);
				 * System.out.println(query2); System.out.println(query3);
				 * System.out.println(query4); System.out.println(query5);
				 * System.out.println(query6); System.out.println(query7);
				 */

				String queryFinal = query + query1 + query2 + query3 + query4
						+ query5 + query6 + query7;

				// System.out.println(queryFinal);

				try {
					connectOffline.getConnection().setAutoCommit(false);
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
					e1.printStackTrace();
				}

				connectOffline.executeUpdate(queryFinal);
				try {
					connectOffline.getConnection().commit();
					connectOffline.getConnection().setAutoCommit(true);
					JOptionPane.showMessageDialog(null,
							"Se ha sincronizado correctamente");
					dispose();
				} catch (SQLException e1) {
					try {
						connectOffline.getConnection().rollback();
						JOptionPane.showMessageDialog(null,
								"Ocurrio un error, revise su conexión",
								"Error de sincronización",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e2) {
						System.err.println("Error: " + e2.getMessage());
						e2.printStackTrace();
					}
					e1.printStackTrace();
				}
				connectOffline.close();
				connectOnline.close();
			}
		});

		download.setBounds(72, 115, 196, 40);
		JButton upload = new JButton("");
		upload.setIcon(new ImageIcon(Administration.class.getResource("/imgs/upload.png")));
		upload.setBackground(new Color(0,0,0,0));
		
		upload.addActionListener(new ActionListener() {
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
				
				Credencial credential = new Credencial();
				String passText = new String(textPassword.getPassword());
				if (!credential.login(""+editor.getId(), textUser.getText(), passText)){
					JOptionPane.showMessageDialog(null,
							"Su usuario o contraseña es incorrecta", "Error de autentificación",
							JOptionPane.ERROR_MESSAGE);
					return;							
				}
				
				int n = JOptionPane.showConfirmDialog(
			            null,
			            "Esta seguro de descargar la información?,\n los cambios en la"
			            + " versión Online se sobrescribirá",
			            "Confirmación de sincronización",
			            JOptionPane.YES_NO_OPTION);
				
				if (n==1){
					return;
				}

				String query = "SELECT * FROM tblReflexionProyectoInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				ResultSet rs = connectOffline.resultSet(query);

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

				query = "SELECT * FROM tblPreguntaInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);

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

				query = "SELECT * FROM tblPreguntaProyectoInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);

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

				query = "SELECT * FROM tblProblemaInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);

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

				query = "SELECT * FROM tblProblemaProyectoInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);

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

				query = "SELECT * FROM tblPresupuestoProyectoInvestigacion "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);
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

				query = "SELECT * FROM tblReflexionOnda "
						+ "WHERE idGrupoInvestigacion =" + id;
				rs = connectOffline.resultSet(query);
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

				query = "DELETE FROM [investic].[dbo].[tblReflexionProyectoInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblPreguntaInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblPreguntaProyectoInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblProblemaInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblProblemaProyectoInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblPresupuestoProyectoInvestigacion] WHERE [idGrupoInvestigacion]="
						+ id
						+ ";\n"
						+ "DELETE FROM [investic].[dbo].[tblReflexionOnda] WHERE [idGrupoInvestigacion]="
						+ id + ";\n";

				// connectOffline.executeUpdate(query);
				String query1 = "SET IDENTITY_INSERT [investic].[dbo].[tblReflexionProyectoInvestigacion] ON;";
				query1 += "INSERT INTO [investic].[dbo].[tblReflexionProyectoInvestigacion]"
						+ " ("
						+ nameBOne.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bOne.toString().replaceAll("\\[|\\]", "'")
								.replace(", ", "','").replace("null","") + ");\n";
				query1 +="SET IDENTITY_INSERT [investic].[dbo].[tblReflexionProyectoInvestigacion] OFF;";

				String query2 = "SET IDENTITY_INSERT [investic].[dbo].[tblPreguntaInvestigacion] ON;";
				for (List<String> bt : bTwoGroup) {
					query2 = query2
							+ "INSERT INTO [investic].[dbo].[tblPreguntaInvestigacion]"
							+ " ("
							+ nameBTwoGroup.toString()
									.replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(", ", "','").replace("null","") + ");\n";
				}
				query2+= "SET IDENTITY_INSERT [investic].[dbo].[tblPreguntaInvestigacion] OFF;";

				String query3 = "SET IDENTITY_INSERT [investic].[dbo].[tblPreguntaProyectoInvestigacion] ON;";
				query3+="INSERT INTO [investic].[dbo].[tblPreguntaProyectoInvestigacion]"
						+ " ("
						+ nameBTwoTeacher.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bTwoTeacher.toString().replaceAll("\\[|\\]", "'")
								.replace(", ", "','").replace("null","") + ");\n";
				query3+="SET IDENTITY_INSERT [investic].[dbo].[tblPreguntaProyectoInvestigacion] OFF;";

				String query4 = "SET IDENTITY_INSERT [investic].[dbo].[tblProblemaInvestigacion] ON;";
				query4 += "INSERT INTO [investic].[dbo].[tblProblemaInvestigacion]"
						+ " ("
						+ nameBThreeGroup.toString().replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bThreeGroup.toString().replaceAll("\\[|\\]", "'")
								.replace(", ", "','").replace("null","") + ");\n";
				query4 += "SET IDENTITY_INSERT [investic].[dbo].[tblProblemaInvestigacion] OFF;";

				String query5 = "SET IDENTITY_INSERT [investic].[dbo].[tblProblemaProyectoInvestigacion] ON;";
				query5 += "INSERT INTO [investic].[dbo].[tblProblemaProyectoInvestigacion]"
						+ " ("
						+ nameBThreeTeacher.toString()
								.replaceAll("\\[|\\]", "")
						+ ") VALUES ("
						+ bThreeTeacher.toString().replaceAll("\\[|\\]", "'")
								.replace(", ", "','").replace("null","") + ");\n";
				query5 += "SET IDENTITY_INSERT [investic].[dbo].[tblProblemaProyectoInvestigacion] OFF;";

				String query6 = "SET IDENTITY_INSERT [investic].[dbo].[tblPresupuestoProyectoInvestigacion] ON;";
				for (List<String> bt : bFour) {
					query6 = query6
							+ "INSERT INTO [investic].[dbo].[tblPresupuestoProyectoInvestigacion]"
							+ " ("
							+ nameBFour.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(", ", "','").replace("null","") + ");\n";
				}
				query6 += "SET IDENTITY_INSERT [investic].[dbo].[tblPresupuestoProyectoInvestigacion] OFF;";

				String query7 = "SET IDENTITY_INSERT [investic].[dbo].[tblReflexionOnda] ON;";
				for (List<String> bt : bSix) {
					query7 = query7
							+ "INSERT INTO [investic].[dbo].[tblReflexionOnda]"
							+ " ("
							+ nameBSix.toString().replaceAll("\\[|\\]", "")
							+ ") VALUES ("
							+ bt.toString().replaceAll("\\[|\\]", "'")
									.replace(", ", "','").replace("null","") + ");\n";
				}
				query7 += "SET IDENTITY_INSERT [investic].[dbo].[tblReflexionOnda] OFF;";

				/*
				 * System.out.println(query); System.out.println(query1);
				 * System.out.println(query2); System.out.println(query3);
				 * System.out.println(query4); System.out.println(query5);
				 * System.out.println(query6); System.out.println(query7);
				 */

				String queryFinal = query + query1 + query2 + query3 + query4
						+ query5 + query6 + query7;

				//System.out.println(queryFinal);
				connectOnline.executeUpdate(queryFinal);
				try {
					connectOnline.getConnection().setAutoCommit(false);
				} catch (SQLException e1) {
					System.err.println("Error: " + e1.getMessage());
					e1.printStackTrace();
				}

				connectOnline.executeUpdate(queryFinal);
				try {
					connectOnline.getConnection().commit();
					connectOnline.getConnection().setAutoCommit(true);
					JOptionPane.showMessageDialog(null,
							"Se ha sincronizado correctamente");
					dispose();
				} catch (SQLException e1) {
					try {
						connectOnline.getConnection().rollback();
						JOptionPane.showMessageDialog(null,
								"Ocurrio un error, revise su conexión",
								"Error de sincronización",
								JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e2) {
						System.err.println("Error: " + e2.getMessage());
						e2.printStackTrace();
					}
					e1.printStackTrace();
				}
				connectOffline.close();
				connectOnline.close();
			}
		});
		
		upload.setBounds(95, 165, 162, 40);

		Container container = getContentPane();
		container.setLayout(null);
		container.add(lblAdmin);
		container.add(lblPassword);
		container.add(textPassword);
		container.add(lblUser);
		container.add(textUser);
		container.add(download);
		container.add(upload);

	}
}
