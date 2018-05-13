
public class Definitions extends MainWindow {

	private final static int WIDTH = 1200;
	private final static int HEIGHT = 800;
	private static int DIFFICULTY = 1;
	private static int GRIDSIZE = 10;
	private final static int EDGE = 20;
	
	public static int getWIDTH() {
		return WIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}
	
	public static int getEDGE(){
		return EDGE;
	}
	
	private int getDIFFICULTY() {
		return DIFFICULTY;
	}
	static void setDIFFICULTY(int dIFFICULTY) {
		DIFFICULTY = dIFFICULTY;
	}
	public static int getGRIDSIZE() {
		return GRIDSIZE;
	}
	public static void setGRIDSIZE(int gRIDSIZE) {
		GRIDSIZE = gRIDSIZE;
	}

}
