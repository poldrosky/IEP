package interfaces;



import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Projects extends JPanel {
	private JLabel lblIEP11;
    private JLabel lblTablaDeProyectos;
    private JButton btnLoadProject;
    private JButton btnGoProject;
    private DefaultTableModel model;
    private JTable table;
    private ButtonColumn buttonColumn;
    
	public Projects() {
		this.setBounds(50, 100, 700, 406);
		lblIEP11 = new JLabel("");
		lblIEP11.setBackground(new Color(0,0,0,0));
		lblIEP11.setBounds(0, 0, 700, 406);
		lblIEP11.setIcon(new ImageIcon(IEP.class.getResource("/resources/imgs/IEP11.png")));
		
		lblTablaDeProyectos = new JLabel("Tabla De Proyectos");
		lblTablaDeProyectos.setBounds(50, 50, 200, 50);
		
		btnLoadProject = new JButton("");
		btnLoadProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadProject loadProject = new LoadProject();
				loadProject.setVisible(true);
			}
		});
		btnLoadProject.setBounds(467, 50, 183, 50);
		btnLoadProject.setBackground(new Color(0,0,0,0));
		btnLoadProject.setIcon(new ImageIcon(IEP.class.getResource("/resources/imgs/loadProject.png")));
		
		btnGoProject = new JButton("Boton");
		btnGoProject.setIcon(new ImageIcon(IEP.class.getResource("/resources/imgs/GoProject.png")));
		
		Object[][] data = {
			    {"2020", "Nariño",
			     "I.E. San Juan Bosco", "Ir al Proyecto"},
			    {"1964", "Buesaco",
			     "Colegio Rafael Uribe", "Ir al Proyecto"}			    
			};
		
		String[] columnNames = {"Código", "Nombre",
                "Institucion Educativa", "Ir"};
		
		model = new DefaultTableModel(data, columnNames);
		table = new JTable( model );
		table.setBounds(50, 150, 600, 200);
		
		buttonColumn = new ButtonColumn(table, 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
				
		setLayout(null);

		this.add(table);
		this.add(lblTablaDeProyectos);
		this.add(btnLoadProject);
		this.add(lblIEP11);
		
	}
}
