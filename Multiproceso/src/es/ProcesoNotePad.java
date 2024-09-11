package es;

import java.util.Map;

public class ProcesoNotePad {
	public static void main(String[] args) {
		System.out.println("vamos a lanzar el Notepad");

		String infoProceso = "Notepad.exe";

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(infoProceso);
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
