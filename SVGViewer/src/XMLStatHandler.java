import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLStatHandler implements ErrorHandler, ContentHandler
{

	  private boolean error;
	  
	  public boolean hasError() { return error; }
	  
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
	  System.out.println("start <" + qName + "> element");
	  if(atts.getLength() > 0) {
	    System.out.print("\tattributes: ");
	    for(int i=0; i < atts.getLength(); i++)
	      System.out.print(atts.getQName(i) + "=" + atts.getValue(i) + " ");
	    System.out.println();
	  }  
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
