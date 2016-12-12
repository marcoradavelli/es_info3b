package it.unibg.info3b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraPrincipale extends JFrame {

	private EstraiModel model;
	
	private JPanel contentPane;
	
	private JButton btnEstrai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EstraiModel model = new EstraiModel();
		FinestraPrincipale frame = new FinestraPrincipale(model);
		new EstraiController(model, frame);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public FinestraPrincipale(EstraiModel model) {
		this.model = model;
		 try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnEstrai = new JButton("Estrai!");

		contentPane.add(btnEstrai, BorderLayout.NORTH);
	}

	public JButton getEstraiButton() {
		return btnEstrai;
	}
	
	public void mostraNumEstratto() {
		JOptionPane.showMessageDialog(FinestraPrincipale.this, "Numero estratto: " + model.getValue());
	}
}
