
public class Collatz 
{
	public static void main (String[] args)
	{
		long max = 0;
		long[] cycles = new long[5000000];
		for(long i = 1; i <= 5000000; i++)
		{
			long wtf = collatz(i, cycles);
			if(wtf > max)
			{
				System.out.println(i + ": " + wtf);
				max = wtf;
			}
		}
	}
	
	private static long collatz(long n, long[] cycles)
	{
		long max = 0;
		long maxI = 1;
		
		for(int i = 1; i <= n; i++)
		{
			long c;
			if(cycles[i] == 0)
			{
				//System.out.println("ojooijioj");
				c = 1;
				long fuck = i;
				while (fuck > 1)
				{
					if(fuck % 2 == 0)
						fuck = fuck/2;
					else
						fuck = (3 * fuck) + 1;
					++c;
				}
				cycles[i] = c;
			}
			else
				c = cycles[i];

			
			if(c >= max)
			{
				//System.out.println("guygu" + i);
				max = c;
				maxI = i;
			}
				
		}

		return maxI;
	}
}
