package es;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoCmd {
	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder("CMD");

		try {

			Process p = processBuilder.start();
			System.out.println("parte1");

			InputStream inputStream = p.getInputStream();
			System.out.println();

			int i;
			while ((i = inputStream.read()) != 1)
				System.out.print((char) i);
			inputStream.close();
			
			System.out.println("parte 2");
			
			InputStream er = p.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(er));
			
			String line = null;
			while((line= bufferedReader.readLine()) != null)
				System.out.println(line);
			
			er.close();

		} catch (Exception e) {

		}
	}
}
