import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Simple program to show a jumping rectangle, using event-based java programming pattern for Desktop UI
 * @author marcoradavelli
 *
 */
public class MyWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JPanel p;
	int x=10, yBase=200, y=yBase;
	
	public MyWindow() {
		setTitle("Omino");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.yellow);
				g.fillRect(x, y, 40, 40);
			}
		};
		p.setSize(300,400);
		getContentPane().add(p);
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					//x+=10;
					//p.repaint();
					salta();
				}
			}
		});
		new Thread() {
			@Override
			public void run() {
				while (true) {
					p.repaint();
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}.start();
		
	}
	
	public void salta() {
		new Thread() {
			int yo=0;
			boolean direction=false;
			public void run() {
				while (yo>=0) {
					if (!direction && yo<50) yo+=10;
					else if (!direction && yo>=50) direction=true;
					else yo-=10;
					if (yo>=0) y=yBase-yo;
					try {Thread.sleep(50);} catch (Exception e) {e.printStackTrace();}
					p.repaint();
				}
			};
		}.start();
	}
	
	public static void main(String[] args) {
		new MyWindow().setVisible(true);
		
	}
}
