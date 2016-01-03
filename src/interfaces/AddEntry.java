package interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.classes.ComboItem;

import connection.ConnectionJdbcOffline;

public class AddEntry extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblEntry;
	private JComboBox<ComboItem> comboEntry;
	private JLabel lblQuantity;
	private JTextField textQuantity;
	private JLabel lblUnitValue;
	private JTextField textUnitValue;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JLabel lblDescription;
	private JTextField textDescription;
	private JButton btnAddItem;
	public BinnacleFour bf;
	int sizeEntry=0;
	int entry, id;

	public AddEntry(BinnacleFour bf, final EditorProject editor) {
		this.bf=bf;
		id = editor.getId();
		
		setAlwaysOnTop(true);
		this.setTitle("Agregar Presupuesto");
		this.setResizable(false);
		this.setBounds(0, 0, 500, 321);
		
		Container container = getContentPane();
		container.setLayout(null);
		
		lblEntry = new JLabel("Rubro:");
		lblEntry.setBounds(20, 60, 50, 20);
		
		comboEntry = new JComboBox<ComboItem>();
		
		ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
		boolean correctConnection = connect.connectToDB();
		if (!correctConnection) {
			return;
		}

		
		ResultSet rsEntry = connect.resultSet("SELECT * FROM tblRubro");
		 		
		try {
			while (rsEntry.next()) {
				comboEntry.addItem(new ComboItem(rsEntry.getInt("id"), rsEntry.getString("Rubro")));
				sizeEntry++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connect.close();

		comboEntry.setBounds(75, 60, 400, 20);
		
		lblQuantity = new JLabel("Cantidad");
		lblQuantity.setBounds(20, 90, 100, 20);
		
		lblUnitValue = new JLabel("Valor Unitario");
		lblUnitValue.setBounds(150, 90, 100, 20);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(300, 90, 100, 20);
		
		textQuantity= new JTextField();
		textQuantity.setBounds(20, 120, 100, 20);
		
		textUnitValue = new JTextField();
		textUnitValue.setBounds(150, 120, 100, 20);
		
		textTotal = new JTextField();
		textTotal.setBounds(290, 120, 100, 20);
		textTotal.setEnabled(false);
		
		lblDescription = new JLabel("Descripcion:");
		lblDescription.setBounds(20, 160, 90, 20);
		
		textDescription = new JTextField();
		textDescription.setBounds(115, 160, 280, 20);
		
		btnAddItem = new JButton("");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				float quantity;
				float unitValue;
				float total;
				String description;
				
				ConnectionJdbcOffline connect = new ConnectionJdbcOffline();
				boolean correctConnection = connect.connectToDB();
				if (!correctConnection) {
					return;
				}
				
				for(int i=0;i<=sizeEntry-1;i++){
					System.out.println(comboEntry.getItemAt(i).getLabel());
					System.out.println(comboEntry.getSelectedItem().toString());
					if(comboEntry.getItemAt(i).getLabel().equals(comboEntry.getSelectedItem().toString())){
						entry = comboEntry.getItemAt(i).getValue();
					}					
				}
				
				if(!isNumeric(textQuantity.getText())){
					JOptionPane.showMessageDialog(null,
							"La cantidad debe ser un valor numérico",
							"Error de valor",
							JOptionPane.ERROR_MESSAGE);	
					return;
				}
				
				if(!isNumeric(textUnitValue.getText())){
					JOptionPane.showMessageDialog(null,
							"El valor unitario debe ser un valor numérico",
							"Error de valor",
							JOptionPane.ERROR_MESSAGE);	
					return;
				}
				
				if(Float.parseFloat(textQuantity.getText())<0){
					JOptionPane.showMessageDialog(null,
							"La cantidad debe ser un valor mayor a cero",
							"Error de valor",
							JOptionPane.ERROR_MESSAGE);	
					return;
				}
				
				if(Float.parseFloat(textUnitValue.getText())<0){
					JOptionPane.showMessageDialog(null,
							"El valor unitario debe ser un valor mayor a cero",
							"Error de valor",
							JOptionPane.ERROR_MESSAGE);	
					return;
				}
				
				if(textDescription.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Debe digitar una descripción",
							"Error de valor",
							JOptionPane.ERROR_MESSAGE);	
					return;
				}
				
				quantity = Float.parseFloat(textQuantity.getText());
				unitValue = Float.parseFloat(textUnitValue.getText());
				total = quantity * unitValue;
				description = textDescription.getText();
				
				textTotal.setText(String.valueOf(total));
				
				//System.out.println(comboEntry.getSelectedItem().toString());
				//System.out.println(entry);
				//System.out.println(quantity);
				//System.out.println(unitValue);
				//System.out.println(total);
				//System.out.println(description);
				
				String query = "INSERT INTO tblPresupuestoProyectoInvestigacion "
						+ "(idGRupoInvestigacion, idRubro, DescripcionGasto, "
						+ "ValorRubro, ValorUnitario, Total)"
						+ " VALUES ("+id+","+entry+",'"+description+"',"+quantity+","+unitValue+","+total+")";
				
				connect.executeUpdate(query);
				dispose();
				BinnacleFour binnacleFour=new BinnacleFour(editor);
				editor.reloadPanel(binnacleFour);
			}
		});
		btnAddItem.setBounds(150, 195, 127, 50);
		btnAddItem.setBackground(new Color(0, 0, 0, 0));
		btnAddItem.setIcon(new ImageIcon(Header.class
				.getResource("/imgs/addItemEntry.png")));
		btnAddItem.setBorder(null);
		
	
		container.add(lblEntry);
		container.add(comboEntry);
		container.add(lblQuantity);
		container.add(lblUnitValue);
		container.add(lblTotal);
		container.add(textQuantity);
		container.add(textUnitValue);
		container.add(textTotal);
		container.add(lblDescription);
		container.add(textDescription);
		container.add(btnAddItem);
	}
	
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
