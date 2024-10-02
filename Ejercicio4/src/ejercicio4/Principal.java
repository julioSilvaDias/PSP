package ejercicio4;

public class Principal {

	public static void main(String[] args) {
		ContadorConRetardo h1 = new ContadorConRetardo("Bomba1", 20);
		ContadorConRetardo h2 = new ContadorConRetardo("Bomba2", 10);
		ContadorConRetardo h3 = new ContadorConRetardo("Bomba3", 5);
		ContadorConRetardo h4 = new ContadorConRetardo("Bomba4", 7);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		try {

			h2.join();h1.join();h3.join();h4.join();

		} catch (InterruptedException e) {

		}
		System.out.println("fin del programa");
	}

}
