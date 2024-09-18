package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Ejer5 {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "/C", "ps notepad");

		try {

			Process execComando = processBuilder.start();
			
			

			InputStream inputStream = execComando.getInputStream();

			System.out.println();

			int c;

			while ((c = inputStream.read()) != -1)

				System.out.print((char) c);

			inputStream.close();
			

		} catch (IOException e) {

			e.printStackTrace();

	}
	}
}
