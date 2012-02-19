import java.awt.Color;
import java.awt.Graphics;


public class Line implements Paintable
{
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color strokeColor;
	
	public Line(int x1, int y1, int x2, int y2, Color strokeColor)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.strokeColor = strokeColor;
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub

		g.setColor(this.strokeColor);
		g.drawLine(x1, y1, x2, y2);		

	}

}
