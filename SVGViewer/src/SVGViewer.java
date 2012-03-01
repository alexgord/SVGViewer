/***************************************ID BLOCK***********************************************

	Due Date:			March 1st, 2012
	Software Designer:	Alexandre Simard
	Course:				420-603  Winter 2012
	Deliverable:		Assignment #2 --- Vector Graphics
	Description:		This program reads in the url or file path of an svg file
						from the command line and parses the contents of the file.
						The program then displays the svg elements on the screen.

 ******************************************************************************************************/

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
		System.out.println("Path: " + args[0]);
		String uri = args[0]; //
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
