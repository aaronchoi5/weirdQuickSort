import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.lang.Integer;

public class ChoiHoendorfNicholsProgram6
{

	public static ArrayList<Integer> quicksort(ArrayList<Integer> array,ListIterator low, ListIterator high)
	{
		if (low.nextIndex() < high.nextIndex())
		{//partition
			ListIterator ipointer = array.listIterator(low.nextIndex());
			ListIterator jpointer = array.listIterator(high.nextIndex());
			
			int pivot = (int) ipointer.next();
			if (jpointer.hasNext()){
				jpointer.next();
			}
			ipointer.previous();
			
			int i = 0;
			int j = 0;
			while (true)
			{
				do 
				{
					i = (int) ipointer.next();
				} 
				while (i < pivot);
				
				do
				{
					j = (int) jpointer.previous();
					
				}
				while(j > pivot);
				if (ipointer.previousIndex() >=jpointer.nextIndex())
				{
					
					break;
				}
	
				ipointer.set(j);
				jpointer.set(i);
			}// below is questionable
			
			
			quicksort(array,array.listIterator(low.nextIndex()) ,array.listIterator(jpointer.nextIndex()));
			jpointer.next();
			quicksort(array,array.listIterator(jpointer.nextIndex()) ,high);
			//?
		
	}

		return array;
	}
	
	
	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();//will contain ints
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt())
		{
			list.add(scan.nextInt());
		}
		ListIterator loiter = list.listIterator();
		ListIterator hiiter = list.listIterator();
		
		while(hiiter.hasNext())
		{
			hiiter.next();
			
		}
	
		
		ArrayList returnlist = quicksort(list, list.listIterator(loiter.nextIndex()),list.listIterator(hiiter.nextIndex()));
		System.out.println(returnlist);
	}
}
