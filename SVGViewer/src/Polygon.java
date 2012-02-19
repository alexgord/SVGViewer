import java.awt.Graphics;
import java.awt.Color;

public class Polygon implements Paintable
{
	private int[] xPoints;
	private int[]yPoints;
	private int nPoints;
	private Color fillColor;
	
	public Polygon(int[] xPoints, int[]yPoints, int nPoints, Color fillColor)
	{
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nPoints = nPoints;
		this.fillColor = fillColor;
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.setColor(this.fillColor);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}

}
