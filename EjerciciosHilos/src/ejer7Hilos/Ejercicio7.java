package ejer7Hilos;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio7 {
	public JFrame frame;
	public ArrayList<JPanel> paneles = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ejercicio7().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio7() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 794, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();

		paneles = new ArrayList<JPanel>();
		
		Carrera panelCarrera = new Carrera(paneles, frame);
		JPanel panel1 = panelCarrera.getPanel();
		panel1.setVisible(true);
		
		paneles.add(panel1);
		frame.getContentPane().add(panel1);
		
		Trampas panelTrampas = new Trampas(paneles, frame);
		JPanel panel2 = panelTrampas.getPanel();
		panel2.setVisible(false);
		
		paneles.add(panel2);
		frame.getContentPane().add(panel2);
	}
}
