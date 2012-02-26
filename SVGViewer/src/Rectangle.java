import java.awt.Graphics;
import java.awt.Color;

public class Rectangle implements Paintable
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color fillColor;
	private Color strokeColor;
	
	public Rectangle(int x, int y, int height, int width, Color fillColor, Color strokeColor)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
		this.strokeColor = strokeColor;
	}

	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(this.strokeColor);
		g.drawRect(x, y, width, height);
		g.setColor(fillColor);
		g.fillRect(x, y, width, height);
	}

}
