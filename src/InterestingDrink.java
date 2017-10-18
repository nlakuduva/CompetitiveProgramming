import java.util.*;

public class InterestingDrink 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int numShops = scan.nextInt();
		int[] prices = new int[numShops];
		for(int i = 0; i < prices.length; i++)
		{
			prices[i] = scan.nextInt();
		}
		Arrays.sort(prices);
		int numDays = scan.nextInt();
		for(int i = 0; i < numDays; i++)
		{
			int numCoins = scan.nextInt(); 
	
			if (prices.length-1 >= 0 && numCoins >= prices[prices.length-1])
				System.out.println(prices.length);
			else if (prices.length-2 >= 0 && numCoins >= prices[prices.length-2])
				System.out.println(prices.length-1);
			else if (prices.length-3 >= 0 && numCoins >= prices[prices.length-3])
				System.out.println(prices.length-2);
			else if (prices.length-4 >= 0 && numCoins >= prices[prices.length-4])
				System.out.println(prices.length-3);
			else if (prices.length-5 >= 0 && numCoins >= prices[prices.length-5])
				System.out.println(prices.length-4);
			else
			{
				int count = binarySearch(prices, 0, prices.length-1, numCoins, 0);
				System.out.println(count);
			}

		}
	}
	
	private static int binarySearch(int[] arr, int start, int end, int val, int dir)
	{
		if(end < start)
		{
			if (dir < 0)
				return start;
			else
				return end+1;
		}
			
			
		int middle = (start + end)/2;
		
		if(arr[middle] < val)
			return binarySearch(arr, middle+1, end, val, 1);
		else if(arr[middle] > val)
			return binarySearch(arr, start, middle-1, val, -1);
		else
		{
			int index = middle;
			while(index+1 < arr.length && arr[index] == arr[index+1])
			{
				middle++;
				index++;
			}
				
			return middle+1;
		}
			
	}
}
