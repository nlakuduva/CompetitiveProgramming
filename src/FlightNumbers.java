import java.util.Arrays;
import java.util.Scanner;

public class FlightNumbers 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long testCases = scan.nextInt();
		for (long i = 0; i < testCases; i++)
		{
			long numF = scan.nextInt();
			long overall = 0;
			for(int x = 0; x < numF; x++)
			{
				long num = scan.nextLong();
				long log = (long) Math.floor(Math.log(num)/Math.log(2));
				if(Math.pow(2, log) == num && num != 0)
				{
					++overall;
				}
			}
			System.out.println(overall);

				
		}
	}

}
