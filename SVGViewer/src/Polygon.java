import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

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
	/****************************************************************************
								paint Function
		Function paints a Polygon to the screen using the java SWING library        
	 ****************************************************************************/
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		//g.setColor(this.strokeColor);
		//g.drawPolygon(xPoints, yPoints, nPoints);
		//g.setColor(this.fillColor);
		//g.fillPolygon(xPoints, yPoints, nPoints);

		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);		

		if (fillColor != null)
		{
			g2.setColor(fillColor);
			g2.fillPolygon(xPoints, yPoints, nPoints);
		}


		Shape outline = new java.awt.Polygon(xPoints, yPoints, nPoints);
		g2.setStroke(new BasicStroke(1));
		g2.setColor(this.strokeColor);
		g2.draw(outline);
	}

}
