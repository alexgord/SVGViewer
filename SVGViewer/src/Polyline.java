import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


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
	/****************************************************************************
									paint Function
		Function paints a Polyline to the screen using the java SWING library        
	 ****************************************************************************/
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(this.strokeColor);
		g2.drawPolyline(this.xPoints, this.yPoints, this.nPoints);
	}

}
