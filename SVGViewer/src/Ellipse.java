import java.awt.Graphics;
import java.awt.Color;

import javax.swing.border.AbstractBorder;

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
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(this.strokeColor);
		g.fillOval(x - strokeWidth, y - strokeWidth , width + strokeWidth * 2, height + strokeWidth * 2);
		//g.drawOval(x, y, width, height);
		g.setColor(fillColor);
		g.fillOval(x, y, width, height);
	}

}
