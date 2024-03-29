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
	private ArrayList<Paintable> plist; //Contains all the elements in the svg file
	public boolean hasError() { return error; }
	private int fwidth; //The width of the window
	private int fheight; //the Height of the window
	private String title;	// THe title of the window  

	public XMLStatHandler() {
		plist = new ArrayList<Paintable>();
		fwidth = 0;
		fheight = 0;
		title = "";
	}

	/* ==========================================================================
	 * 	   * ContentHandler 
	 * 	   * --------------------------------------------------------------------------
	 * 	   */

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
		{
			//Set the screentitle using the title in the svg file
			System.out.println("characters inside  [" + contents + "]");
			title = contents;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end document");
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, fwidth, fheight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		CanvasComponent canvas;
		//Add all the elements in the svg file to the screen
		for (int i = plist.size(); i > 0; i-- )
		{
			canvas = new CanvasComponent(plist.get(i - 1));
			canvas.setBounds(frame.getBounds());
			frame.add(canvas);
			System.out.println(i - 1);
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
		Color strokeColor = null;
		Color fillColor = null;
		int strokeWidth = 1;
		System.out.println("start <" + qName + "> element");
		if(atts.getLength() > 0) {
			System.out.print("\tattributes: ");
			//Print the values of all the attributes of this element
			for(int i=0; i < atts.getLength(); i++)
			{
				System.out.print(atts.getQName(i) + "=" + atts.getValue(i) + " ");
			}
			//Begin parsing of the current element
			if (qName == "rect") //If the element was a rectangle
			{
				int height = 0;
				int width = 0;
				int x = 0;
				int y = 0;			
				
				if (atts.getIndex("x") != -1)
				{
					x = Integer.decode(atts.getValue(atts.getIndex("x")));
				}
				
				if (atts.getIndex("y") != -1)
				{
					y = Integer.decode(atts.getValue(atts.getIndex("y")));
				}				
				
				if (atts.getIndex("height") != -1)
				{
					height = Integer.decode(atts.getValue(atts.getIndex("height")));
				}
				
				if (atts.getIndex("width") != -1)
				{
					width = Integer.decode(atts.getValue(atts.getIndex("width")));
				}
				
				if (atts.getIndex("fill") != -1)
				{
					fillColor = ParserHelper.getColor(atts.getValue(atts.getIndex("fill")));
				}
				
				if (atts.getIndex("stroke") != -1)
				{
					strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
				}
				
				if (atts.getIndex("stroke-width") != -1)
				{
					strokeWidth = Integer.decode(atts.getValue(atts.getIndex("stroke-width")));
				}

				toAdd = new Rectangle(x, y, height, width, fillColor, strokeColor, strokeWidth);
				plist.add(toAdd);
			}//End Rectangle
			else
			{
				if (qName == "ellipse")//If the element was an ellipse
				{
					int ry = 0;
					int rx = 0;
					int cx = 0;
					int cy = 0;
					
					if (atts.getIndex("cx") != -1)
					{
						cx = Integer.decode(atts.getValue(atts.getIndex("cx")));
					}
					
					if (atts.getIndex("cy") != -1)
					{
						cy = Integer.decode(atts.getValue(atts.getIndex("cy")));
					}
					
					if (atts.getIndex("rx") != -1)
					{
						rx = Integer.decode(atts.getValue(atts.getIndex("rx")));
					}
					
					if (atts.getIndex("ry") != -1)
					{
						ry = Integer.decode(atts.getValue(atts.getIndex("ry")));
					}
					
					if (atts.getIndex("fill") != -1)
					{
						fillColor = ParserHelper.getColor(atts.getValue(atts.getIndex("fill")));
					}
					
					if (atts.getIndex("stroke") != -1)
					{
						strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
					}
					
					if (atts.getIndex("stroke-width") != -1)
					{
						strokeWidth = Integer.decode(atts.getValue(atts.getIndex("stroke-width")));
					}
					
					toAdd = new Ellipse(cx - rx, cy - ry, ry * 2, rx * 2, fillColor, strokeColor, strokeWidth);
					plist.add(toAdd);
				}//End Ellipse
				else
				{
					if (qName == "line")//If the element was a line
					{
						int x1 = 0;
						int x2 = 0;
						int y1 = 0;
						int y2 = 0;
						
						if (atts.getIndex("x1") != -1)
						{
							x1 = Integer.decode(atts.getValue(atts.getIndex("x1")));
						}
						
						if (atts.getIndex("y1") != -1)
						{
							y1 = Integer.decode(atts.getValue(atts.getIndex("y1")));
						}
						
						
						if (atts.getIndex("x2") != -1)
						{
							x2 = Integer.decode(atts.getValue(atts.getIndex("x2")));
						}
						
						if (atts.getIndex("y2") != -1)
						{
							y2 = Integer.decode(atts.getValue(atts.getIndex("y2")));
						}
						
						if (atts.getIndex("stroke") != -1)
						{
							strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
						}
						toAdd = new Line(x1, y1, x2, y2, strokeColor);
						plist.add(toAdd);
					}//End line
					else
					{
						if (qName == "polyline") //If the element was a polyline
						{
							int[] yPoints = {0,0,0,0};
							int[] xPoints = {0,0,0,0};
							
							if (atts.getIndex("points") != -1)
							{
								yPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "y");
								xPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "x");
							}
							
							if (atts.getIndex("stroke") != -1)
							{
								strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
							}

							toAdd = new Polyline(xPoints, yPoints, xPoints.length, strokeColor);
							plist.add(toAdd);
						}//End polyline
						else
						{
							if (qName == "polygon") //If the element was a polygon
							{
								int[] yPoints = {0,0,0,0};
								int[] xPoints = {0,0,0,0};
								
								if (atts.getIndex("points") != -1)
								{
									yPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "y");
									xPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "x");
								}
								if (atts.getIndex("fill") != -1)
								{
									strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
								}

								if (atts.getIndex("fill") != -1)
								{
									strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
								}

								toAdd = new Polygon(xPoints, yPoints, xPoints.length, fillColor, strokeColor);
								plist.add(toAdd);
							}//End polygon
							else
							{
								if (qName == "circle") //If the element was a circle
								{
									int r = 0;//Radius of the circle
									int cx = 0;//x coordinate of the center of the circle
									int cy = 0;//y coordinate of the center of the circle
									
									if (atts.getIndex("cx") != -1)
									{
										cx = Integer.decode(atts.getValue(atts.getIndex("cx")));
									}
									
									if (atts.getIndex("cy") != -1)
									{
										cy = Integer.decode(atts.getValue(atts.getIndex("cy")));
									}
									
									if (atts.getIndex("r") != -1)
									{
										r = Integer.decode(atts.getValue(atts.getIndex("r")));
									}
									
									if (atts.getIndex("fill") != -1)
									{
										fillColor = ParserHelper.getColor(atts.getValue(atts.getIndex("fill")));
									}
									
									if (atts.getIndex("stroke") != -1)
									{
										strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
									}
									
									if (atts.getIndex("stroke-width") != -1)
									{
										strokeWidth = Integer.decode(atts.getValue(atts.getIndex("stroke-width")));
									}
									
									toAdd = new Ellipse(cx - r, cy - r, r * 2, r * 2, fillColor, strokeColor, strokeWidth);
									plist.add(toAdd);
								}//End Circle
								else
								{
									if (qName == "svg") //If the element was the svg element itself
									{
										if (atts.getIndex("width") != -1)
										{
											fwidth = ParserHelper.getMeasure(atts.getValue(atts.getIndex("width")));
										}
										
										if (atts.getIndex("height") != -1)
										{
											fheight = ParserHelper.getMeasure(atts.getValue(atts.getIndex("height")));
										}
									}//End svg
								}
							}
						}
					}
				}
			}
		}
		System.out.println();
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

}
