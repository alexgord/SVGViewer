import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


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
	/****************************************************************************
								paint Function
		Function paints a Line to the screen using the java SWING library        
	 ****************************************************************************/
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(this.strokeColor);
		g2.drawLine(x1, y1, x2, y2);		

	}

}
