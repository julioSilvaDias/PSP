package ejer7Hilos;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread {

	JProgressBar barraDeProgreso = null;
	String caballo = null;
	JLabel ganador = null;

	public HiloCaballo(JProgressBar barra, String caballo, JLabel ganador) {
		this.barraDeProgreso = barra;
		this.caballo = caballo;
		this.ganador = ganador;
	}

	public void Run() {
		
	}

}
