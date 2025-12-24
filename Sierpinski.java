import java.awt.Color;

/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	static int CANVAS_PIXEL_SIZE_X = 1000;
	static int CANVAS_PIXEL_SIZE_Y = 1000;
	static int LINE_DENSITY = 70;

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	

	public static void initializeCanvas(){
		StdDraw.setCanvasSize(CANVAS_PIXEL_SIZE_X, CANVAS_PIXEL_SIZE_Y);
		StdDraw.setTitle("Sierpinski");
		StdDraw.setXscale(0, CANVAS_PIXEL_SIZE_X);
		StdDraw.setYscale(0, CANVAS_PIXEL_SIZE_Y);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(Color.BLACK);

	}
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		initializeCanvas();

		double[] xCoords = {CANVAS_PIXEL_SIZE_X/2, 0, CANVAS_PIXEL_SIZE_X};
		double[] yCoords = {CANVAS_PIXEL_SIZE_Y, 0, 0};

		System.out.println("(" + xCoords[0] + "," +yCoords[0] +")");
		System.out.println("(" + xCoords[1] + "," +yCoords[1] +")");
		System.out.println("(" + xCoords[2] + "," +yCoords[2] +")");
		StdDraw.show();

		sierpinski(n, xCoords[0],xCoords[1],xCoords[2],yCoords[0],yCoords[1],yCoords[2]);
	}
	
	private static void drawLine(int n, double x1, double y1, double x2, double y2){
		double x = 0, y = 0, multiplier = 0;
    	for (int i = 0; i < LINE_DENSITY; i++) {
        	multiplier = i / (double) LINE_DENSITY;
        	x = x1 + multiplier * (x2 - x1);
        	y = y1 + multiplier * (y2 - y1);
        	StdDraw.point(x, y);
    	}
	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if(n == 0) return;

		drawLine(n,x1, y1, x2, y2);
		drawLine(n,x1, y1, x3, y3);
		drawLine(n,x2, y2, x3, y3);
		
		double x4 = (x1+x2)/2;
		double y4 = (y1+y2)/2;
		
		double x5 = (x1+x3)/2;
		double y5 = (y1+y3)/2;

		double x6 = (x2+x3)/2;
		double y6 = (y2+y3)/2;


		System.out.println("(" + x4 + "," + y4 +")");
		System.out.println("(" + x4 + "," + y4 +")");
		System.out.println("(" + x4 + "," + y4 +")");
		
		sierpinski(n-1, x1,x4,x5,y1,y4,y5);
		sierpinski(n-1, x2,x4,x6,y2,y4,y6);
		// sierpinski(n-1, x4,x5,x6,y4,y5,y6);
		sierpinski(n-1, x3,x5,x6,y3,y5,y6);

		StdDraw.show();
	}
}
