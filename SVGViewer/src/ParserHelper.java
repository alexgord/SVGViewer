import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParserHelper
{
	/****************************************************************************
							getColor Function
		Function returns the equivalent color of a string of type (999,999,999)        
	 ****************************************************************************/
	public static Color getColor(String s)
	{
		if (s.equals("none"))
		{
			return null;
		}
		LinkedList<String> numbers = new LinkedList<String>();

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s); 
		while (m.find())
		{
			numbers.add(m.group());
			System.out.println("num: " + m.group());
		}
		return new Color(Integer.valueOf(numbers.get(0)), Integer.valueOf(numbers.get(1)), Integer.valueOf(numbers.get(2)));
	}

	/****************************************************************************
								getMeasure Function
		Function returns the integer value of a string of type 999px        
	 ****************************************************************************/
	public static int getMeasure(String s)
	{
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		m.find();
		return Integer.valueOf(m.group());
	}

	
	/****************************************************************************
								getPoints Function
			Function returns all the points from the specified axis.
			Inputed String s is in the format of 99,99 99,99 99,99 99,99
			Where each pair of numbers represents a point.
	 ****************************************************************************/
	public static int[] getPoints(String s, String axis)
	{
		ArrayList<Integer> yPoints = new ArrayList<Integer>();
		ArrayList<Integer> xPoints = new ArrayList<Integer>();
		LinkedList<String> numbers = new LinkedList<String>();		
		int[] r = null;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s); 
		m = p.matcher(s);
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
		if (axis.equals("x"))
		{
			r = ArrayHelper.convertToPrimitive(xPoints);
		}
		else
		{
			if (axis.equals("y"))
			{
				r = ArrayHelper.convertToPrimitive(yPoints);
			}
		}
		return r;
	}
}
