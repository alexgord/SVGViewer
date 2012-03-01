import java.util.ArrayList;


public class ArrayHelper
{
	/****************************************************************************
						convertToPrimitive Function
					Converts an ArrayList<Integer> to int[]        
	 ****************************************************************************/
	static int[] convertToPrimitive(ArrayList<Integer> al)
	{
		int[] r = new int[al.size()];
		for (int i = 0; i < al.size(); i++)
		{
			r[i] = al.get(i);
		}
		return r;
	}
}
