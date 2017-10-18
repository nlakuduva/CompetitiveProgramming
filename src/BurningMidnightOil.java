import java.util.*;

public class BurningMidnightOil 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int lines = scan.nextInt();
		int k = scan.nextInt();
		int count = 0;
		int v = (int) Math.ceil((double)lines/k);
		System.out.println(v);
		while (lines > 0 )
		{
			v = v/((int)Math.pow(v, count));
			lines -=v;
			++count;
		}
		
	}
}
