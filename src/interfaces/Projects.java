package interfaces;



import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionJdbc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Projects extends JPanel {
	private JLabel lblIEP11;
    private JLabel lblTablaDeProyectos;
    private JButton btnLoadProject;
    private JButton btnGoProject;
    private DefaultTableModel model;
    private JTable table;
    private ButtonColumn buttonColumn;
    public IEP iep; 
    
	public Projects(IEP iep) {
		Projects p=this;
		this.iep=iep;
		this.setBounds(50, 100, 700, 406);
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 700, 406);
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
		
		btnGoProject = new JButton("Boton");
		btnGoProject.setIcon(new ImageIcon(IEP.class.getResource("/imgs/GoProject.png")));
		reloadTable();

				
	}
	
	public void reloadTable(){
		ConnectionJdbc connect = new ConnectionJdbc();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}
		/*Object[][] data = {
			    {"2020", "Nariño",
			     "I.E. San Juan Bosco", "Ir al Proyecto"},
			    {"1964", "Buesaco",
			     "Colegio Rafael Uribe", "Ir al Proyecto"}			    
			};*/
		
		
		String[] columnNames = {"id", "Código",
                "Nombre", "Ir"};
		
		ResultSet rs = connect.resultSet("SELECT * FROM tblGrupoInvestigacion");
		model = new DefaultTableModel();
		model.setColumnCount(4);
		model.setColumnIdentifiers(columnNames);
		
		int row=0;
		try {
			while(rs.next()){
			    // read the result set
				Object[] grupo=new Object[4];
				model.addRow(grupo);
				model.setValueAt(rs.getObject("id"), row, 0);
				model.setValueAt(rs.getObject("Codigo"), row, 1);
				model.setValueAt(rs.getObject("Nombre"), row, 2);
				model.setValueAt("Ir al Proyecto", row, 3);
			    row++;
			    
			  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		//model = new DefaultTableModel(data, columnNames);
		
		table = new JTable(model);
		table.setBounds(50, 150, 600, 200);
		
		buttonColumn = new ButtonColumn(table, 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	
		setLayout(null);
		this.add(lblTablaDeProyectos);
		this.add(table);
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
