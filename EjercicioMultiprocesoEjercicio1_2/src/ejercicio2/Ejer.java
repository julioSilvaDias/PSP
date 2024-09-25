package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Ejer extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextPane textPane;
	private JTextPane textPane_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer frame = new Ejer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-10, 0, 738, 602);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(34, 228, 73, 23);
		panel.add(lblPID);

		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(34, 262, 73, 23);
		panel.add(lblPidPadre);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(34, 306, 73, 23);
		panel.add(lblResultado);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(153, 232, 64, 19);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(340, 232, 70, 19);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(539, 228, 189, 18);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(153, 266, 64, 19);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(340, 266, 70, 14);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(539, 262, 189, 18);
		panel.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(108, 108, 131, 36);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 108, 131, 36);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(517, 108, 131, 36);
		panel.add(textField_2);

		textPane = new JTextPane();
		textPane.setBounds(258, 306, 205, 274);
		panel.add(textPane);

		textPane_1 = new JTextPane();
		textPane_1.setBounds(483, 306, 205, 274);
		panel.add(textPane_1);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				start1();
			}
		});
		btnNewButton.setBounds(128, 176, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				start2();
			}

		});
		btnNewButton_1.setBounds(321, 176, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Start");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				start3();
			}
		});
		btnNewButton_2.setBounds(539, 176, 89, 23);
		panel.add(btnNewButton_2);

	}

	private void start1() {
		ProcessBuilder processBuilder = new ProcessBuilder(textField.getText());
		try {
			Process proceso = processBuilder.start();

			lblNewLabel.setText("" + proceso.pid());

			ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);

			if (procesoPadre != null) {
				lblNewLabel_3.setText("" + procesoPadre.pid());
			} else {
				JOptionPane.showMessageDialog(null, "No hay pid del proceso padre", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void start2() {
		ProcessBuilder processBuilder = new ProcessBuilder(textField_1.getText());
		try {
			Process proceso = processBuilder.start();

			lblNewLabel_1.setText("" + proceso.pid());

			ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);

			if (procesoPadre != null) {
				lblNewLabel_4.setText("" + procesoPadre.pid());
			} else {
				JOptionPane.showMessageDialog(null, "No hay pid del proceso padre", "Error", JOptionPane.ERROR_MESSAGE);
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

			String resultado = "";
			String line;
			while ((line = reader.readLine()) != null) {
				resultado += line + "\n";
			}
			reader.close();

			textPane.setText(resultado);

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void start3() {
		ProcessBuilder processBuilder = new ProcessBuilder(textField_2.getText());
		try {
			Process proceso = processBuilder.start();

			lblNewLabel_2.setText("" + proceso.pid());

			ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);

			if (procesoPadre != null) {
				lblNewLabel_5.setText("" + procesoPadre.pid());
			} else {
				JOptionPane.showMessageDialog(null, "No hay pid del proceso padre", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
