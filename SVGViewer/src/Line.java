import java.awt.Graphics;


public class Line implements Paintable
{
	private int x1;
	private int x2;
	private int y1;
	private int y2;
		
	public Line(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub

		//g.drawOval((int)x, (int)y, (int)(ringDistance * i), (int)(ringDistance * i));
		//g.fillOval((int)x, (int)y, (int)(ringDistance * (i+1)), (int)(ringDistance * (i+1)));
		g.drawLine(x1, y1, x2, y2);		

	}

}
