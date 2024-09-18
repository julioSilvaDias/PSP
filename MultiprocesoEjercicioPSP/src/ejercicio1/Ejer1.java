package ejercicio1;

import java.util.Map;

public class Ejer1 {

	public static void main(String[] args) {
		String nomProceso = "Notepad.exe";

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(nomProceso);
			Map<String, String> enviroment = processBuilder.environment();

			System.out.println("Numero de procesadores " + enviroment.get("NUMBER_OF_PROCESSORS"));
			Process process1 = processBuilder.start();

			System.out.println("El ID del proceso es " + process1.pid());

			int codigoRetorno = process1.waitFor();
			System.out.println("Fin del proceso con codigo " + codigoRetorno);

		} catch (Exception e) {

		}

	}

}
