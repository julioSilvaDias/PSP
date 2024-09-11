package es;

import java.io.File;

public class ProcesoPrincipal {

	public static void main(String[] args) {
		System.out.println("Ejecutamos el proceso secundario");
		
		try{
			
			ProcessBuilder builder;
			builder = new ProcessBuilder ("java","es.ProcesoSecundario");
			builder.directory(new File("bin"));
			Process process = builder.start();
			
			int valorRetorno=process.waitFor();
			
			if(valorRetorno==0) {
				System.out.println("Procesp secundario finalizado con exito");

			}else {
				System.out.println("Processo secundario ha fallado");
				System.out.println("codigo de erro: " + valorRetorno);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
