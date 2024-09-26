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
	private JTextField textFieldEjecutarAplicacion;
	private JTextField textFieldEjecutarCmd;
	private JTextField textFieldLlamarPrograma;
	private JLabel lblPid1;
	private JLabel lblPid2;
	private JLabel lblPid3;
	private JLabel lblPidPadre1;
	private JLabel lblPidPadre2;
	private JLabel lblPidPadre3;
	private JTextPane textPaneResultadoCmd;
	private JTextPane salidaPrograma;

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

		JLabel lblPid = new JLabel("PID");
		lblPid.setBounds(34, 228, 73, 23);
		panel.add(lblPid);

		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(34, 262, 73, 23);
		panel.add(lblPidPadre);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(34, 306, 73, 23);
		panel.add(lblResultado);

		lblPid1 = new JLabel("");
		lblPid1.setBounds(153, 232, 64, 19);
		panel.add(lblPid1);

		lblPid2 = new JLabel("");
		lblPid2.setBounds(340, 232, 70, 19);
		panel.add(lblPid2);

		lblPid3 = new JLabel("");
		lblPid3.setBounds(539, 228, 189, 18);
		panel.add(lblPid3);

		lblPidPadre1 = new JLabel("");
		lblPidPadre1.setBounds(153, 266, 64, 19);
		panel.add(lblPidPadre1);

		lblPidPadre2 = new JLabel("");
		lblPidPadre2.setBounds(340, 266, 70, 14);
		panel.add(lblPidPadre2);

		lblPidPadre3 = new JLabel("");
		lblPidPadre3.setBounds(539, 262, 189, 18);
		panel.add(lblPidPadre3);

		textFieldEjecutarAplicacion = new JTextField();
		textFieldEjecutarAplicacion.setBorder(null);
		textFieldEjecutarAplicacion.setBounds(108, 108, 131, 36);
		panel.add(textFieldEjecutarAplicacion);
		textFieldEjecutarAplicacion.setColumns(10);

		textFieldEjecutarCmd = new JTextField();
		textFieldEjecutarCmd.setColumns(10);
		textFieldEjecutarCmd.setBounds(300, 108, 131, 36);
		panel.add(textFieldEjecutarCmd);

		textFieldLlamarPrograma = new JTextField();
		textFieldLlamarPrograma.setColumns(10);
		textFieldLlamarPrograma.setBounds(517, 108, 131, 36);
		panel.add(textFieldLlamarPrograma);

		textPaneResultadoCmd = new JTextPane();
		textPaneResultadoCmd.setBounds(258, 306, 205, 274);
		panel.add(textPaneResultadoCmd);

		salidaPrograma = new JTextPane();
		salidaPrograma.setBounds(483, 306, 205, 274);
		panel.add(salidaPrograma);

		JButton startButtonEjecutarAplicacion = new JButton("Start");
		startButtonEjecutarAplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ejecutarAplicacionSistema();
			}
		});
		startButtonEjecutarAplicacion.setBounds(128, 176, 89, 23);
		panel.add(startButtonEjecutarAplicacion);

		JButton startButtonEjecutarCmd = new JButton("Start");
		startButtonEjecutarCmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ejecutarComandoCmd();
			}

		});
		startButtonEjecutarCmd.setBounds(321, 176, 89, 23);
		panel.add(startButtonEjecutarCmd);

		JButton btnLlamarPrograma = new JButton("Start");
		btnLlamarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				llamarPrograma5Veces();
			}
		});
		btnLlamarPrograma.setBounds(539, 176, 89, 23);
		panel.add(btnLlamarPrograma);

	}

	private void ejecutarComandoCmd() {
		ProcessBuilder processBuilder = new ProcessBuilder(textFieldEjecutarCmd.getText());
		try {
			Process process = processBuilder.start();

			lblPid2.setText("" + process.pid());

			ProcessHandle processHandle = ProcessHandle.current().parent().orElse(null);

			if (processHandle != null) {
				lblPidPadre2.setText("" + processHandle.pid());
			} else {
				JOptionPane.showMessageDialog(null, "No hay PID del proccesHandle", "Error", JOptionPane.ERROR_MESSAGE);
			}

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String resultado = "";
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				resultado += line + "\n";
			}
			bufferedReader.close();

			textPaneResultadoCmd.setText(resultado);

		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "IOException", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void ejecutarAplicacionSistema() {
		ProcessBuilder processBuilder = new ProcessBuilder(textFieldEjecutarAplicacion.getText());
		try {
			Process proceso = processBuilder.start();

			lblPid1.setText("" + proceso.pid());

			ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);

			if (procesoPadre != null) {
				lblPidPadre1.setText("" + procesoPadre.pid());
			} else {
				JOptionPane.showMessageDialog(null, "No hay pid del proceso padre", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void llamarPrograma5Veces() {
		String programa = textFieldLlamarPrograma.getText();
		salidaPrograma.setText("");

		for (int i = 0; i < 5; i++) {
			ejecutarPrograma(programa);
		}
	}

	private void ejecutarPrograma(String programa) {
		if (programa == null || programa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre del programa no puede estar vacío.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "src", "ejercicio2." + programa, "prueba");
		processBuilder.redirectErrorStream(true);

		try {
			Process proceso = processBuilder.start();
			lblPid3.setText(lblPid3.getText() + "PID: " + proceso.pid() + "\n");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			StringBuilder salida = new StringBuilder();
			String linea;

			while ((linea = bufferedReader.readLine()) != null) {
				salida.append(linea).append("\n");
			}

			salidaPrograma.setText(salidaPrograma.getText() + salida.toString());
			proceso.waitFor();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error ejecutando el programa: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
