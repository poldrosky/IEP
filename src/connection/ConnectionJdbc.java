package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJdbc {

	private Connection conn = null;

	public ConnectionJdbc() {

	}

	public final boolean connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:resources/db/investic.db");
			Statement statement = conn.createStatement();
		    statement.setQueryTimeout(30); 
		  	if (conn != null) {
				System.out.println("Connected to the database");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Connect to: "+dm.getUserName());
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: "	+ dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				//connection.close();
				return true;
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public Connection getConnection() {
		return conn;
	}

	public void setConnection(Connection con) {
		this.conn= con;
	}	

	public static void main(String[] args) {
		ConnectionJdbc conectar = new ConnectionJdbc();
		boolean correctConnection = conectar.connectToDB();
		if (correctConnection){
			System.out.println("Esta conectado");}
		else{
			System.out.println("Error de conexion");
		}
		}
}
