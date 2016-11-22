import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OminoView extends JFrame {
	
	OminoModel model;
	
	JPanel panel;
	BufferedImage omino;
	
	public OminoView(OminoModel model) {
		try {
			omino = ImageIO.read(new File("omino_bianco.jpg"));
		} catch (IOException e) {e.printStackTrace();}

		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(omino, 0, 0, this);
			}
		};
		panel.setSize(300, 200);
		getContentPane().add(panel);
		setSize(300,200);
	}
	
}