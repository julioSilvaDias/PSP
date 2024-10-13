package ejer6Hilos;
public class Productor extends Thread{
	private Buffer buffer;
	
	public Productor(Buffer b) {
		this.buffer = b;
	}
	
	public void run() {
		for(int i =0; i<10;i++) {
			char c = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
			buffer.poner(c);
			System.out.println("Producido " + c);
			
			try {
				sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}