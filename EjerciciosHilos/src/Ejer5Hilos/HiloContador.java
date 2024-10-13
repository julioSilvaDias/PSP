package Ejer5Hilos;

import javax.swing.JLabel;

public class HiloContador extends Thread{
	private JLabel etiquetaContador = null;
	private int n=0;
	private int contador=0;

	public HiloContador(JLabel etiquetaContador, int n, String nom) {
		super(nom);
		this.etiquetaContador = etiquetaContador;
		this.n = n;
	}
	
	public void run() {
		for(int i=0; i<n;i++) {
			etiquetaContador.setText("");
			etiquetaContador.setText(getName() + ": " + i);
			
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
