import java.util.Arrays;
import java.util.Scanner;

public class Overbooked 
{
	public static void main(String[] args)
	{
		// A B C D E F = 6 Letters
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++)
		{
			int numPB = scan.nextInt();
			int numPA = scan.nextInt();
			int numBye = numPB-numPA;
			int[] prices = new int[numPB];
			for(int x = 0; x < numPB; x++)
				prices[x] = scan.nextInt();
			Arrays.sort(prices);
			int min = 0;
			for(int n = 0; n < numBye; n++)
				min += prices[n];
			System.out.println(min);
		}
	}
}
