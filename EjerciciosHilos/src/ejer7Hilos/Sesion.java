package ejer7Hilos;

public class Sesion {
	
	private static Sesion instance = null;
	private int pCaballo1 =0;
	private int pCaballo2 =0;
	private int pCaballo3 =0;
	private int pCaballo4 =0;
	
	private Sesion() {
		
	}
	
	public static Sesion getInstance() {
		if(null == instance) {
			instance = new Sesion();
		}
		
		return instance;
	}

	public int getpCaballo1() {
		return pCaballo1;
	}

	public void setpCaballo1(int pCaballo1) {
		this.pCaballo1 = pCaballo1;
	}

	public int getpCaballo2() {
		return pCaballo2;
	}

	public void setpCaballo2(int pCaballo2) {
		this.pCaballo2 = pCaballo2;
	}

	public int getpCaballo3() {
		return pCaballo3;
	}

	public void setpCaballo3(int pCaballo3) {
		this.pCaballo3 = pCaballo3;
	}

	public int getpCaballo4() {
		return pCaballo4;
	}

	public void setpCaballo4(int pCaballo4) {
		this.pCaballo4 = pCaballo4;
	}
	
	
	
}
