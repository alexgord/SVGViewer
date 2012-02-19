import java.awt.Graphics;

import javax.swing.JComponent;


public class CanvasComponent extends JComponent {

	private Paintable paintable;
	
	public CanvasComponent(Paintable paintable) {
		super();
		this.paintable = paintable;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(paintable != null)
			paintable.paint(g);
	}
	
}
