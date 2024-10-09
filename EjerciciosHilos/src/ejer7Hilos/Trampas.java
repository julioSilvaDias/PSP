package ejer7Hilos;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Trampas {
	private JPanel panel = null;
	
	public Trampas(ArrayList<JPanel> paneles, JFrame frame) {
		panel = new JPanel();
		panel.setBounds(0,0,802,517);
		panel.setLayout(null);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
