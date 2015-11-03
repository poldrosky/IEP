package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import connection.ConnectionJdbcOffline;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Projects extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblIEP11;
    private JLabel lblTablaDeProyectos;
    private JButton btnLoadProject;
    private JButton btnGoProject;
    private JTable table;
    private ButtonColumn buttonColumn;
    public IEP iep; 
    
	public Projects(IEP iep) {
		this.iep=iep;
		this.setBounds(50, 100, 720, 458);
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 720, 458);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP11.png")));
		
		lblTablaDeProyectos = new JLabel("Tabla De Proyectos");
		lblTablaDeProyectos.setBounds(50, 50, 200, 50);
		
		btnLoadProject = new JButton("");
		btnLoadProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProject();
			}
		});
		btnLoadProject.setBounds(463, 50, 183, 50);
		btnLoadProject.setBackground(new Color(0,0,0,0));
		btnLoadProject.setIcon(new ImageIcon(IEP.class.getResource("/imgs/loadProject.png")));
		btnLoadProject.setBorder(null);
		
		btnGoProject = new JButton("Boton");
		btnGoProject.setIcon(new ImageIcon(IEP.class.getResource("/imgs/GoProject.png")));
		btnGoProject.setBorder(null);
		reloadTable();
				
	}
	
	public void reloadTable(){
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		
		Object [] columnNames = {"id", "Codigo", "Nombre", "Ir"};
				
		ResultSet rs = connect.resultSet("SELECT * FROM tblGrupoInvestigacion");	
		
		
		int row=0;
		try {			
			while(rs.next()){				
			    row++;
		  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object [] []data= new Object [row][4];	
		
		rs = connect.resultSet("SELECT * FROM tblGrupoInvestigacion");
		row=0;
		try {			
			while(rs.next()){
				data[row][0]=rs.getObject("id");
				data[row][1]=rs.getObject("Codigo");
				data[row][2]=rs.getObject("Nombre");
				data[row][3]="Ir al Proyecto";
			    row++;
		  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table = new JTable(data,columnNames);
		JTableHeader header = table.getTableHeader();
				
		JPanel panel = new JPanel();
		panel.setBounds(50, 150, 600, 200);
		
		buttonColumn = new ButtonColumn(table, 3,iep);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	
		setLayout(null);
		this.add(lblTablaDeProyectos);
		panel.setLayout(new BorderLayout());
		panel.add(header, BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		this.add(panel);
		this.add(btnLoadProject);
		this.add(lblIEP11);
		this.updateUI();
		
		connect.close();
	}
	
	public void loadProject(){
		Projects p=this;
		LoadProject loadProject = new LoadProject(p);
		loadProject.setVisible(true);	
	}
	
	public void loadIep(){
		iep.dispose();
		IEP frame = new IEP();
		frame.setVisible(true);
	}	
}
