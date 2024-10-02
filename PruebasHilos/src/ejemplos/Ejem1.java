package ejemplos;

public class Ejem1 {

	public static void main(String[] args) {
		HiloJoin h1 = new HiloJoin("Hilo1", 20);
		HiloJoin h2 = new HiloJoin("Hilo2", 50);
		HiloJoin h3 = new HiloJoin("Hilo3", 20);

		h1.start();
		h2.start();
		h3.start();

		try {
			h2.setPriority(Thread.MAX_PRIORITY);
			Thread.sleep(8000);
			h2.interrupt();

			h2.join();h1.join();h1.join();

		} catch (InterruptedException e) {

		}
		System.out.println("fin del programa");

	}
}