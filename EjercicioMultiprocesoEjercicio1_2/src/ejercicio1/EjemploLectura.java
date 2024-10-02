package ejercicio1;

public class EjemploLectura {

	public static void main(String[] args) {
		String cadena = null;
		if (args.length > 0) {
			cadena = args[0];
			System.out.println("cadena recibida: " + cadena);
		} else {
			System.out.print("no hay cadenas para leer");
		}

	}

}
