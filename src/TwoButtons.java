import java.util.Scanner;

public class TwoButtons 
{
	
	public static void main(String[] args)
	{
//		Scanner scan = new Scanner(System.in);
//		int currentNum = scan.nextInt();
//		int futureNum = scan.nextInt();
//		
//		System.out.println(run(currentNum, futureNum));
		
		for(int i = 1; i <= 10; i++)
		{
			for(int m = 1; m <= 10; m++)
			{
				System.out.println("cur: " + i + " fut: " + m);
				System.out.println(run(i,m));
			}
		}
	}
	
	public static int run(int currentNum, int futureNum)
	{
		// blue button = subtract 1
		// red button = multiple by 2
		int pushCount = 0;
		
		while (currentNum != futureNum && currentNum > 0 && futureNum > 0)
		{
			System.out.print(currentNum + " ");
			if(futureNum < currentNum)
			{
				pushCount+= currentNum-futureNum;
				currentNum = futureNum;
			}
			else
			{
				if(futureNum >= (currentNum * 2 - 1))
				{
					currentNum = currentNum * 2;
					++pushCount;
				}
				else
				{
					--currentNum;
					++pushCount;
				}
			}
			
		}
		
		return pushCount;
	
	}

}
