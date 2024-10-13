package ejer6Hilos;

public class Buffer {
	private char contenido;
	private boolean bufferLleno;

	public synchronized void poner(char c) {
		contenido = c;
		bufferLleno = true;
	}

	public synchronized char recoger() {
		char ret = 0;
		if (bufferLleno) {
			bufferLleno = false;
			ret = contenido;
		} else {
			ret = ' ';
		}
		return ret;
	}
}