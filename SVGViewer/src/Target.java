import java.awt.Color;
import java.awt.Graphics;

public class Target {

	
	private final int DEFAULT_WIDTH = 100;

	private double originX;
	private double originY;
	private int width;
	private int ringDistance;

	private Color[] rings;

	public Target(double x, double y, Color[] rings ){
		this.originX = x;
		this.originY = y;
		this.rings = rings;

		width = DEFAULT_WIDTH;
		ringDistance = width/rings.length;
	}

	public void paint( Graphics g ){

		double x = originX - width/2;
		double y = originY - width/2;

		for (int i = rings.length-1; i>=0; i-- ) {
			g.setColor(rings[i]);

			//g.drawOval((int)x, (int)y, (int)(ringDistance * i), (int)(ringDistance * i));
			g.fillOval((int)x, (int)y, (int)(ringDistance * (i+1)), (int)(ringDistance * (i+1)));
			x+=ringDistance/2;
			y+=ringDistance/2;
		}
	}

	public void move( double deltaX, double deltaY ){
		originX+=deltaX;
		originY+=deltaY;
	}
	
	public void moveTo(double x, double y) {
		originX = x;
		originY = y;
	}

}
