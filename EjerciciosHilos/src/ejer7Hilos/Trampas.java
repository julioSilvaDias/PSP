package ejer7Hilos;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trampas {
	private JPanel panel = null;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	
	public Trampas(ArrayList<JPanel> paneles, JFrame frame) {
		panel = new JPanel();
		panel.setBounds(0,0,262,298);
		panel.setLayout(null);
		
		JLabel lblCaballo1 = new JLabel("Caballo 1");
		lblCaballo1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaballo1.setBounds(32, 44, 81, 17);
		panel.add(lblCaballo1);
		
		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaballo2.setBounds(32, 72, 81, 17);
		panel.add(lblCaballo2);
		
		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaballo3.setBounds(32, 100, 81, 17);
		panel.add(lblCaballo3);
		
		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaballo4.setBounds(32, 128, 81, 17);
		panel.add(lblCaballo4);
		
		txt1 = new JTextField();
		txt1.setText("6");
		txt1.setBounds(106, 44, 86, 20);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setText("6");
		txt2.setColumns(10);
		txt2.setBounds(106, 72, 86, 20);
		panel.add(txt2);
		
		txt3 = new JTextField();
		txt3.setText("6");
		txt3.setColumns(10);
		txt3.setBounds(106, 100, 86, 20);
		panel.add(txt3);
		
		txt4 = new JTextField();
		txt4.setText("6");
		txt4.setColumns(10);
		txt4.setBounds(106, 128, 86, 20);
		panel.add(txt4);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(150, 249, 89, 23);
		panel.add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =0;
				
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				
				i = Integer.parseInt(txt1.getText());
				Sesion.getInstance().setpCaballo1(i);
				
				i = Integer.parseInt(txt2.getText());
				Sesion.getInstance().setpCaballo2(i);
				
				i = Integer.parseInt(txt3.getText());
				Sesion.getInstance().setpCaballo3(i);
				
				i = Integer.parseInt(txt4.getText());
				Sesion.getInstance().setpCaballo4(i);
				
			}
		});
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
