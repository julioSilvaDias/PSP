package Ejer5Hilos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int prioridad1=5;
	private int prioridad2=5;
	private int prioridad3=5;
	HiloContador hilo1 = null;
	HiloContador hilo2 = null;
	HiloContador hilo3 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnPararHilo1 = new JButton("Fin Hilo 1");
		btnPararHilo1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPararHilo1.setBounds(202, 32, 107, 31);
		contentPane.setLayout(null);
		contentPane.add(btnPararHilo1);
		
		JButton btnMinPrioridad1 = new JButton("--");
		btnMinPrioridad1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinPrioridad1.setBounds(128, 32, 64, 31);
		contentPane.add(btnMinPrioridad1);
		
		JButton btnMaxPrioridad = new JButton("++");
		btnMaxPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMaxPrioridad.setBounds(318, 34, 56, 31);
		contentPane.add(btnMaxPrioridad);
		
		JButton btnMaxPrioridad2 = new JButton("++");
		btnMaxPrioridad2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMaxPrioridad2.setBounds(318, 95, 56, 31);
		contentPane.add(btnMaxPrioridad2);
		
		JButton btnFinHilo2 = new JButton("Fin Hilo 2");
		btnFinHilo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFinHilo2.setBounds(202, 93, 107, 31);
		contentPane.add(btnFinHilo2);
		
		JButton btnMinPrioridad2 = new JButton("--");
		btnMinPrioridad2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinPrioridad2.setBounds(128, 93, 64, 31);
		contentPane.add(btnMinPrioridad2);
		
		JButton btnMaxPrioridad3 = new JButton("++");
		btnMaxPrioridad3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMaxPrioridad3.setBounds(318, 154, 56, 31);
		contentPane.add(btnMaxPrioridad3);
		
		JButton btnPararHilo3 = new JButton("Fin Hilo 3");
		btnPararHilo3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPararHilo3.setBounds(202, 152, 107, 31);
		contentPane.add(btnPararHilo3);
		
		JButton btnMinPrioridad3 = new JButton("--");
		btnMinPrioridad3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinPrioridad3.setBounds(128, 152, 64, 31);
		contentPane.add(btnMinPrioridad3);
		
		JButton btnFinalizarTodos = new JButton("Finalizar Todos");
		btnFinalizarTodos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFinalizarTodos.setBounds(202, 219, 107, 31);
		contentPane.add(btnFinalizarTodos);
		
		JLabel lblHilo1 = new JLabel("Hilo1: ");
		lblHilo1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHilo1.setBounds(116, 294, 89, 60);
		contentPane.add(lblHilo1);
		
		JLabel lblPri1 = new JLabel("Pri: ");
		lblPri1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPri1.setBounds(305, 294, 89, 60);
		contentPane.add(lblPri1);
		
		JLabel lblPri2 = new JLabel("Pri: ");
		lblPri2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPri2.setBounds(305, 386, 89, 60);
		contentPane.add(lblPri2);
		
		JLabel lblHilo2 = new JLabel("Hilo2: ");
		lblHilo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHilo2.setBounds(116, 386, 89, 60);
		contentPane.add(lblHilo2);
		
		JLabel lblHilo3 = new JLabel("Hilo3: ");
		lblHilo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHilo3.setBounds(116, 486, 89, 60);
		contentPane.add(lblHilo3);
		
		JLabel lblPri3 = new JLabel("Pri: ");
		lblPri3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPri3.setBounds(305, 486, 89, 60);
		contentPane.add(lblPri3);
		
		hilo1 = new HiloContador(lblHilo1, 60, "Hilo1");
		hilo2 = new HiloContador(lblHilo2, 60, "Hilo2");
		hilo3 = new HiloContador(lblHilo3, 60, "Hilo3");
		
		hilo1.setPriority(prioridad1);
		hilo2.setPriority(prioridad2);
		hilo3.setPriority(prioridad3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		lblPri1.setText("Pri: " + prioridad1);
		lblPri2.setText("Pri: " + prioridad2);
		lblPri3.setText("Pri: " + prioridad3);
		
		btnMinPrioridad1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad1 = 1;
				hilo1.setPriority(prioridad1);
				lblPri1.setText("Pri: " + prioridad1);
				
			}
		});
		
		btnPararHilo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.stop();
			}
		});
		
		btnMaxPrioridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad1 = 10;
				hilo1.setPriority(prioridad1);
				lblPri1.setText("Pri: " + prioridad1);
			}
		});
		
		btnMinPrioridad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad2 = 1;
				hilo2.setPriority(prioridad2);
				lblPri2.setText("Pri: " + prioridad2);
			}
		});
		
		btnFinHilo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.stop();
			}
		});
		
		btnMaxPrioridad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad2 = 10;
				hilo2.setPriority(prioridad2);
				lblPri2.setText("Pri: " + prioridad2);
			}
		});
		
		btnMinPrioridad3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad3 = 1;
				hilo3.setPriority(prioridad3);
				lblPri3.setText("Pri: " + prioridad3);
			}
		});
		
		btnPararHilo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.stop();
			}
		});
		
		btnMaxPrioridad3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prioridad3 = 10;
				hilo3.setPriority(prioridad3);
				lblPri3.setText("Pri: " + prioridad3);
			}
		});
		
		btnFinalizarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.stop();
				hilo2.stop();
				hilo3.stop();
			}
		});
		
	}
}
