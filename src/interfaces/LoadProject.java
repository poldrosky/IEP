package interfaces;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.classes.LoadFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadProject extends JFrame {

	private JTextArea textRoute;
	private JFileChooser fc;
	private File file;
	public Projects p;
	
	
	public LoadProject(Projects p) {
		this.p=p;
		setAlwaysOnTop(true);
		this.setTitle("Cargar Proyecto");
		this.setResizable(false);
		this.setBounds(0, 0, 463, 321);
		
		Container container = getContentPane();
		container.setLayout(null);
		
		textRoute = new JTextArea(5,20);
		textRoute.setEditable(false);
		textRoute.setBounds(55, 55, 200, 22);
		container.add(textRoute);
		textRoute.setColumns(10);
		
		final JButton btnChooseFile = new JButton("");
		fc = new JFileChooser();
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnChooseFile) {
		            int returnVal = fc.showOpenDialog(LoadProject.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
		                file = fc.getSelectedFile();
		                //This is where a real application would open the file.
		                textRoute.append(file.getName());
		                      } 
		            textRoute.setCaretPosition(textRoute.getDocument().getLength());
		        }
			}
		});
		btnChooseFile.setBounds(270, 55, 114, 22);
		btnChooseFile.setBackground(new Color(0, 0, 0, 0));
		btnChooseFile.setIcon(new ImageIcon(IEP.class
				.getResource("/imgs/chooseFile.png")));
		container.add(btnChooseFile);

		JButton btnLoadProject = new JButton("");
		btnLoadProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(file.getAbsolutePath());				
				LoadFile loadFile = new LoadFile();
				loadFile.load(file);
				
				dispose();
				reloadTable();
				
				
			}
		});
		btnLoadProject.setBounds(240, 150, 183, 50);
		btnLoadProject.setBackground(new Color(0, 0, 0, 0));
		btnLoadProject.setIcon(new ImageIcon(IEP.class
				.getResource("/imgs/loadProject.png")));
		container.add(btnLoadProject);

		JButton btnClearText = new JButton("");
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRoute.setText("");
			}
		});
		btnClearText.setBounds(55, 100, 98, 48);
		btnClearText.setBackground(new Color(0, 0, 0, 0));
		btnClearText.setIcon(new ImageIcon(IEP.class
				.getResource("/imgs/clear.png")));
		container.add(btnClearText);
		
		JLabel lblSquare = new JLabel("");
		lblSquare.setBounds(0, 0, 456, 272);
		lblSquare.setIcon(new ImageIcon(IEP.class
				.getResource("/imgs/IEP22.png")));
		container.add(lblSquare);
	}
	public void reloadTable () {
		p.loadIep();
	}

}
