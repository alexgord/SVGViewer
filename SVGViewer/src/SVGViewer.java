import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


public class SVGViewer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("Testing CanvasComponent");
		frame.setBounds(0, 0, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*Color[] targetColors = new Color[3];
		targetColors[0]= Color.RED;
		targetColors[1] = Color.WHITE;
		targetColors[2] = Color.RED;
		Target target = new Target(150, 150, targetColors);
		target.moveTo(100, 100);
		
		// Create and initialise a CanvasComponent
		CanvasComponent canvas = new CanvasComponent(target);
		canvas.setBounds(frame.getBounds());
		frame.add(canvas);

		AnimationHandler anim = new AnimationHandler(target, canvas);
		Timer timer = new Timer(50, anim);
		timer.start();
		
		frame.setVisible(true);*/
		Line l = new Line(5, 5, 100, 100);
		CanvasComponent canvas = new CanvasComponent(l);
		canvas.setBounds(frame.getBounds());
		frame.add(canvas);
		
		l = new Line(500, 500, 210, 110);
		CanvasComponent canvas2 = new CanvasComponent(l);
		canvas2.setBounds(frame.getBounds());
		frame.add(canvas2);
		
		Rectangle r = new Rectangle(80, 5, 50, 80, Color.blue);
		CanvasComponent canvas3 = new CanvasComponent(r);
		canvas3.setBounds(frame.getBounds());
		frame.add(canvas3);
		frame.setVisible(true);
		
		Ellipse e = new Ellipse(200, 50, 80, 50, Color.orange);
		CanvasComponent canvas4 = new CanvasComponent(e);
		canvas4.setBounds(frame.getBounds());
		frame.add(canvas4);
		frame.setVisible(true);
		
		int[] x = new int[3];
		int[] y = new int[3];
		
		x[0] = 100;
		x[1] = 300;
		x[2] = 400;
		
		y[0] = 100;
		y[1] = 400;
		y[2] = 300;
		
		Polygon p = new Polygon(x, y, x.length, Color.green);
		CanvasComponent canvas5 = new CanvasComponent(p);
		canvas5.setBounds(frame.getBounds());
		frame.add(canvas5);
		frame.setVisible(true);
	}

}
