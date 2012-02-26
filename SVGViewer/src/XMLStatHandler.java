import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLStatHandler implements ErrorHandler, ContentHandler
{

	  private boolean error;
	  private ArrayList<Paintable> plist;
	  public boolean hasError() { return error; }
	  
	  public XMLStatHandler() {
		    plist = new ArrayList<Paintable>();
		  }
	  
	  /* ==========================================================================
	   * ContentHandler 
	   * --------------------------------------------------------------------------
	   */
	  
	  @Override
	  public void error(SAXParseException exception) throws SAXException {
	    errorHelper("ERROR", exception.getLineNumber(), exception.getMessage());
	    error = true;
	  }
	
	  @Override
	  public void fatalError(SAXParseException exception) throws SAXException {
	    errorHelper("FATAL", exception.getLineNumber(), exception.getMessage());
	    System.exit(1);
	  }
	
	  @Override
	  public void warning(SAXParseException exception) throws SAXException {
	    errorHelper("WARNING", exception.getLineNumber(), exception.getMessage());		
	  }
	  
	  private void errorHelper(String heading, int line, String message) {
	    System.err.println("[" + heading + "] line " + line + ": " + message);
	  }
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = String.copyValueOf(ch, start, length);
		if(!contents.trim().equals(""))
			System.out.println("characters inside  [" + contents + "]");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end document");
		JFrame frame = new JFrame();
		frame.setTitle("Testing CanvasComponent");
		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CanvasComponent canvas;
		//testing line
		for (int i = 0; i < plist.size(); i++ )
		{
			canvas = new CanvasComponent(plist.get(i));
			canvas.setBounds(frame.getBounds());
			frame.add(canvas);
			System.out.println(i);
		}
		frame.setVisible(true);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	  System.out.println("end \"" + qName + "\" element");
	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
	  System.out.println("start document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts)
	  throws SAXException
	{
		Paintable toAdd;
		int height;
		int width;
		int x;
		int y;
		Color strokeColor;
		Color fillColor;
		System.out.println("start <" + qName + "> element");
		if(atts.getLength() > 0) {
			System.out.print("\tattributes: ");
			for(int i=0; i < atts.getLength(); i++)
			{
				System.out.print(atts.getQName(i) + "=" + atts.getValue(i) + " ");
			}
			if (qName == "rect")
			{
				x = Integer.decode(atts.getValue(0));
				y = Integer.decode(atts.getValue(1));
				height = Integer.decode(atts.getValue(2));
				width = Integer.decode(atts.getValue(3));
				fillColor = Color.blue;
				strokeColor = Color.black;
				toAdd = new Rectangle(x, y, height, width, fillColor, strokeColor);
				plist.add(toAdd);
			}
			System.out.println();
		}
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
