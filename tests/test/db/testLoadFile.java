package test.db;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import connection.*;

public class testLoadFile {
	ConnectionJdbcOnline connectOnline;
	ConnectionJdbcOffline connectOffline;
	boolean correctConnectionOnline;
	boolean correctConnectionOffline;

	public testLoadFile() {
		connectOnline = new ConnectionJdbcOnline();
		connectOffline = new ConnectionJdbcOffline();
		correctConnectionOnline = connectOnline.connectToDB();
		correctConnectionOffline = connectOffline.connectToDB();
		if (correctConnectionOnline && correctConnectionOffline) {
			System.out.println("Esta conectado");

		} else {
			System.out.println("Error de conexion");
		}

	}

	@Test
	public void test1() {
		String cad1="";
		String cad2="";
		int id=16306;
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblGrupoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblGrupoInvestigacion WHERE id="+id);
		try {
			System.out.println("rs1="+rs.toString());
			
			while(rs.next() && rs1.next())
			  {			  
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					cad1=cad1+rs.getString(i);	
					cad2=cad2+rs1.getString(i);						
				}			    
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals(cad1, cad2);		
	}
	
	@Test
	public void test2() {
		String cad1="";
		String cad2="";
		int id=16306;
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblMiembroGrupo WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblMiembroGrupo WHERE id="+id);
		try {
			System.out.println("rs1="+rs.toString());
			
			while(rs.next() && rs1.next())
			  {			  
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					cad1=cad1+rs.getString(i);	
					cad2=cad2+rs1.getString(i);						
				}			    
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals(cad1, cad2);		
	}
}
