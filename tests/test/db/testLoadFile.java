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
	int id=16306;

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
	
	@Test
	public void test3() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblReflexionProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblReflexionProyectoInvestigacion WHERE id="+id);
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
	public void test4() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblPreguntaInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblPreguntaInvestigacion WHERE id="+id);
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
	public void test5() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblPreguntaProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblPreguntaProyectoInvestigacion WHERE id="+id);
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
	public void test6() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblProblemaInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblProblemaInvestigacion WHERE id="+id);
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
	public void test7() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblProblemaProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblProblemaProyectoInvestigacion WHERE id="+id);
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
	public void test8() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblPresupuestoProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblPresupuestoProyectoInvestigacion WHERE id="+id);
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
	public void test9() {
		String cad1="";
		String cad2="";
		int id=16306;
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblEstadoArteProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblEstadoArteProyectoInvestigacion WHERE id="+id);
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
	public void test10() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblConceptosEstadoArte WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblConceptosEstadoArte WHERE id="+id);
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
	public void test11() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblRecoleccionInformacionProyectoInvestigacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblRecoleccionInformacionProyectoInvestigacion WHERE id="+id);
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
	public void test12() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblHerramientasRecoleccionInformacion WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblHerramientasRecoleccionInformacion WHERE id="+id);
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
	public void test13() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblReflexionOnda WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblReflexionOnda WHERE id="+id);
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
	public void test14() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblTipoFeria WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblTipoFeria WHERE id="+id);
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
	public void test15() {
		String cad1="";
		String cad2="";
		ResultSet rs = connectOnline.resultSet("Select * from dbo.tblPropagacionGrupo WHERE id="+id);	
		ResultSet rs1 = connectOffline.resultSet("Select * from tblPropagacionGrupo WHERE id="+id);
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
