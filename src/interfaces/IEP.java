package interfaces;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class IEP extends JFrame {
	ImgBackgroud imgBackground;
	Header header;
	Projects projects;
	private JLabel lblLogo;

	public IEP() {
		super("IEP OFFLINE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		header = new Header();
		header.setLocation(0, 0);
		imgBackground = new ImgBackgroud();
		projects = new Projects(this);
		Container container = getContentPane();
	
		container.setLayout(null);
		
		lblLogo = new JLabel("logo");
		lblLogo.setBounds(276, 0, 248, 103);
		lblLogo.setIcon(new ImageIcon(IEP.class.getResource("/imgs/logoInvestic.png")));
		
		container.add(lblLogo);
		container.add(projects);
		container.add(imgBackground);		
		container.add(header);
	}
	
	public void reloadPanel(JPanel panel){
		getContentPane().removeAll();
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().add(lblLogo);
		getContentPane().add(imgBackground);
		getContentPane().add(header);
		getContentPane().repaint();
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