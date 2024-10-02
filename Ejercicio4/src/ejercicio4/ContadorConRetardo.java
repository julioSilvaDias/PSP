package ejercicio4;

public class ContadorConRetardo extends Thread {
	private int n;

	public ContadorConRetardo(String nom, int n) {
		super(nom);
		this.n = n;
	}

	public void run() {

		for (int i=n; i<0; i--) {
			System.out.println(getName() + "; " + i );
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
		
		System.out.println(getName() + " BOOOMMM");
	}
}
