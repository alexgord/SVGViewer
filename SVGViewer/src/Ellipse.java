import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ellipse implements Paintable
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color fillColor;
	private Color strokeColor;
	private int strokeWidth;

	public Ellipse (int x, int y, int height, int width, Color fillColor, Color strokeColor, int strokeWidth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
		this.strokeColor = strokeColor;
		this.strokeWidth = strokeWidth;
	}

	@Override
	/****************************************************************************
							paint Function
		Function paints an ellipse to the screen using the java SWING library        
	 ****************************************************************************/
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);		

		if (fillColor != null)
		{
			g2.setColor(fillColor);
			g2.fillOval(x, y, width, height);
		}

		Shape outline = new Ellipse2D.Double(x, y, width, height);
		g2.setStroke(new BasicStroke(strokeWidth));
		g2.setColor(this.strokeColor);
		g2.draw(outline);		
	}

}
