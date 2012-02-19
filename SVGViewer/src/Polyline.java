import java.awt.Color;
import java.awt.Graphics;


public class Polyline implements Paintable
{
	private int[] xPoints;
	private int[]yPoints;
	private int nPoints;
	private Color strokeColor;
	
	public Polyline(int[] xPoints, int[] yPoints, int nPoints, Color strokeColor)
	{
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nPoints = nPoints;
		this.strokeColor = strokeColor;
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(this.strokeColor);
		g.drawPolyline(this.xPoints, this.yPoints, this.nPoints);
	}

}
