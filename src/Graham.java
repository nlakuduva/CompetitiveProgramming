import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Graham 
{
	
	public static class Equation
	{
		double m;
		double b;
		
		public Equation(double m, double b)
		{
			this.m = m;
			this.b = b;
		}

		@Override
		public boolean equals(Object o) 
		{
			Equation o2 = (Equation) o;
			if (this.b == o2.b && this.m == (o2.m))
				return true;
			else
				return false;
		}
		
		public String toString()
		{
			return m + ":" + b;
		}
	}
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int st = scan.nextInt();
		int[][] points = new int[st+1][2];
		for (int x = 0; x <= st; x++)
		{
			int[] tmp = {scan.nextInt(), scan.nextInt()};
			points[x] = tmp;
		}
//		for (int[] pt : points)
//			System.out.println(Arrays.toString(pt));
		
		System.out.println(findMinShots(points[0], points));
	}
	
	private static int findMinShots(int[] gun, int[][] points)
	{		
		if (points.length == 2)
			return 1;
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		for(int i = 1; i < points.length; i++)
		{
			boolean found = false;
			for (int[] pt : list)
			{
				if(orientation(gun, points[i], pt) == 0)
					found = true;
					
			}
			if (found == false)
				list.add(points[i]);
		}
			
		return list.size();
			
	}
	
	private static int orientation(int[] p, int[] q, int[] r)
	{
	    int val = (q[1] - p[1]) * (r[0] - q[0]) -
	              (q[0] - p[0]) * (r[1] - q[1]);
	 
	    if (val == 0) 
	    	return 0;
	    else if(val > 0)
	    	return 1;
	    else
	    	return -1;
	}


}
