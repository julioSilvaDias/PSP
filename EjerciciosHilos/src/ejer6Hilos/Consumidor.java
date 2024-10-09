package ejer6Hilos;

public class Consumidor extends Thread {
	private Buffer buffer;

	public Consumidor(Buffer b) {
		this.buffer = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			char c = buffer.recoger();
			System.out.println("Consumido " + c);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
