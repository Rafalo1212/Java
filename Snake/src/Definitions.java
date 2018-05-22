
public class Definitions extends MainWindow {

	private final static int WIDTH = 1200;
	private final static int HEIGHT = 900;
	private final static int GSIZE = 800;
	
	private static int DIFFICULTY = 10;
	private static int GRIDSIZE = 40;
	
	public static int getWIDTH() {
		return WIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}
	
	public static int getDIFFICULTY() {
		return DIFFICULTY;
	}
	public static void setDIFFICULTY(int dIFFICULTY) {
		DIFFICULTY = dIFFICULTY;
	}
	public static int getGRIDSIZE() {
		return GRIDSIZE;
	}
	public static void setGRIDSIZE(int gRIDSIZE) {
		GRIDSIZE = gRIDSIZE;
	}
	public static int getGSIZE() {
		return GSIZE;
	}

}
