import java.awt.Graphics;

import javax.swing.JComponent;


public class CanvasComponent extends JComponent {

	private Target target;
	
	public CanvasComponent(Target target) {
		super();
		this.target = target;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(target != null)
			target.paint(g);
	}
	
}
