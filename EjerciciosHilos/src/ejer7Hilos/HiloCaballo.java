package ejer7Hilos;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread {

	public JProgressBar barraDeProgreso = null;
	private String caballo = null;
	public JLabel ganador = null;
	private Boolean hayGanador = false;

	public HiloCaballo(JProgressBar barra, String caballo, JLabel ganador) {
		this.barraDeProgreso = barra;
		this.caballo = caballo;
		this.ganador = ganador;
	}

	public void run() {
		
		int intAletorio = 0;

		while (barraDeProgreso.getValue() < 100 && !hayGanador) {
			Random aleatorio = new Random(System.currentTimeMillis());
			intAletorio += aleatorio.nextInt(20);
			barraDeProgreso.setValue(intAletorio);

			if (barraDeProgreso.getValue() == 100) {
				hayGanador = true;
				terminar();
				
			}

			try {
				sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void terminar() {

		try {
			ganador.setText("ganador: " + caballo);
			//interrupt();
			sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
