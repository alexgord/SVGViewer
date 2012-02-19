import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;


public class SVGViewer {

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
		frame.setVisible(true);
	}

}
