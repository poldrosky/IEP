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
import java.sql.SQLException;

public class Administration extends JFrame {
	private static final long serialVersionUID = 1L;
	int id;
	private JLabel lblAdmin;
	private JLabel lblPassword;
	private JPasswordField textPassword;
	private String password;

	
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
					JOptionPane.showMessageDialog(null, "No hay conexión a Internet", "Error de conexión",  JOptionPane.ERROR_MESSAGE);
					return;
				}
				String query = "SELECT "
						+ "[investic].[dbo].tblGrupoInvestigacion.[Id] AS IdGrupo,"
						+ "[investic].[dbo].AspNetUsers.[PasswordHash] AS PassWordUser "
						+ "FROM "
						+ "[investic].[dbo].tblGrupoInvestigacion,"
						+ "[investic].[dbo].AspNetUsers "
						+ "WHERE "
						+ "[investic].[dbo].tblGrupoInvestigacion.[id] =16306"
						+ "AND "
						+ "[investic].[dbo].AspNetUsers.[id] = [investic].[dbo].tblGrupoInvestigacion.[idUsuario]";
				
			    ResultSet rsPassword = connectOnline.resultSet(query);
			
				try {
					while (rsPassword.next()) {
						password = rsPassword.getString("PasswordUser");
						System.out.println(password);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
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
