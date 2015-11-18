package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import connection.ConnectionJdbcOffline;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BinnacleFour extends JPanel {
	private static final long serialVersionUID = 1L;
	private EditorProject editor;
	private JButton btnNext;
	private JButton btnBack;
	private JLabel lblTitle;
	private JButton btnSaveInformation;
	private JScrollPane scrollCenter;
	private Integer id;
	private JTable table;
	private JPanel panel;
	private JButton btnAddEntry;
	private JPanel panelTable;
	private JTableHeader header;
	
	
	public BinnacleFour(EditorProject editor) {
		this.editor = editor;
		id = this.editor.getId();
		
		lblTitle = new JLabel("Presupuesto Proyecto");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 20, 370, 30);		
		
		btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickNext();
			}
		});
		btnNext.setBounds(100, 280, 104, 36);
		btnNext.setBackground(new Color(0, 0, 0, 0));
		btnNext.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/next.png")));
		btnNext.setBorder(null);

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBack();
			}
		});
		btnBack.setBounds(10, 280, 86, 36);
		btnBack.setBackground(new Color(0, 0, 0, 0));
		btnBack.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/back.png")));
		btnBack.setBorder(null);
		
		btnAddEntry = new JButton("");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEntry();
			}
		});
		btnAddEntry.setBounds(100, 70, 186, 60);
		btnAddEntry.setBackground(new Color(0, 0, 0, 0));
		btnAddEntry.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/addEntry.png")));
		btnAddEntry.setBorder(null);
		
		btnSaveInformation = new JButton("");
		btnSaveInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
				boolean correctConnection = connect.connectToDB();
				if (!correctConnection) {
					return;
				}

				String query = "UPDATE tblPresupuestoProyectoInvestigacion set";
				System.out.println(query);
				connect.executeUpdate(query);
			}
		});
		btnSaveInformation.setBounds(220, 280, 197, 40);
		btnSaveInformation.setBackground(new Color(0,0,0,0));
		btnSaveInformation.setIcon(new ImageIcon(Header.class.getResource("/imgs/saveInformation.png")));
		btnSaveInformation.setBorder(null);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 420, 260);
		panel.setPreferredSize(new Dimension(710, 600));

		scrollCenter = new JScrollPane();
		scrollCenter.setBorder(null);
		scrollCenter.setBounds(0, 0, 420, 260);
		scrollCenter.setViewportView(panel);
		scrollCenter.getViewport().setView(panel);

		String[] columnNames = { "Rubro", "DescripcionGasto", "Cantidad",
				"Vl Unitario", "Total", "Eliminar" };

		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}		
		
		ResultSet rs = connect
				.resultSet("SELECT * FROM tblPresupuestoProyectoInvestigacion "
						+ "JOIN tblRubro ON (tblRubro.id = tblPresupuestoProyectoInvestigacion.idRubro)"
						+ " WHERE idGRupoInvestigacion=" + id);

		int row = 0;
		try {
			while (rs.next()) {
				row++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Object[][] data = new Object[row][6];

		rs = connect
				.resultSet("SELECT * FROM tblPresupuestoProyectoInvestigacion "
						+ "JOIN tblRubro ON (tblRubro.id = tblPresupuestoProyectoInvestigacion.idRubro)"
						+ " WHERE idGRupoInvestigacion=" + id);
		row = 0;
		try {
			while (rs.next()) {
				data[row][0] = rs.getObject("Rubro");
				data[row][1] = rs.getObject("DescripcionGasto");
				data[row][2] = rs.getObject("ValorRubro");
				data[row][3] = rs.getObject("ValorUnitario");
				data[row][4] = rs.getObject("Total");
				data[row][5] = "Eliminar";
				row++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table = new JTable(data, columnNames);
	    header = table.getTableHeader();

		panelTable = new JPanel();
		panelTable.setBounds(10, 150, 700, 200);

		setLayout(null);
		panel.setLayout(null);
		panelTable.setLayout(new BorderLayout());
		panelTable.add(header, BorderLayout.NORTH);
		panelTable.add(table, BorderLayout.CENTER);

		panel.add(panelTable);
		panel.setSize(editor.getIEP().getSize());
		this.add(scrollCenter);
		panel.add(lblTitle);
		panel.add(btnAddEntry);
		this.add(btnNext);
		this.add(btnBack);
		this.add(btnSaveInformation);
		this.updateUI();
	}
	
	public void addEntry(){
		BinnacleFour bf=this;
		AddEntry addEntry = new AddEntry(bf, editor);
		addEntry.setVisible(true);	
	}

	public void clickForResearchGroup() {
		BinnacleTwoGroup binnacleTwoGroup = new BinnacleTwoGroup(editor);
		this.editor.reloadPanel(binnacleTwoGroup);
	}

	public void clickNext() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickFive();
	}

	public void clickBack() {
		LeftPanel leftPanel = new LeftPanel(editor);
		leftPanel.clickThree();
	}
	
	public void reload(){
		this.removeAll();
		setLayout(null);
		panel.setLayout(null);
		panelTable.setLayout(new BorderLayout());
		panelTable.add(header, BorderLayout.NORTH);
		panelTable.add(table, BorderLayout.CENTER);
		panel.add(panelTable);
		panel.setSize(editor.getIEP().getSize());
		this.add(scrollCenter);
		panel.add(lblTitle);
		panel.add(btnAddEntry);
		this.add(btnNext);
		this.add(btnBack);
		this.add(btnSaveInformation);
		this.updateUI();
	}

}