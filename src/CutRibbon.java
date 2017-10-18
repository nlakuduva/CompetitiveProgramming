import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CutRibbon 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int weight = scan.nextInt();
		int[] rocks = new int[3];
		for(int i = 0; i < 3; i++)
		{
			rocks[i] = scan.nextInt();
		}
		//Arrays.sort(rocks);
		
		//int minVal = rocks[0];
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>(weight);
		System.out.println(DP(weight, rocks, cache));
	}
	
	public static int DP(int L, int[] rocks, Map<Integer, Integer> cache)
	{
		if (cache.containsKey(L))
			return cache.get(L);
		else if (L == 0)
        	return 0;
	    else if (L < 0)
	    	return -1;

		int val = 0;
	    int x = DP(L-rocks[0], rocks, cache);
	    int y = DP(L-rocks[1], rocks, cache);
	    int z = DP(L-rocks[2], rocks, cache);
	    
	    if (x < 0 && y < 0 && z < 0)
	       val = -1;
	    else
	    {
		    val = Math.max(x, y);
		    val = Math.max(val, z);
		    val += 1;
		    
	    }
	    
	    cache.put(L, val);
	    return val;
	        

	
	    
	}
}
