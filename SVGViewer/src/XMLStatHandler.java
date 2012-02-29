import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.println("start <" + qName + "> element");
		if(atts.getLength() > 0) {
			System.out.print("\tattributes: ");
			for(int i=0; i < atts.getLength(); i++)
			{
				System.out.print(atts.getQName(i) + "=" + atts.getValue(i) + " ");
			}
			if (qName == "rect") //rect
			{
				int height;
				int width;
				int x;
				int y;
				int strokeWidth = 1;

				x = Integer.decode(atts.getValue(atts.getIndex("x")));
				y = Integer.decode(atts.getValue(atts.getIndex("y")));
				height = Integer.decode(atts.getValue(atts.getIndex("height")));
				width = Integer.decode(atts.getValue(atts.getIndex("width")));
				System.out.println("width: " + width);
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
			}
			else
			{
				if (qName == "ellipse")//ellipse
				{
					int ry;
					int rx;
					int cx;
					int cy;
					cx = Integer.decode(atts.getValue(atts.getIndex("cx")));
					cy = Integer.decode(atts.getValue(atts.getIndex("cy")));
					rx = Integer.decode(atts.getValue(atts.getIndex("rx")));
					ry = Integer.decode(atts.getValue(atts.getIndex("ry")));
					int strokeWidth = 0;
					//fillColor = Color.getColor(atts.getValue(4));//Color.blue;
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
				}
				else
				{
					if (qName == "line")//line
					{
						int x1;
						int x2;
						int y1;
						int y2;
						x1 = Integer.decode(atts.getValue(atts.getIndex("x1")));
						y1 = Integer.decode(atts.getValue(atts.getIndex("y1")));
						x2 = Integer.decode(atts.getValue(atts.getIndex("x2")));
						y2 = Integer.decode(atts.getValue(atts.getIndex("y2")));
						int strokeWidth = 1;
						if (atts.getIndex("stroke") != -1)
						{
							strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
						}
						toAdd = new Line(x1, y1, x2, y2, strokeColor);
						plist.add(toAdd);
					}
					else
					{
						if (qName == "polyline") //polyline
						{
							int[] yPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "y");
							int[] xPoints = ParserHelper.getPoints(atts.getValue(atts.getIndex("points")), "x");;
							if (atts.getIndex("stroke") != -1)
							{
								strokeColor = ParserHelper.getColor(atts.getValue(atts.getIndex("stroke")));
							}
							
							toAdd = new Polyline(xPoints, yPoints, xPoints.length, strokeColor);
							plist.add(toAdd);
						}
						else
						{
							if (qName == "polygon") //polygon
							{
								ArrayList<Integer> yPoints = new ArrayList<Integer>();
								ArrayList<Integer> xPoints = new ArrayList<Integer>();
								LinkedList<String> numbers = new LinkedList<String>();
								Pattern p;
								Matcher m;
								
								p = Pattern.compile("\\d+");
								
								if (!atts.getValue(0).equals("none"))								{
																	
									m = p.matcher(atts.getValue(0)); 
									while (m.find())
									{
									   numbers.add(m.group());
									}
									fillColor = new Color(Integer.valueOf(numbers.get(0)), Integer.valueOf(numbers.get(1)), Integer.valueOf(numbers.get(2)));
								}
								
								numbers.clear();
								if (!atts.getValue(1).equals("none"))
								{
									m = p.matcher(atts.getValue(1)); 
									while (m.find())
									{
									   numbers.add(m.group());
									}
									strokeColor = new Color(Integer.valueOf(numbers.get(0)), Integer.valueOf(numbers.get(1)), Integer.valueOf(numbers.get(2)));
								}
								
								m = p.matcher(atts.getValue(2));
								numbers.clear();
								while (m.find())
								{
								   numbers.add(m.group());
								}
								
								for (int i = 0; i < numbers.size(); i++)
								{
									if (i % 2 == 0)
									{
										xPoints.add(Integer.valueOf(numbers.get(i)));
									}
									else
									{
										yPoints.add(Integer.valueOf(numbers.get(i)));
									}
								}
								
								toAdd = new Polygon(ArrayHelper.convertToPrimitive(xPoints), ArrayHelper.convertToPrimitive(yPoints), xPoints.size(), fillColor, strokeColor);
								plist.add(toAdd);
							}
							else
							{
								if (qName == "circle") //circle
								{
									int r;
									int cx;
									int cy;
									cx = Integer.decode(atts.getValue(0));
									cy = Integer.decode(atts.getValue(1));
									r = Integer.decode(atts.getValue(2));;
									int strokeWidth = 1;
									//fillColor = Color.getColor(atts.getValue(4));//Color.blue;
									LinkedList<String> numbers = new LinkedList<String>();
									Pattern p;
									Matcher m;
									if (!atts.getValue(3).equals("none"))
									{
										p = Pattern.compile("\\d+");
										m = p.matcher(atts.getValue(3)); 
										while (m.find())
										{
										   numbers.add(m.group());
										}
										fillColor = new Color(Integer.valueOf(numbers.get(0)), Integer.valueOf(numbers.get(1)), Integer.valueOf(numbers.get(2)));
									}
									if (atts.getLength() >= 4)
									{
										if (!atts.getValue(4).toString().equals("none"))
										{
											p = Pattern.compile("\\d+");
											m = p.matcher(atts.getValue(4));
											numbers = new LinkedList<String>();
											while (m.find())
											{
											   numbers.add(m.group());
											}
											strokeColor = new Color(Integer.valueOf(numbers.get(0)), Integer.valueOf(numbers.get(1)), Integer.valueOf(numbers.get(2)));
										}
																
									}
									else
									{
										//strokeColor = null;
									}
									if (atts.getLength() > 5)
									{
										if (!atts.getValue(5).toString().equals("none"))
										{
											strokeWidth = Integer.decode(atts.getValue(5));
										}
									}
									else
									{
										strokeWidth = 1;
									}
									System.err.println("Stroke width: " + strokeWidth);
									toAdd = new Ellipse(cx - r, cy - r, r * 2, r * 2, fillColor, strokeColor, strokeWidth);
									plist.add(toAdd);
								}
							}
						}
					}
				}
			}
			//System.out.println();
		}
		System.out.println();
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
