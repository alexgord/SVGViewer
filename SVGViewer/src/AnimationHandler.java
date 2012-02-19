import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnimationHandler implements ActionListener {

	private Target target;
	private CanvasComponent canvas;
	private double theta;
	
	public AnimationHandler(Target target, CanvasComponent canvas) {
		super();
		this.target = target;
		this.canvas = canvas;
		this.theta = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		theta += 0.1;
		target.moveTo(150 + 50* Math.cos(theta), 100 + 50 * Math.sin(theta));
		canvas.repaint();
	}

}
