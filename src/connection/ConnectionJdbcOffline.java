package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJdbc {

	private Connection conn = null;

	public ConnectionJdbc() {

	}
	
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final boolean connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:resources/db/investic.db");
			if (conn != null) {
				System.out.println("Connected to the database");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
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
	
	public void executeUpdate(String query){
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.setQueryTimeout(30); 
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		
	}
	
	public  ResultSet resultSet(String query){
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.setQueryTimeout(30); 
			ResultSet rs = statement.executeQuery(query);
		    return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  		
	}

	public Connection getConnection() {
		return conn;
	}

	public void setConnection(Connection con) {
		this.conn= con;
	}	

	/*public static void main(String[] args) {
		ConnectionJdbc conectar = new ConnectionJdbc();
		boolean correctConnection = conectar.connectToDB();
		if (correctConnection){
			System.out.println("Esta conectado");
			ResultSet rs = conectar.resultSet("Select * from tblGrupoInvestigacion");	
			try {
				while(rs.next())
				  {
				    // read the result set
				    System.out.println("name = " + rs.getString("Codigo"));
				    System.out.println("id = " + rs.getInt("id"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Error de conexion");
		}		
		}*/
}
