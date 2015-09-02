package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImgBackgroud extends JPanel {
	public Image imageBackground;
	public URL background;
	
	public ImgBackgroud() {
		this.setBounds(0, 48, 800, 552);
		background = this.getClass().getResource("/imgs/background.png");
		imageBackground = new ImageIcon(background).getImage();
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(imageBackground, 0, 0, 800, 552, this);
	}

}
