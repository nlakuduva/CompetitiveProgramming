import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SantaClaus 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		santa(n, list);
		System.out.println(list.size());
		for(int x : list)
			System.out.print(x + " ");
		
	}

	private static void santa (int n, List<Integer> list)
	{
		int min = 1;
		while (n > 0)
		{
			if(list.contains(min) == false && min <= n)
			{
				list.add(min);
				n -= min;
				++min;

			}
			else
				break;
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			int num = list.get(i);

			if(!list.contains(num + n))
			{
				list.remove(i);
				list.add(num+n);
				break;
			}
		}


	}
}
