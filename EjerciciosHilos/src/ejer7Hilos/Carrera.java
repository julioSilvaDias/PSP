package ejer7Hilos;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carrera {
	private JPanel panel = null;

	public Carrera(ArrayList<JPanel> paneles, JFrame frame) {
		panel = new JPanel();
		panel.setBounds(0, 0, 682, 474);
		panel.setLayout(null);

		JProgressBar progresoCaballo1 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		progresoCaballo1.setForeground(new Color(255, 128, 128));
		progresoCaballo1.setBounds(145, 54, 375, 57);
		panel.add(progresoCaballo1);

		JProgressBar progresoCaballo2 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		progresoCaballo2.setForeground(new Color(128, 128, 192));
		progresoCaballo2.setBounds(145, 138, 375, 57);
		panel.add(progresoCaballo2);

		JProgressBar progresoCaballo3 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		progresoCaballo3.setForeground(new Color(255, 0, 255));
		progresoCaballo3.setBounds(145, 223, 375, 57);
		panel.add(progresoCaballo3);

		JProgressBar progresoCaballo4 = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		progresoCaballo4.setForeground(new Color(128, 255, 0));
		progresoCaballo4.setBounds(145, 311, 375, 57);
		panel.add(progresoCaballo4);

		JButton btnInicioCarrera = new JButton("Empieza la Carrera");
		btnInicioCarrera.setBounds(206, 406, 246, 23);
		panel.add(btnInicioCarrera);

		JLabel lblCaballo1 = new JLabel("Caballo1");
		lblCaballo1.setForeground(new Color(255, 128, 128));
		lblCaballo1.setBackground(new Color(255, 128, 128));
		lblCaballo1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaballo1.setBounds(23, 68, 92, 27);
		panel.add(lblCaballo1);

		JLabel lblCaballo2 = new JLabel("Caballo2");
		lblCaballo2.setForeground(new Color(128, 128, 192));
		lblCaballo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaballo2.setBounds(23, 152, 92, 27);
		panel.add(lblCaballo2);

		JLabel lblCaballo3 = new JLabel("Caballo3");
		lblCaballo3.setForeground(new Color(255, 0, 255));
		lblCaballo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaballo3.setBounds(23, 236, 92, 27);
		panel.add(lblCaballo3);

		JLabel lblCaballo4 = new JLabel("Caballo4");
		lblCaballo4.setForeground(new Color(0, 255, 0));
		lblCaballo4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaballo4.setBounds(23, 329, 92, 27);
		panel.add(lblCaballo4);

		JLabel lblGanador = new JLabel("");
		lblGanador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGanador.setBounds(262, 11, 142, 24);
		panel.add(lblGanador);

		JButton btnTrampas = new JButton("Trampas");
		btnTrampas.setBounds(543, 419, 98, 23);
		panel.add(btnTrampas);

		btnInicioCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int prioridad1 = 0;
				int prioridad2 = 0;
				int prioridad3 = 0;
				int prioridad4 = 0;

				HiloCaballo caballo1 = new HiloCaballo(progresoCaballo1, "caballo: 1", lblGanador);
				HiloCaballo caballo2 = new HiloCaballo(progresoCaballo2, "caballo: 2", lblGanador);
				HiloCaballo caballo3 = new HiloCaballo(progresoCaballo3, "caballo: 3", lblGanador);
				HiloCaballo caballo4 = new HiloCaballo(progresoCaballo4, "caballo: 4", lblGanador);

				if (0 == Sesion.getInstance().getpCaballo1()) {
					prioridad1 = 6;
					prioridad2 = 6;
					prioridad3 = 6;
					prioridad4 = 6;
					
				} else {
					prioridad1 = Sesion.getInstance().getpCaballo1();
					prioridad2 = Sesion.getInstance().getpCaballo2();
					prioridad3 = Sesion.getInstance().getpCaballo3();
					prioridad4 = Sesion.getInstance().getpCaballo4();
					
				}
				
				caballo1.setPriority(prioridad1);
				caballo2.setPriority(prioridad2);
				caballo3.setPriority(prioridad3);
				caballo4.setPriority(prioridad4);
				
				caballo1.start();
				caballo2.start();
				caballo3.start();
				caballo4.start();
				
			}
		});

		btnTrampas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}
