import java.awt.Graphics;
import java.awt.Color;

public class Ellipse implements Paintable
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color fillColor;
	
	public Ellipse (int x, int y, int width, int height, Color fillColor)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
	}
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.drawOval(x, y, width, height);
		g.setColor(fillColor);
		g.fillOval(x, y, width, height);
	}

}
