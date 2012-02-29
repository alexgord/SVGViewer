import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SVGViewer
{

	/**
	 * @param args
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws SAXException
	{
		/*JFrame frame = new JFrame();
		frame.setTitle("Testing CanvasComponent");
		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//testing line
		Line l = new Line(50, 50, 60, 80, Color.black);
		CanvasComponent canvas = new CanvasComponent(l);
		canvas.setBounds(frame.getBounds());
		frame.add(canvas);
		
		l = new Line(500, 200, 210, 110, Color.black);
		CanvasComponent canvas2 = new CanvasComponent(l);
		canvas2.setBounds(frame.getBounds());
		frame.add(canvas2);
		
		//testing rectangle
		Rectangle r = new Rectangle(80, 5, 50, 80, Color.blue, Color.black);
		CanvasComponent canvas3 = new CanvasComponent(r);
		canvas3.setBounds(frame.getBounds());
		frame.add(canvas3);
		frame.setVisible(true);
		
		//testing ellipse
		Ellipse e = new Ellipse(200, 50, 80, 50, Color.orange, Color.black);
		CanvasComponent canvas4 = new CanvasComponent(e);
		canvas4.setBounds(frame.getBounds());
		frame.add(canvas4);
		frame.setVisible(true);
		
		//testing polygon
		int[] x = new int[3];
		int[] y = new int[3];
		
		x[0] = 100;
		x[1] = 150;
		x[2] = 200;
		
		y[0] = 100;
		y[1] = 200;
		y[2] = 150;
		
		Polygon p = new Polygon(x, y, x.length, Color.green, Color.black);
		CanvasComponent canvas5 = new CanvasComponent(p);
		canvas5.setBounds(frame.getBounds());
		frame.add(canvas5);
		
		//testing Polyline
		x = new int[3];
		y = new int[3];
		
		x[0] = 120;
		x[1] = 220;
		x[2] = 220;
		
		y[0] = 220;
		y[1] = 220;
		y[2] = 120;
		
		Polyline pl = new Polyline(x, y, x.length, Color.black);
		CanvasComponent canvas6 = new CanvasComponent(pl);
		canvas6.setBounds(frame.getBounds());
		frame.add(canvas6);
		frame.setVisible(true);*/
		String uri = "http://linux-cs.johnabbott.qc.ca/~ian/cs603/asg2/drawing1.svg";
		XMLReader reader = XMLReaderFactory.createXMLReader();
		XMLStatHandler handler = new XMLStatHandler();
		reader.setErrorHandler(handler);
		reader.setContentHandler(handler);
		try {
		  reader.parse(uri);
		  if(handler.hasError()) {
		    System.out.println("Fix the errors listed above...");
		  }
		  else {
		    System.out.println("No errors detected.");
		  }
		} 
		catch (Exception e) {
		  System.err.println(e.getMessage());
		  System.exit(1);
		} 
	}

}
