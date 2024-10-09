package ejer7Hilos;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Carrera {
	private JPanel panel = null;

	public Carrera(ArrayList<JPanel> paneles, JFrame frame) {
		panel = new JPanel();
		panel.setBounds(0,0,802,517);
		panel.setLayout(null);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
