import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AirportCodes 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++)
		{
			int numP = scan.nextInt();
			String[] priority = new String[numP];
			for(int x = 0; x < numP; x++)
			{
				priority[x] = scan.next();
			}
			
			int numN = scan.nextInt();
			ArrayList<String> normal = new ArrayList<String>(numN);
			for(int y = 0; y < numN; y++)
			{
				normal.add(scan.next());
			}
			
			Arrays.sort(priority);
			Collections.sort(normal);
			for(String s : priority)
			{
				if(normal.contains(s))
				{
					normal.remove(s);
					System.out.println(s);
				}
					
				
			}
			for(String s : normal)
				System.out.println(s);
			
		}
	}
}
