package interfaces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class Header extends JPanel {
	
	private JButton btnIEP03, btnFace, btnTwitter, btnYoutube;
	private JLabel lblIEP04;
	
	public Header() {
		Color colorBackgroundHeader = new Color(248,206,117);
		this.setBounds(0, 0, 800, 48);
		this.setBackground(colorBackgroundHeader);
		
		btnFace = new JButton("");
		btnFace.setBounds(658, 0, 48, 48);
		btnFace.setBackground(colorBackgroundHeader);
		btnFace.setIcon(new ImageIcon(IEP.class.getResource("/imgs/facebook.png")));
		
		btnTwitter = new JButton("");
		btnTwitter.setBounds(706, 0, 46, 48);
		btnTwitter.setBackground(colorBackgroundHeader);
		btnTwitter.setIcon(new ImageIcon(IEP.class.getResource("/imgs/twitter.png")));
		
		btnYoutube = new JButton("");
		btnYoutube.setBounds(752, 0, 48, 48);
		btnYoutube.setBackground(colorBackgroundHeader);
		btnYoutube.setIcon(new ImageIcon(IEP.class.getResource("/imgs/youtube.png")));		
		
		btnIEP03 = new JButton("");
		btnIEP03.setBounds(0, 0, 105, 48);
		btnIEP03.setBackground(colorBackgroundHeader);
		btnIEP03.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP03.png")));		
		
		lblIEP04 = new JLabel("");
		lblIEP04.setBackground(colorBackgroundHeader);
		lblIEP04.setBounds(105, 0, 136, 48);
		lblIEP04.setIcon(new ImageIcon(IEP.class.getResource("/imgs/IEP04.png")));		
		setLayout(null);
		this.add(btnIEP03);
		this.add(lblIEP04);
		this.add(btnFace);
		this.add(btnTwitter);
		this.add(btnYoutube);	
	}

}
