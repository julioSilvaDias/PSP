package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Ejer5 {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder("CMD", "/c", "tasklist");

		try {

			Process execComando = processBuilder.start();
			
			

			InputStream inputStream = execComando.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String line;
			String powerShell=null;

			
			while(null!=(line=bufferedReader.readLine())) {
				System.out.println(line);
				powerShell += line;
			}
			
			if(powerShell.contains("Notepad.exe")) {
				ProcessBuilder ProccessBuilderKill = new ProcessBuilder("CMD", "/c", "taskkill /IM notepad.exe");
				ProccessBuilderKill.start();
				System.out.println("Se elimino el notepad");

			}else {
				System.out.println("No se elimino el notepad");
			}
			
			inputStream.close();
			

		} catch (IOException e) {

			e.printStackTrace();

	}
	}
}
