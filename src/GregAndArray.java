import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GregAndArray 
{	
	public static final int MAX = 100001;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long[] a = new long[scan.nextInt()];
		long[] a2 = new long[MAX];
		int opsLength = scan.nextInt();
		int[] l = new int[opsLength];
		int[] r = new int[opsLength];
		int[] d = new int[opsLength];
		int numQueries = scan.nextInt();
		int[] increments = new int[MAX];
		for (int ix = 0; ix < a.length; ix++)
			a[ix] = scan.nextInt();
		
		for (int lcv = 0; lcv < opsLength; lcv++)
		{
			l[lcv] = scan.nextInt();
			r[lcv] = scan.nextInt();
			d[lcv] = scan.nextInt();
		}

		for(int i = 0; i < numQueries; i++)
		{
			int start = scan.nextInt();
			int end = scan.nextInt();
			
			increments[start-1] += 1;
			increments[end] -= 1;
		}
		
		long c = 0;
		for(int o = 0; o < opsLength; o++)
		{
			c += increments[o];
			a2[l[o]-1] += (c * d[o]);
			a2[r[o]] -= (c * d[o]);
		}
		
		c = 0;
		for(int ax = 0; ax < a.length; ax++)
		{
			c += a2[ax];
			System.out.print(c + a[ax]);
			System.out.print(" ");

		}

		
	}
}
