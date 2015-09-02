package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class IEP extends JFrame {

	private JPanel contentPanel;
	ImgBackgroud imgBackground;
	Header header;
	Projects projects;

	public IEP() {
		super("IEP OFFLINE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		header = new Header();
		imgBackground = new ImgBackgroud();
		projects = new Projects();

		Container container = getContentPane();
		container.setLayout(null);
		container.add(projects);
		container.add(imgBackground);
		container.add(header);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IEP frame = new IEP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
