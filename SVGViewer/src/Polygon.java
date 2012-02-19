import java.awt.Graphics;
import java.awt.Color;

public class Polygon implements Paintable
{
	private int[] xPoints;
	private int[]yPoints;
	private int nPoints;
	private Color fillColor;
	private Color strokeColor;
	
	public Polygon(int[] xPoints, int[]yPoints, int nPoints, Color fillColor, Color strokeColor)
	{
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nPoints = nPoints;
		this.fillColor = fillColor;
		this.strokeColor = strokeColor;
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(this.strokeColor);
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.setColor(this.fillColor);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}

}
