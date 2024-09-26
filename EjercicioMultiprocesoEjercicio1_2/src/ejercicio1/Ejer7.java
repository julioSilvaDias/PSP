package ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejer7 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String parametro;
		System.out.print("Introduce una cadena de texto: ");
		parametro = teclado.nextLine();

		ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "src", "ejercicio1.EjemploLectura", parametro);
		processBuilder.redirectErrorStream(true);

		try {
			Process process = processBuilder.start();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder salida = new StringBuilder();
			String linea;

			while ((linea = bufferedReader.readLine()) != null) {
				salida.append(linea).append("\n");
			}
			
			System.out.println(salida.toString());
			process.waitFor();

		} catch (Exception e) {

		}
	}

}
