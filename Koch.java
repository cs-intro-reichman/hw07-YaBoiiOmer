import java.awt.Color;

/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	static int CANVAS_WIDTH = 1280;
	static int CANVAS_HEIGHT = 720;
	static int LINE_DENSITY = 300;
	public static void main(String[] args) {
		initialize();
		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		*/
		// curve(Integer.parseInt(args[0]),
		// Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		// Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		*/

		snowFlake(Integer.parseInt(args[0]));
	}
	public static void drawLine(double x1, double y1, double x2, double y2, Color color){
		System.out.println(String.format("Drawing line from (%f, %f) to (%f, %f)", x1,y1, x2,y2) );
		StdDraw.setPenColor(color);
		double x = 0, y = 0, multiplier = 0;
		for (int i = 0; i < LINE_DENSITY; i++) {
			multiplier = i / (double) LINE_DENSITY;
			x = x1 + multiplier * (x2 - x1);
			y = y1 + multiplier * (y2 - y1);
			StdDraw.point(x, y);
		}
		// StdDraw.show();
}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			drawLine(x1, y1, x2, y2, Color.BLACK);
			return;
		}

		double dx = (x2 - x1);
		double dy = (y2 - y1);

		double x3 = x1 + dx / 3;
		double y3 = y1 + dy / 3;

		double x4 = x1 + (2 * dx) / 3;
		double y4 = y1 + (2 * dy) / 3;

		double x5 = (Math.sqrt(3)/2)*(y3 - y4) + 0.5*(x3 + x4);
		double y5 = (Math.sqrt(3)/2)*(x4 - x3) + 0.5*(y3 + y4);

		curve(n-1, x1, y1, x3, y3);
		curve(n-1, x3, y3, x5, y5);
		curve(n-1, x5, y5, x4, y4);
		curve(n-1, x4, y4, x2, y2);


	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {

		double[] a = {0.25, 0.65};
		double[] b = {0.75, 0.65};
		double[] c = {0.5, 0.25};

		curve(n, a[0], a[1], b[0], b[1]);
		curve(n, b[0], b[1], c[0], c[1]);
		curve(n, c[0], c[1], a[0], a[1]);


	}
	
	public static void initialize(){
		// StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		// StdDraw.setYscale(0, CANVAS_WIDTH);
		// StdDraw.setXscale(0, CANVAS_HEIGHT);
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		StdDraw.setTitle("Snowflakes");
	}


}
